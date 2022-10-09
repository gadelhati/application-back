package br.eti.gadelha.controller;

import br.eti.gadelha.persistence.dto.request.DTORequestInstitution;
import br.eti.gadelha.persistence.dto.response.DTOResponseInstitution;
import br.eti.gadelha.persistence.repository.RepositoryInstitution;
import br.eti.gadelha.services.ServiceInstitution;
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

@RestController @RequestMapping("/institution")
@CrossOrigin(origins = "*", maxAge = 3600)
public class ControllerInstitution implements ControllerInterface<DTOResponseInstitution, DTORequestInstitution> {

    @Autowired
    private final ServiceInstitution serviceInstitution;

    public ControllerInstitution(RepositoryInstitution repository) {
        this.serviceInstitution = new ServiceInstitution(repository) {};
    }

    @PostMapping("") @PreAuthorize("hasAnyRole('MODERATOR', 'ADMIN')")
    public ResponseEntity<DTOResponseInstitution> create(@RequestBody @Valid DTORequestInstitution created){
        try {
            return new ResponseEntity<>(serviceInstitution.create(created), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/retrieve")
    public List<DTOResponseInstitution> retrieve(){
        return serviceInstitution.retrieve();
    }
    @GetMapping("") @PreAuthorize("hasAnyRole('MODERATOR', 'ADMIN')")
    public ResponseEntity<Page<DTOResponseInstitution>> retrieve(Pageable pageable){
        return new ResponseEntity<>(serviceInstitution.retrieve(pageable), HttpStatus.FOUND);
    }
    @GetMapping("/{id}") @PreAuthorize("hasAnyRole('MODERATOR', 'ADMIN')")
    public ResponseEntity<DTOResponseInstitution> retrieve(@PathVariable UUID id){
        try {
            return new ResponseEntity<>(serviceInstitution.retrieve(id), HttpStatus.FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/source") @PreAuthorize("hasAnyRole('MODERATOR', 'ADMIN')")
    public ResponseEntity<Page<DTOResponseInstitution>> retrieve(Pageable pageable, @RequestParam(required = false) String q){
        try {
            return new ResponseEntity<>(serviceInstitution.retrieve(pageable, q), HttpStatus.FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PutMapping("/{id}") @PreAuthorize("hasAnyRole('MODERATOR', 'ADMIN')")
    public ResponseEntity<DTOResponseInstitution> update(@PathVariable("id") UUID id, @RequestBody @Valid DTORequestInstitution updated){
        try {
            return new ResponseEntity<>(serviceInstitution.update(id, updated), HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @DeleteMapping("/{id}") @PreAuthorize("hasAnyRole('MODERATOR', 'ADMIN')")
    public ResponseEntity<DTOResponseInstitution> delete(@PathVariable UUID id){
        try {
            return new ResponseEntity<>(serviceInstitution.delete(id), HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @DeleteMapping("") @PreAuthorize("hasAnyRole('MODERATOR', 'ADMIN')")
    public ResponseEntity<HttpStatus> delete(){
        try {
            serviceInstitution.delete();
            return new ResponseEntity<>(null, HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}