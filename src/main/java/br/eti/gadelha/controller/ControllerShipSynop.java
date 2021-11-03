package br.eti.gadelha.controller;

import br.eti.gadelha.persistence.dto.request.DTORequestFile;
import br.eti.gadelha.persistence.dto.request.DTORequestShipSynop;
import br.eti.gadelha.persistence.dto.response.DTOResponseShipSynop;
import br.eti.gadelha.persistence.model.File;
import br.eti.gadelha.persistence.repository.RepositoryFile;
import br.eti.gadelha.persistence.repository.RepositoryShipSynop;
import br.eti.gadelha.services.ServiceFile;
import br.eti.gadelha.services.ServiceFileStorage;
import br.eti.gadelha.services.ServiceShipSynop;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.UUID;

/**
 * @author	Marcelo Ribeiro Gadelha
 * @mail	gadelha.ti@gmail.com
 * @since	04/08/2021
 * @version 1.0
 * @link	www.gadelha.eti.br
 **/

@RestController
@RequestMapping("/shipsynop")
@CrossOrigin(origins = "*", maxAge = 3600)
public class ControllerShipSynop {

    private final ServiceShipSynop service;
    private final ServiceFile serviceFile;
    @Autowired
    private ServiceFileStorage fileStorageService;

    public ControllerShipSynop(RepositoryShipSynop repository, RepositoryFile repositoryFile) {
        this.service = new ServiceShipSynop(repository) {};
        this.serviceFile = new ServiceFile(repositoryFile) {};
    }

    @PostMapping("") @PreAuthorize("hasAnyRole('USER', 'MODERATOR', 'ADMIN', 'OPERATOR', 'RECTIFIER')")
    public ResponseEntity<DTOResponseShipSynop> create(@RequestBody @Valid DTORequestShipSynop created){
        try {
            return new ResponseEntity<>(service.create(created), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/retrieve") @PreAuthorize("hasAnyRole('USER', 'MODERATOR', 'ADMIN', 'OPERATOR', 'RECTIFIER')")
    public List<DTOResponseShipSynop> retrieveAll(){
        return service.retrieveAll();
    }

    @GetMapping("") @PreAuthorize("hasAnyRole('USER', 'MODERATOR', 'ADMIN', 'OPERATOR', 'RECTIFIER')")
    public ResponseEntity<Page<DTOResponseShipSynop>> retrieve(Pageable pageable){
        return new ResponseEntity<>(service.retrieve(pageable), HttpStatus.FOUND);
    }
    @GetMapping("/{id}") @PreAuthorize("hasAnyRole('USER', 'MODERATOR', 'ADMIN', 'OPERATOR', 'RECTIFIER')")
    public ResponseEntity<DTOResponseShipSynop> retrieve(@PathVariable UUID id){
        try {
            return new ResponseEntity<>(service.retrieve(id), HttpStatus.FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/source") @PreAuthorize("hasAnyRole('USER', 'MODERATOR', 'ADMIN', 'OPERATOR', 'RECTIFIER')")
    public ResponseEntity<Page<DTOResponseShipSynop>> retrieveSource(Pageable pageable, @RequestParam(required = false) String q){
        try {
            return new ResponseEntity<>(service.retrieveSource(pageable, q), HttpStatus.FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PutMapping("/{id}") @PreAuthorize("hasAnyRole('USER', 'MODERATOR', 'ADMIN', 'OPERATOR', 'RECTIFIER')")
    public ResponseEntity<DTOResponseShipSynop> update(@PathVariable("id") UUID id, @RequestBody @Valid DTORequestShipSynop updated){
        try {
            return new ResponseEntity<>(service.update(id, updated), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/{id}") @PreAuthorize("hasAnyRole('USER', 'MODERATOR', 'ADMIN', 'RECTIFIER')")
    public ResponseEntity<HttpStatus> delete(@PathVariable UUID id){
        try {
            service.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("") @PreAuthorize("hasAnyRole('USER', 'MODERATOR', 'ADMIN', 'RECTIFIER')")
    public ResponseEntity<HttpStatus> delete(){
        try {
            service.delete();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PostMapping("/upload") @PreAuthorize("hasAnyRole('USER', 'MODERATOR', 'ADMIN', 'OPERATOR', 'RECTIFIER')")
    public File upload(@RequestParam (value="file") MultipartFile file) {
        String fileName = fileStorageService.storeFile(file);
        interpret(fileName, file.getContentType(), file.getSize());
        return new File(fileName, file.getContentType(), file.getSize());
    }
    public void interpret(String fileName, String fileType, Long fileSize) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        ObjectMapper mapper = new ObjectMapper();
        mapper.setDateFormat(simpleDateFormat);
        mapper.configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true);
        try {
            List<DTORequestShipSynop> dtoRequestShipSynops = mapper.readerForListOf(DTORequestShipSynop.class).readValue(new java.io.File("./uploads/" + fileName));
            DTORequestFile dtoRequestFile = new DTORequestFile(fileName, fileType, fileSize);
            serviceFile.create(dtoRequestFile);
            for( DTORequestShipSynop dtoRequestShipSynop : dtoRequestShipSynops ) {
                List<DTOResponseShipSynop> dtoResponseShipSynops = service.retrieveByEstacao(dtoRequestShipSynop.getEstacao());
                boolean controle = true;
                for (DTOResponseShipSynop dtoResponseShipSynop: dtoResponseShipSynops) {
                    if (dtoRequestShipSynop.getDataObservacao() != null && dtoResponseShipSynop.getDataObservacao() != null){
                        if (simpleDateFormat.format(dtoRequestShipSynop.getDataObservacao()).equals(simpleDateFormat.format(dtoResponseShipSynop.getDataObservacao())) && dtoRequestShipSynop.getGg().equals(dtoResponseShipSynop.getGg())) {
                            controle = false;
                        }
                    }
                }
                if (controle){
//                    dtoRequestShipSynop.setFile(dtoRequestFile.toObject());
                    service.create(dtoRequestShipSynop);
                }
            }
        } catch (JsonGenerationException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}