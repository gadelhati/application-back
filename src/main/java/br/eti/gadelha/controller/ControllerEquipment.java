package br.eti.gadelha.controller;

import br.eti.gadelha.persistence.dto.request.DTORequestEquipment;
import br.eti.gadelha.persistence.dto.response.DTOResponseEquipment;
import br.eti.gadelha.persistence.repository.RepositoryEquipment;
import br.eti.gadelha.services.ServiceEquipment;
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

@RestController @RequestMapping("/equipment")
@CrossOrigin(origins = "*", maxAge = 3600)
public class ControllerEquipment implements ControllerInterface<DTOResponseEquipment, DTORequestEquipment> {

    @Autowired
    private final ServiceEquipment serviceEquipment;

    public ControllerEquipment(RepositoryEquipment repository) {
        this.serviceEquipment = new ServiceEquipment(repository) {};
    }

    @PostMapping("") @PreAuthorize("hasAnyRole('MODERATOR', 'ADMIN')")
    public ResponseEntity<DTOResponseEquipment> create(@RequestBody @Valid DTORequestEquipment created){
        try {
            return new ResponseEntity<>(serviceEquipment.create(created), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/retrieve")
    public List<DTOResponseEquipment> retrieve(){
        return serviceEquipment.retrieve();
    }
    @GetMapping("") @PreAuthorize("hasAnyRole('MODERATOR', 'ADMIN')")
    public ResponseEntity<Page<DTOResponseEquipment>> retrieve(Pageable pageable){
        return new ResponseEntity<>(serviceEquipment.retrieve(pageable), HttpStatus.FOUND);
    }
    @GetMapping("/{id}") @PreAuthorize("hasAnyRole('MODERATOR', 'ADMIN')")
    public ResponseEntity<DTOResponseEquipment> retrieve(@PathVariable UUID id){
        try {
            return new ResponseEntity<>(serviceEquipment.retrieve(id), HttpStatus.FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/source") @PreAuthorize("hasAnyRole('MODERATOR', 'ADMIN')")
    public ResponseEntity<Page<DTOResponseEquipment>> retrieve(Pageable pageable, @RequestParam(required = false) String q){
        try {
            return new ResponseEntity<>(serviceEquipment.retrieve(pageable, q), HttpStatus.FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PutMapping("/{id}") @PreAuthorize("hasAnyRole('MODERATOR', 'ADMIN')")
    public ResponseEntity<DTOResponseEquipment> update(@PathVariable("id") UUID id, @RequestBody @Valid DTORequestEquipment updated){
        try {
            return new ResponseEntity<>(serviceEquipment.update(id, updated), HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @DeleteMapping("/{id}") @PreAuthorize("hasAnyRole('MODERATOR', 'ADMIN')")
    public ResponseEntity<DTOResponseEquipment> delete(@PathVariable UUID id){
        try {
            return new ResponseEntity<>(serviceEquipment.delete(id), HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @DeleteMapping("") @PreAuthorize("hasAnyRole('MODERATOR', 'ADMIN')")
    public ResponseEntity<HttpStatus> delete(){
        try {
            serviceEquipment.delete();
            return new ResponseEntity<>(null, HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}