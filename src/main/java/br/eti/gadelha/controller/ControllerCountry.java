package br.eti.gadelha.controller;

import br.eti.gadelha.persistence.dto.request.DTORequestCountry;
import br.eti.gadelha.persistence.dto.response.DTOResponseCountry;
import br.eti.gadelha.persistence.repository.RepositoryCountry;
import br.eti.gadelha.services.ServiceCountry;
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
@RequestMapping("/country")
@CrossOrigin(origins = "*", maxAge = 3600)
public class ControllerCountry {

    @Autowired
    private final ServiceCountry service;

    public ControllerCountry(RepositoryCountry repository) {
        this.service = new ServiceCountry(repository) {};
    }

    @PostMapping("") @PreAuthorize("hasAnyRole('MODERATOR', 'ADMIN')")
    public ResponseEntity<DTOResponseCountry> create(@RequestBody @Valid DTORequestCountry created){
        try {
            return new ResponseEntity<>(service.create(created), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/retrieve")
    public List<DTOResponseCountry> retrieve(){
        return service.retrieve();
    }
    @GetMapping("") @PreAuthorize("hasAnyRole('MODERATOR', 'ADMIN')")
    public ResponseEntity<Page<DTOResponseCountry>> retrieve(Pageable pageable){
        return new ResponseEntity<>(service.retrieve(pageable), HttpStatus.OK);
    }
    @GetMapping("/{id}") @PreAuthorize("hasAnyRole('MODERATOR', 'ADMIN')")
    public ResponseEntity<DTOResponseCountry> retrieve(@PathVariable UUID id){
        try {
            return new ResponseEntity<>(service.retrieve(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/source") @PreAuthorize("hasAnyRole('MODERATOR', 'ADMIN')")
    public ResponseEntity<Page<DTOResponseCountry>> retrieve(Pageable pageable, @RequestParam(required = false) String q){
        try {
            return new ResponseEntity<>(service.retrieve(pageable, q), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PutMapping("/{id}") @PreAuthorize("hasAnyRole('MODERATOR', 'ADMIN')")
    public ResponseEntity<DTOResponseCountry> update(@PathVariable("id") UUID id, @RequestBody @Valid DTORequestCountry updated){
        try {
            return new ResponseEntity<>(service.update(id, updated), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @DeleteMapping("/{id}") @PreAuthorize("hasAnyRole('MODERATOR', 'ADMIN')")
    public ResponseEntity<DTOResponseCountry> delete(@PathVariable UUID id){
        try {
            return new ResponseEntity<>(service.delete(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @DeleteMapping("") @PreAuthorize("hasAnyRole('MODERATOR', 'ADMIN')")
    public ResponseEntity<HttpStatus> delete(){
        try {
            service.delete();
            return new ResponseEntity<>(null, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}