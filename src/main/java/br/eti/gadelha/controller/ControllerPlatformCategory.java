package br.eti.gadelha.controller;

import br.eti.gadelha.persistence.dto.request.DTORequestPlatformCategory;
import br.eti.gadelha.persistence.dto.response.DTOResponsePlatformCategory;
import br.eti.gadelha.persistence.repository.RepositoryPlatformCategory;
import br.eti.gadelha.services.ServicePlatformCategory;
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

@RestController
@RequestMapping("/platformCategory")
@CrossOrigin(origins = "*", maxAge = 3600)
public class ControllerPlatformCategory {

    @Autowired
    private final ServicePlatformCategory service;

    public ControllerPlatformCategory(RepositoryPlatformCategory repository) {
        this.service = new ServicePlatformCategory(repository) {};
    }

    @PostMapping("") @PreAuthorize("hasAnyRole('MODERATOR', 'ADMIN')")
    public ResponseEntity<DTOResponsePlatformCategory> create(@RequestBody @Valid DTORequestPlatformCategory created){
        try {
            return new ResponseEntity<>(service.create(created), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/retrieve")
    public List<DTOResponsePlatformCategory> retrieve(){
        return service.retrieve();
    }
    @GetMapping("") @PreAuthorize("hasAnyRole('MODERATOR', 'ADMIN')")
    public ResponseEntity<Page<DTOResponsePlatformCategory>> retrieve(Pageable pageable){
        return new ResponseEntity<>(service.retrieve(pageable), HttpStatus.FOUND);
    }
    @GetMapping("/{id}") @PreAuthorize("hasAnyRole('MODERATOR', 'ADMIN')")
    public ResponseEntity<DTOResponsePlatformCategory> retrieve(@PathVariable UUID id){
        try {
            return new ResponseEntity<>(service.retrieve(id), HttpStatus.FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/source") @PreAuthorize("hasAnyRole('MODERATOR', 'ADMIN')")
    public ResponseEntity<Page<DTOResponsePlatformCategory>> retrieve(Pageable pageable, @RequestParam(required = false) String q){
        try {
            return new ResponseEntity<>(service.retrieve(pageable, q), HttpStatus.FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PutMapping("/{id}") @PreAuthorize("hasAnyRole('MODERATOR', 'ADMIN')")
    public ResponseEntity<DTOResponsePlatformCategory> update(@PathVariable("id") UUID id, @RequestBody @Valid DTORequestPlatformCategory updated){
        try {
            return new ResponseEntity<>(service.update(id, updated), HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @DeleteMapping("/{id}") @PreAuthorize("hasAnyRole('MODERATOR', 'ADMIN')")
    public ResponseEntity<DTOResponsePlatformCategory> delete(@PathVariable UUID id){
        try {
            return new ResponseEntity<>(service.delete(id), HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @DeleteMapping("") @PreAuthorize("hasAnyRole('MODERATOR', 'ADMIN')")
    public ResponseEntity<HttpStatus> delete(){
        try {
            service.delete();
            return new ResponseEntity<>(null, HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}