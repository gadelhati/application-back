package br.eti.gadelha.controller;

import br.eti.gadelha.persistence.dto.request.DTORequestPlatform;
import br.eti.gadelha.persistence.dto.response.DTOResponsePlatform;
import br.eti.gadelha.persistence.repository.RepositoryPlatform;
import br.eti.gadelha.services.ServicePlatform;
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

@RestController @RequestMapping("/platform")
@CrossOrigin(origins = "*", maxAge = 3600)
public class ControllerPlatform implements ControllerInterface<DTOResponsePlatform, DTORequestPlatform> {

    @Autowired
    private final ServicePlatform servicePlatform;

    public ControllerPlatform(RepositoryPlatform repository) {
        this.servicePlatform = new ServicePlatform(repository) {};
    }

    @PostMapping("") @PreAuthorize("hasAnyRole('MODERATOR', 'ADMIN')")
    public ResponseEntity<DTOResponsePlatform> create(@RequestBody @Valid DTORequestPlatform created){
        try {
            return new ResponseEntity<>(servicePlatform.create(created), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/retrieve")
    public List<DTOResponsePlatform> retrieve(){
        return servicePlatform.retrieve();
    }
    @GetMapping("") @PreAuthorize("hasAnyRole('MODERATOR', 'ADMIN')")
    public ResponseEntity<Page<DTOResponsePlatform>> retrieve(Pageable pageable){
        return new ResponseEntity<>(servicePlatform.retrieve(pageable), HttpStatus.FOUND);
    }
    @GetMapping("/{id}") @PreAuthorize("hasAnyRole('MODERATOR', 'ADMIN')")
    public ResponseEntity<DTOResponsePlatform> retrieve(@PathVariable UUID id){
        try {
            return new ResponseEntity<>(servicePlatform.retrieve(id), HttpStatus.FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/source") @PreAuthorize("hasAnyRole('MODERATOR', 'ADMIN')")
    public ResponseEntity<Page<DTOResponsePlatform>> retrieve(Pageable pageable, @RequestParam(required = false) String q){
        try {
            return new ResponseEntity<>(servicePlatform.retrieve(pageable, q), HttpStatus.FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PutMapping("/{id}") @PreAuthorize("hasAnyRole('MODERATOR', 'ADMIN')")
    public ResponseEntity<DTOResponsePlatform> update(@PathVariable("id") UUID id, @RequestBody @Valid DTORequestPlatform updated){
        try {
            return new ResponseEntity<>(servicePlatform.update(id, updated), HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @DeleteMapping("/{id}") @PreAuthorize("hasAnyRole('MODERATOR', 'ADMIN')")
    public ResponseEntity<DTOResponsePlatform> delete(@PathVariable UUID id){
        try {
            return new ResponseEntity<>(servicePlatform.delete(id), HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @DeleteMapping("") @PreAuthorize("hasAnyRole('MODERATOR', 'ADMIN')")
    public ResponseEntity<HttpStatus> delete(){
        try {
            servicePlatform.delete();
            return new ResponseEntity<>(null, HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}