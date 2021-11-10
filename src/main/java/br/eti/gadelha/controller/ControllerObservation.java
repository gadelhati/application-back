package br.eti.gadelha.controller;

import br.eti.gadelha.persistence.dto.request.DTORequestFile;
import br.eti.gadelha.persistence.dto.request.DTORequestObservation;
import br.eti.gadelha.persistence.dto.response.DTOResponseObservation;
import br.eti.gadelha.persistence.model.File;
import br.eti.gadelha.persistence.repository.RepositoryFile;
import br.eti.gadelha.persistence.repository.RepositoryObservation;
import br.eti.gadelha.services.ServiceFile;
import br.eti.gadelha.services.ServiceFileStorage;
import br.eti.gadelha.services.ServiceObservation;
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
@RequestMapping("/observation")
@CrossOrigin(origins = "*", maxAge = 3600)
public class ControllerObservation {

    private final ServiceObservation service;
    private final ServiceFile serviceFile;
    @Autowired
    private ServiceFileStorage fileStorageService;

    public ControllerObservation(RepositoryObservation repository, RepositoryFile repositoryFile) {
        this.service = new ServiceObservation(repository) {};
        this.serviceFile = new ServiceFile(repositoryFile) {};
    }

    @PostMapping("") @PreAuthorize("hasAnyRole('USER', 'MODERATOR', 'ADMIN', 'OPERATOR', 'RECTIFIER')")
    public ResponseEntity<DTOResponseObservation> create(@RequestBody @Valid DTORequestObservation created){
        try {
            return new ResponseEntity<>(service.create(created), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/retrieve") @PreAuthorize("hasAnyRole('USER', 'MODERATOR', 'ADMIN', 'OPERATOR', 'RECTIFIER')")
    public List<DTOResponseObservation> retrieveAll(){
        return service.retrieveAll();
    }

    @GetMapping("") @PreAuthorize("hasAnyRole('USER', 'MODERATOR', 'ADMIN', 'OPERATOR', 'RECTIFIER')")
    public ResponseEntity<Page<DTOResponseObservation>> retrieve(Pageable pageable){
        return new ResponseEntity<>(service.retrieve(pageable), HttpStatus.FOUND);
    }
    @GetMapping("/{id}") @PreAuthorize("hasAnyRole('USER', 'MODERATOR', 'ADMIN', 'OPERATOR', 'RECTIFIER')")
    public ResponseEntity<DTOResponseObservation> retrieve(@PathVariable UUID id){
        try {
            return new ResponseEntity<>(service.retrieve(id), HttpStatus.FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/source") @PreAuthorize("hasAnyRole('USER', 'MODERATOR', 'ADMIN', 'OPERATOR', 'RECTIFIER')")
    public ResponseEntity<Page<DTOResponseObservation>> retrieveSource(Pageable pageable, @RequestParam(required = false) String q){
        try {
            return new ResponseEntity<>(service.retrieveSource(pageable, q), HttpStatus.FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PutMapping("/{id}") //@PreAuthorize("hasAnyRole('USER', 'MODERATOR', 'ADMIN', 'OPERATOR', 'RECTIFIER')")
    public ResponseEntity<DTOResponseObservation> update(@PathVariable("id") UUID id, @RequestBody @Valid DTORequestObservation updated){
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
//        interpret(fileName, file.getContentType(), file.getSize());
        return new File(fileName, file.getContentType(), file.getSize());
    }
//    public void interpret(String fileName, String fileType, Long fileSize) {
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
//        ObjectMapper mapper = new ObjectMapper();
//        mapper.setDateFormat(simpleDateFormat);
//        mapper.configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true);
//        try {
//            List<DTORequestObservation> dtoRequestObservations = mapper.readerForListOf(DTORequestObservation.class).readValue(new java.io.File("./uploads/" + fileName));
//            DTORequestFile dtoRequestFile = new DTORequestFile(fileName, fileType, fileSize);
//            serviceFile.create(dtoRequestFile);
//            for( DTORequestObservation dtoRequestObservation : dtoRequestObservations ) {
//                List<DTOResponseObservation> dtoResponseObservations = service.retrieveByEstacao(dtoRequestObservation.getEstacao());
//                boolean controle = true;
//                for (DTOResponseObservation dtoResponseObservation: dtoResponseObservations) {
//                    if (dtoRequestObservation.getDataObservacao() != null && dtoResponseObservation.getDataObservacao() != null){
//                        if (simpleDateFormat.format(dtoRequestObservation.getDataObservacao()).equals(simpleDateFormat.format(dtoResponseObservation.getDataObservacao())) && dtoRequestObservation.getGg().equals(dtoResponseObservation.getGg())) {
//                            controle = false;
//                        }
//                    }
//                }
//                if (controle){
////                    dtoRequestObservation.setFile(dtoRequestFile.toObject());
//                    service.create(dtoRequestObservation);
//                }
//            }
//        } catch (JsonGenerationException e) {
//            e.printStackTrace();
//        } catch (JsonMappingException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
}