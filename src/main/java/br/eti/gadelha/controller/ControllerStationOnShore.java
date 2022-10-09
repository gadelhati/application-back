package br.eti.gadelha.controller;

import br.eti.gadelha.persistence.dto.request.DTORequestStationOnShore;
import br.eti.gadelha.persistence.dto.response.DTOResponseStationOnShore;
import br.eti.gadelha.persistence.repository.RepositoryStationOnShore;
import br.eti.gadelha.services.ServiceStationOnShore;
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

@RestController @RequestMapping("/stationOnShore")
@CrossOrigin(origins = "*", maxAge = 3600)
public class ControllerStationOnShore implements ControllerInterface<DTOResponseStationOnShore, DTORequestStationOnShore> {

    @Autowired
    private final ServiceStationOnShore serviceStationOnShore;

    public ControllerStationOnShore(RepositoryStationOnShore repository) {
        this.serviceStationOnShore = new ServiceStationOnShore(repository) {};
    }

    @PostMapping("") @PreAuthorize("hasAnyRole('MODERATOR', 'ADMIN')")
    public ResponseEntity<DTOResponseStationOnShore> create(@RequestBody @Valid DTORequestStationOnShore created){
        try {
            return new ResponseEntity<>(serviceStationOnShore.create(created), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/retrieve")
    public List<DTOResponseStationOnShore> retrieve(){
        return serviceStationOnShore.retrieve();
    }
    @GetMapping("") @PreAuthorize("hasAnyRole('MODERATOR', 'ADMIN')")
    public ResponseEntity<Page<DTOResponseStationOnShore>> retrieve(Pageable pageable){
        return new ResponseEntity<>(serviceStationOnShore.retrieve(pageable), HttpStatus.FOUND);
    }
    @GetMapping("/{id}") @PreAuthorize("hasAnyRole('MODERATOR', 'ADMIN')")
    public ResponseEntity<DTOResponseStationOnShore> retrieve(@PathVariable UUID id){
        try {
            return new ResponseEntity<>(serviceStationOnShore.retrieve(id), HttpStatus.FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/source") @PreAuthorize("hasAnyRole('MODERATOR', 'ADMIN')")
    public ResponseEntity<Page<DTOResponseStationOnShore>> retrieve(Pageable pageable, @RequestParam(required = false) String q){
        try {
            return new ResponseEntity<>(serviceStationOnShore.retrieve(pageable, q), HttpStatus.FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PutMapping("/{id}") @PreAuthorize("hasAnyRole('MODERATOR', 'ADMIN')")
    public ResponseEntity<DTOResponseStationOnShore> update(@PathVariable("id") UUID id, @RequestBody @Valid DTORequestStationOnShore updated){
        try {
            return new ResponseEntity<>(serviceStationOnShore.update(id, updated), HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @DeleteMapping("/{id}") @PreAuthorize("hasAnyRole('MODERATOR', 'ADMIN')")
    public ResponseEntity<DTOResponseStationOnShore> delete(@PathVariable UUID id){
        try {
            return new ResponseEntity<>(serviceStationOnShore.delete(id), HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @DeleteMapping("") @PreAuthorize("hasAnyRole('MODERATOR', 'ADMIN')")
    public ResponseEntity<HttpStatus> delete(){
        try {
            serviceStationOnShore.delete();
            return new ResponseEntity<>(null, HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}