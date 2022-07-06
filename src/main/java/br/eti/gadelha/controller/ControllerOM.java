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

/**
 * @author	Marcelo Ribeiro Gadelha
 * @mail	gadelha.ti@gmail.com
 * @link	www.gadelha.eti.br
 **/

@RestController
@RequestMapping("/om")
@CrossOrigin(origins = "*", maxAge = 3600)
public class ControllerOM {

    private final ServiceOM service;

    public ControllerOM(RepositoryOM repository) {
        this.service = new ServiceOM(repository) {};
    }

    @PostMapping("") @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity<DTOResponseOM> create(@RequestBody @Valid DTORequestOM created){
        try {
            return new ResponseEntity<>(service.create(created), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/retrieve")
    public List<DTOResponseOM> retrieveAll(){
        return service.retrieve();
    }
    @GetMapping("") @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity<Page<DTOResponseOM
            >> retrieve(Pageable pageable){
        return new ResponseEntity<>(service.retrieve(pageable), HttpStatus.OK);
    }
    @GetMapping("/{id}") @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity<DTOResponseOM> retrieve(@PathVariable UUID id){
        try {
            return new ResponseEntity<>(service.retrieve(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/source") @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity<Page<DTOResponseOM>> retrieveSource(Pageable pageable, @RequestParam(required = false) String q){
        try {
            return new ResponseEntity<>(service.retrieveSource(pageable, q), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PutMapping("/{id}") @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity<DTOResponseOM> update(@PathVariable("id") UUID id, @RequestBody @Valid DTORequestOM updated){
        try {
            return new ResponseEntity<>(service.update(id, updated), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @DeleteMapping("/{id}") @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity<DTOResponseOM> delete(@PathVariable UUID id){
        try {
            return new ResponseEntity<>(service.delete(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @DeleteMapping("") @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity<HttpStatus> delete(){
        try {
            service.delete();
            return new ResponseEntity<>(null, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}