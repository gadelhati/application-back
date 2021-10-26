package br.eti.gadelha.controller;

import br.eti.gadelha.persistence.dto.request.DTORequestSeal;
import br.eti.gadelha.persistence.dto.response.DTOResponseSeal;
import br.eti.gadelha.persistence.repository.RepositorySeal;
import br.eti.gadelha.services.ServiceSeal;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

/**
 * @author	Marcelo Ribeiro Gadelha
 * @mail	gadelha.ti@gmail.com
 * @since	16/07/2021
 * @version 1.0
 * @link	www.gadelha.eti.br
 **/

@RestController
@RequestMapping("/seal")
@CrossOrigin(origins = "*", maxAge = 3600)
public class ControllerSeal {

    private final ServiceSeal service;

    public ControllerSeal(RepositorySeal repository) {
        this.service = new ServiceSeal(repository) {};
    }

    @PostMapping("") @PreAuthorize("hasAnyRole('ROLE_USER', 'ROLE_MODERATOR', 'ROLE_ADMIN')")
    public ResponseEntity<DTOResponseSeal> create(@RequestBody @Valid DTORequestSeal created){
        try {
            return new ResponseEntity<>(service.create(created), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("") @PreAuthorize("hasAnyRole('USER', 'MODERATOR', 'ADMIN')")
    public ResponseEntity<Page<DTOResponseSeal>> retrieve(Pageable pageable){
        return new ResponseEntity<>(service.retrieve(pageable), HttpStatus.FOUND);
    }
    @GetMapping("/{id}") @PreAuthorize("hasAnyRole('USER', 'MODERATOR', 'ADMIN')")
    public ResponseEntity<DTOResponseSeal> retrieve(@PathVariable UUID id){
        try {
            return new ResponseEntity<>(service.retrieve(id), HttpStatus.FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/source") @PreAuthorize("hasAnyRole('USER', 'MODERATOR', 'ADMIN')")
    public ResponseEntity<Page<DTOResponseSeal>> retrieveSource(Pageable pageable, @RequestParam(required = false) String q){
        try {
            return new ResponseEntity<>(service.retrieveSource(pageable, q), HttpStatus.FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PutMapping("/{id}") @PreAuthorize("hasAnyRole('USER', 'MODERATOR', 'ADMIN')")
    public ResponseEntity<DTOResponseSeal> update(@PathVariable("id") UUID id, @RequestBody @Valid DTORequestSeal updated){
        try {
            return new ResponseEntity<>(service.update(id, updated), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/{id}") @PreAuthorize("hasAnyRole('USER', 'MODERATOR', 'ADMIN')")
    public ResponseEntity<HttpStatus> delete(@PathVariable UUID id){
        try {
            service.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("") @PreAuthorize("hasAnyRole('USER', 'MODERATOR', 'ADMIN')")
    public ResponseEntity<HttpStatus> delete(){
        try {
            service.delete();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}