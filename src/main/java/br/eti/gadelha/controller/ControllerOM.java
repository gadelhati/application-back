package br.eti.gadelha.controller;

import br.eti.gadelha.persistence.dto.request.DTORequestOM;
import br.eti.gadelha.persistence.dto.response.DTOResponseOM;
import br.eti.gadelha.persistence.repository.RepositoryOM;
import br.eti.gadelha.services.ServiceOM;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController @RequestMapping("/om")
@CrossOrigin(origins = "*", maxAge = 3600)
public class ControllerOM implements ControllerInterface<DTOResponseOM, DTORequestOM> {

    private final ServiceOM serviceOM;

    public ControllerOM(RepositoryOM repository) {
        this.serviceOM = new ServiceOM(repository) {};
    }

    @PostMapping("") @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity<DTOResponseOM> create(@RequestBody @Valid DTORequestOM created){
        try {
            return new ResponseEntity<>(serviceOM.create(created), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/retrieve")
    public List<DTOResponseOM> retrieve(){
        return serviceOM.retrieve();
    }
    @GetMapping("") @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity<Page<DTOResponseOM
            >> retrieve(Pageable pageable){
        return new ResponseEntity<>(serviceOM.retrieve(pageable), HttpStatus.OK);
    }
    @GetMapping("/{id}") @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity<DTOResponseOM> retrieve(@PathVariable UUID id){
        try {
            return new ResponseEntity<>(serviceOM.retrieve(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/source") @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity<Page<DTOResponseOM>> retrieve(Pageable pageable, @RequestParam(required = false) String q){
        try {
            return new ResponseEntity<>(serviceOM.retrieveSource(pageable, q), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PutMapping("/{id}") @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity<DTOResponseOM> update(@PathVariable("id") UUID id, @RequestBody @Valid DTORequestOM updated){
        try {
            return new ResponseEntity<>(serviceOM.update(id, updated), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @DeleteMapping("/{id}") @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity<DTOResponseOM> delete(@PathVariable UUID id){
        try {
            return new ResponseEntity<>(serviceOM.delete(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @DeleteMapping("") @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity<HttpStatus> delete(){
        try {
            serviceOM.delete();
            return new ResponseEntity<>(null, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}