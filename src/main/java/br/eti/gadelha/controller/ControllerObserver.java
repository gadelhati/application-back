package br.eti.gadelha.controller;

import br.eti.gadelha.persistence.payload.request.DTORequestObserver;
import br.eti.gadelha.persistence.payload.response.DTOResponseObserver;
import br.eti.gadelha.persistence.repository.RepositoryObserver;
import br.eti.gadelha.services.ServiceObserver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController @RequestMapping("/observer")
@CrossOrigin(origins = "*", maxAge = 3600)
public class ControllerObserver implements ControllerInterface<DTOResponseObserver, DTORequestObserver> {

    @Autowired
    private final ServiceObserver serviceObserver;

    public ControllerObserver(RepositoryObserver repository) {
        this.serviceObserver = new ServiceObserver(repository) {};
    }

    @PostMapping("") @PreAuthorize("hasAnyRole('MODERATOR', 'ADMIN')")
    public ResponseEntity<DTOResponseObserver> create(@RequestBody @Valid DTORequestObserver created){
        try {
            return new ResponseEntity<>(serviceObserver.create(created), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/retrieve")
    public List<DTOResponseObserver> retrieve(){
        return serviceObserver.retrieve();
    }
    @GetMapping("") @PreAuthorize("hasAnyRole('MODERATOR', 'ADMIN')")
    public ResponseEntity<Page<DTOResponseObserver>> retrieve(Pageable pageable){
        return new ResponseEntity<>(serviceObserver.retrieve(pageable), HttpStatus.FOUND);
    }
    @GetMapping("/{id}") @PreAuthorize("hasAnyRole('MODERATOR', 'ADMIN')")
    public ResponseEntity<DTOResponseObserver> retrieve(@PathVariable UUID id){
        try {
            return new ResponseEntity<>(serviceObserver.retrieve(id), HttpStatus.FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/source") @PreAuthorize("hasAnyRole('MODERATOR', 'ADMIN')")
    public ResponseEntity<Page<DTOResponseObserver>> retrieve(Pageable pageable, @RequestParam(required = false) String q){
        try {
            return new ResponseEntity<>(serviceObserver.retrieve(pageable, q), HttpStatus.FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PutMapping("/{id}") @PreAuthorize("hasAnyRole('MODERATOR', 'ADMIN')")
    public ResponseEntity<DTOResponseObserver> update(@PathVariable("id") UUID id, @RequestBody @Valid DTORequestObserver updated){
        try {
            return new ResponseEntity<>(serviceObserver.update(id, updated), HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @DeleteMapping("/{id}") @PreAuthorize("hasAnyRole('MODERATOR', 'ADMIN')")
    public ResponseEntity<DTOResponseObserver> delete(@PathVariable UUID id){
        try {
            return new ResponseEntity<>(serviceObserver.delete(id), HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @DeleteMapping("") @PreAuthorize("hasAnyRole('MODERATOR', 'ADMIN')")
    public ResponseEntity<HttpStatus> delete(){
        try {
            serviceObserver.delete();
            return new ResponseEntity<>(null, HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}