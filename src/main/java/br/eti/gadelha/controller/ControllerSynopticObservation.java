package br.eti.gadelha.controller;

import br.eti.gadelha.persistence.dto.request.DTORequestSynopticObservation;
import br.eti.gadelha.persistence.dto.response.DTOResponseSynopticObservation;
import br.eti.gadelha.persistence.repository.RepositorySynopticObservation;
import br.eti.gadelha.services.ServiceSynopticObservation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/synopticObservation")
@CrossOrigin(origins = "*", maxAge = 3600)
public class ControllerSynopticObservation {

    private final ServiceSynopticObservation service;
//    private final ServiceFile serviceFile;
//    @Autowired
//    private ServiceFileStorage fileStorageService;

    public ControllerSynopticObservation(RepositorySynopticObservation repository/*, RepositoryFile repositoryFile*/) {
        this.service = new ServiceSynopticObservation(repository) {};
//        this.serviceFile = new ServiceFile(repositoryFile) {};
    }
    @PostMapping("") @PreAuthorize("hasAnyRole('USER', 'MODERATOR', 'ADMIN', 'OPERATOR', 'RECTIFIER')")
    public ResponseEntity<DTOResponseSynopticObservation> create(@RequestBody @Valid DTORequestSynopticObservation created){
        try {
            return new ResponseEntity<>(service.create(created), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PostMapping("/createAll") @PreAuthorize("hasAnyRole('USER', 'MODERATOR', 'ADMIN', 'OPERATOR', 'RECTIFIER')")
    public List<DTOResponseSynopticObservation> createAll(@RequestBody @Valid List<DTORequestSynopticObservation> createds){
        return service.create(createds);
//        try {
//            return new ResponseEntity<>(service.create(createds), HttpStatus.CREATED);
//        } catch (Exception e) {
//            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
//        }
    }
    @GetMapping("/retrieve")
    public List<DTOResponseSynopticObservation> retrieveAll(){
        return service.retrieve();
    }
    @GetMapping("")
    public ResponseEntity<Page<DTOResponseSynopticObservation>> retrieve(Pageable pageable){
        return new ResponseEntity<>(service.retrieve(pageable), HttpStatus.OK);
    }
    @GetMapping("/{id}") @PreAuthorize("hasAnyRole('USER', 'MODERATOR', 'ADMIN', 'OPERATOR', 'RECTIFIER')")
    public ResponseEntity<DTOResponseSynopticObservation> retrieve(@PathVariable UUID id){
        try {
            return new ResponseEntity<>(service.retrieve(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/source")
    public ResponseEntity<Page<DTOResponseSynopticObservation>> retrieveSource(Pageable pageable, @RequestParam(required = false) String q){
        try {
            return new ResponseEntity<>(service.retrieveSource(pageable, q), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PutMapping("/{id}") @PreAuthorize("hasAnyRole('USER', 'MODERATOR', 'ADMIN', 'OPERATOR', 'RECTIFIER')")
    public ResponseEntity<DTOResponseSynopticObservation> update(@PathVariable("id") UUID id, @RequestBody @Valid DTORequestSynopticObservation updated){
        try {
            return new ResponseEntity<>(service.update(id, updated), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @DeleteMapping("/{id}") @PreAuthorize("hasAnyRole('MODERATOR', 'ADMIN', 'RECTIFIER')")
    public ResponseEntity<DTOResponseSynopticObservation> delete(@PathVariable UUID id){
        try {
            return new ResponseEntity<>(service.delete(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @DeleteMapping("") @PreAuthorize("hasAnyRole('MODERATOR', 'ADMIN', 'RECTIFIER')")
    public ResponseEntity<HttpStatus> delete(){
        try {
            service.delete();
            return new ResponseEntity<>(null, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
//    @PostMapping("/upload") @PreAuthorize("hasAnyRole('USER', 'MODERATOR', 'ADMIN', 'OPERATOR', 'RECTIFIER')")
//    public File upload(@RequestParam (value="file") MultipartFile file) {
//        String fileName = fileStorageService.storeFile(file);
//        interpret(fileName, file.getContentType(), file.getSize());
//        return new File(fileName, file.getContentType(), file.getSize());
//    }
//    public void interpret(String fileName, String fileType, Long fileSize) {
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
//        ObjectMapper mapper = new ObjectMapper();
//        mapper.setDateFormat(simpleDateFormat);
//        mapper.configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true);
//        try {
//            List<DTORequestSynopticObservation> dtoRequestSynopticObservations = mapper.readerForListOf(DTORequestSynopticObservation.class).readValue(new java.io.File("./uploads/" + fileName));
//            DTORequestFile dtoRequestFile = new DTORequestFile(fileName, fileType, fileSize);
//            serviceFile.create(dtoRequestFile);
//            for( DTORequestSynopticObservation dtoRequestSynopticObservation : dtoRequestSynopticObservations) {
//                List<DTOResponseSynopticObservation> dtoResponseSynopticObservations = service.retrieve();
//                boolean controle = true;
//                for (DTOResponseSynopticObservation dtoResponseSynopticObservation : dtoResponseSynopticObservations) {
//                    if (dtoRequestSynopticObservation.getDataObservacao() != null && dtoResponseSynopticObservation.getDataObservacao() != null){
//                        if (simpleDateFormat.format(dtoRequestSynopticObservation.getDataObservacao()).equals(simpleDateFormat.format(dtoResponseSynopticObservation.getDataObservacao())) && dtoRequestSynopticObservation.getGg().equals(dtoResponseSynopticObservation.getGg())) {
//                            controle = false;
//                        }
//                    }
//                }
//                if (controle){
//                    create(dtoRequestSynopticObservation);
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