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

    public ControllerSynopticObservation(RepositorySynopticObservation repository/*, RepositoryFile repositoryFile*/) {
        this.service = new ServiceSynopticObservation(repository) {};
    }
    @PostMapping("") @PreAuthorize("hasAnyRole('USER', 'MODERATOR', 'ADMIN', 'OPERATOR', 'RECTIFIER')")
    public ResponseEntity<DTOResponseSynopticObservation> create(@RequestBody @Valid DTORequestSynopticObservation created){
        System.out.println("1");
        try {
            System.out.println("2");
            return new ResponseEntity<>(service.create(created), HttpStatus.CREATED);
        } catch (Exception e) {
            System.out.println(e);
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PostMapping("/createAll") @PreAuthorize("hasAnyRole('USER', 'MODERATOR', 'ADMIN', 'OPERATOR', 'RECTIFIER')")
    public ResponseEntity<List<DTOResponseSynopticObservation>> create(@RequestBody @Valid List<DTORequestSynopticObservation> createds){
        System.out.println("all 1");
        try {
            System.out.println("all 2");
            return new ResponseEntity<>(service.create(createds), HttpStatus.CREATED);
        } catch (Exception e) {
            System.out.println("all 8");
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
//        List<DTOResponseSynopticObservation> dtoResponseSynopticObservationsCreated = new ArrayList<>();
//        List<DTOResponseSynopticObservation> dtoResponseSynopticObservationsFailed = new ArrayList<>();
//        for(DTORequestSynopticObservation dtoRequestSynopticObservation : createds) {
//            try {
////                service.create(dtoRequestSynopticObservation);
//                create(dtoRequestSynopticObservation);
//                dtoResponseSynopticObservationsCreated.add(new DTOResponseSynopticObservation().toDTO(dtoRequestSynopticObservation.toObject()));
//            } catch (Exception e) {
//                dtoResponseSynopticObservationsFailed.add(new DTOResponseSynopticObservation().toDTO(dtoRequestSynopticObservation.toObject()));
//            }
//        }
//        if(!dtoResponseSynopticObservationsCreated.isEmpty()){
//            return new ResponseEntity<>(dtoResponseSynopticObservationsCreated, HttpStatus.CREATED);
//        } else {
//            return new ResponseEntity<>(dtoResponseSynopticObservationsFailed, HttpStatus.INTERNAL_SERVER_ERROR);
//        }
    }
    @GetMapping("/retrieve")
    public List<DTOResponseSynopticObservation> retrieve(){
        return service.retrieve();
    }
    @GetMapping("")
    public ResponseEntity<Page<DTOResponseSynopticObservation>> retrieve(Pageable pageable){
        return new ResponseEntity<>(service.retrieve(pageable), HttpStatus.FOUND);
    }
    @GetMapping("/{id}") @PreAuthorize("hasAnyRole('USER', 'MODERATOR', 'ADMIN', 'OPERATOR', 'RECTIFIER')")
    public ResponseEntity<DTOResponseSynopticObservation> retrieve(@PathVariable UUID id){
        try {
            return new ResponseEntity<>(service.retrieve(id), HttpStatus.FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/source")
    public ResponseEntity<Page<DTOResponseSynopticObservation>> retrieve(Pageable pageable, @RequestParam(required = false) String q){
        try {
            return new ResponseEntity<>(service.retrieveSource(pageable, q), HttpStatus.FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
    @PutMapping("/{id}") @PreAuthorize("hasAnyRole('USER', 'MODERATOR', 'ADMIN', 'OPERATOR', 'RECTIFIER')")
    public ResponseEntity<DTOResponseSynopticObservation> update(@PathVariable("id") UUID id, @RequestBody @Valid DTORequestSynopticObservation updated){
        try {
            return new ResponseEntity<>(service.update(id, updated), HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @DeleteMapping("/{id}") @PreAuthorize("hasAnyRole('MODERATOR', 'ADMIN', 'RECTIFIER')")
    public ResponseEntity<DTOResponseSynopticObservation> delete(@PathVariable UUID id){
        try {
            return new ResponseEntity<>(service.delete(id), HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @DeleteMapping("") @PreAuthorize("hasAnyRole('MODERATOR', 'ADMIN', 'RECTIFIER')")
    public ResponseEntity<HttpStatus> delete(){
        try {
            service.delete();
            return new ResponseEntity<>(null, HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}