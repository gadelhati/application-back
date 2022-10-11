package br.eti.gadelha.controller;

import br.eti.gadelha.persistence.payload.request.DTORequestCountry;
import br.eti.gadelha.persistence.payload.response.DTOResponseCountry;
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

@RestController @RequestMapping("/country")
@CrossOrigin(origins = "*", maxAge = 3600)
public class ControllerCountry implements ControllerInterface<DTOResponseCountry, DTORequestCountry> {

    @Autowired
    private final ServiceCountry serviceCountry;

    public ControllerCountry(RepositoryCountry repository) {
        this.serviceCountry = new ServiceCountry(repository) {};
    }

    @PostMapping("") @PreAuthorize("hasAnyRole('MODERATOR', 'ADMIN')")
    public ResponseEntity<DTOResponseCountry> create(@RequestBody @Valid DTORequestCountry created){
        try {
            return new ResponseEntity<>(serviceCountry.create(created), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/retrieve")
    public List<DTOResponseCountry> retrieve(){
        return serviceCountry.retrieve();
    }
    @GetMapping("") @PreAuthorize("hasAnyRole('MODERATOR', 'ADMIN')")
    public ResponseEntity<Page<DTOResponseCountry>> retrieve(Pageable pageable){
        return new ResponseEntity<>(serviceCountry.retrieve(pageable), HttpStatus.FOUND);
    }
    @GetMapping("/{id}") @PreAuthorize("hasAnyRole('MODERATOR', 'ADMIN')")
    public ResponseEntity<DTOResponseCountry> retrieve(@PathVariable UUID id){
        try {
            return new ResponseEntity<>(serviceCountry.retrieve(id), HttpStatus.FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/source") @PreAuthorize("hasAnyRole('MODERATOR', 'ADMIN')")
    public ResponseEntity<Page<DTOResponseCountry>> retrieve(Pageable pageable, @RequestParam(required = false) String q){
        try {
            return new ResponseEntity<>(serviceCountry.retrieve(pageable, q), HttpStatus.FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PutMapping("/{id}") @PreAuthorize("hasAnyRole('MODERATOR', 'ADMIN')")
    public ResponseEntity<DTOResponseCountry> update(@PathVariable("id") UUID id, @RequestBody @Valid DTORequestCountry updated){
        try {
            return new ResponseEntity<>(serviceCountry.update(id, updated), HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @DeleteMapping("/{id}") @PreAuthorize("hasAnyRole('MODERATOR', 'ADMIN')")
    public ResponseEntity<DTOResponseCountry> delete(@PathVariable UUID id){
        try {
            return new ResponseEntity<>(serviceCountry.delete(id), HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @DeleteMapping("") @PreAuthorize("hasAnyRole('MODERATOR', 'ADMIN')")
    public ResponseEntity<HttpStatus> delete(){
        try {
            serviceCountry.delete();
            return new ResponseEntity<>(null, HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}