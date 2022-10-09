package br.eti.gadelha.controller;

import br.eti.gadelha.persistence.dto.request.DTORequestManufacturer;
import br.eti.gadelha.persistence.dto.response.DTOResponseManufacturer;
import br.eti.gadelha.persistence.repository.RepositoryManufacturer;
import br.eti.gadelha.services.ServiceManufacturer;
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

@RestController @RequestMapping("/manufacturer")
@CrossOrigin(origins = "*", maxAge = 3600)
public class ControllerManufacturer implements ControllerInterface<DTOResponseManufacturer, DTORequestManufacturer> {

    @Autowired
    private final ServiceManufacturer serviceManufacturer;

    public ControllerManufacturer(RepositoryManufacturer repository) {
        this.serviceManufacturer = new ServiceManufacturer(repository) {};
    }

    @PostMapping("") @PreAuthorize("hasAnyRole('MODERATOR', 'ADMIN')")
    public ResponseEntity<DTOResponseManufacturer> create(@RequestBody @Valid DTORequestManufacturer created){
        try {
            return new ResponseEntity<>(serviceManufacturer.create(created), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/retrieve")
    public List<DTOResponseManufacturer> retrieve(){
        return serviceManufacturer.retrieve();
    }
    @GetMapping("") @PreAuthorize("hasAnyRole('MODERATOR', 'ADMIN')")
    public ResponseEntity<Page<DTOResponseManufacturer>> retrieve(Pageable pageable){
        return new ResponseEntity<>(serviceManufacturer.retrieve(pageable), HttpStatus.OK);
    }
    @GetMapping("/{id}") @PreAuthorize("hasAnyRole('MODERATOR', 'ADMIN')")
    public ResponseEntity<DTOResponseManufacturer> retrieve(@PathVariable UUID id){
        try {
            return new ResponseEntity<>(serviceManufacturer.retrieve(id), HttpStatus.FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/source") @PreAuthorize("hasAnyRole('MODERATOR', 'ADMIN')")
    public ResponseEntity<Page<DTOResponseManufacturer>> retrieve(Pageable pageable, @RequestParam(required = false) String q){
        try {
            return new ResponseEntity<>(serviceManufacturer.retrieve(pageable, q), HttpStatus.FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PutMapping("/{id}") @PreAuthorize("hasAnyRole('MODERATOR', 'ADMIN')")
    public ResponseEntity<DTOResponseManufacturer> update(@PathVariable("id") UUID id, @RequestBody @Valid DTORequestManufacturer updated){
        try {
            return new ResponseEntity<>(serviceManufacturer.update(id, updated), HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @DeleteMapping("/{id}") @PreAuthorize("hasAnyRole('MODERATOR', 'ADMIN')")
    public ResponseEntity<DTOResponseManufacturer> delete(@PathVariable UUID id){
        try {
            return new ResponseEntity<>(serviceManufacturer.delete(id), HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @DeleteMapping("") @PreAuthorize("hasAnyRole('MODERATOR', 'ADMIN')")
    public ResponseEntity<HttpStatus> delete(){
        try {
            serviceManufacturer.delete();
            return new ResponseEntity<>(null, HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}