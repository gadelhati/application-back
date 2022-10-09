package br.eti.gadelha.controller;

import br.eti.gadelha.persistence.dto.request.DTORequestStationOffShore;
import br.eti.gadelha.persistence.dto.response.DTOResponseStationOffShore;
import br.eti.gadelha.persistence.repository.RepositoryStationOffShore;
import br.eti.gadelha.services.ServiceStationOffShore;
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

@RestController @RequestMapping("/stationOffShore")
@CrossOrigin(origins = "*", maxAge = 3600)
public class ControllerStationOffShore implements ControllerInterface<DTOResponseStationOffShore, DTORequestStationOffShore> {

    @Autowired
    private final ServiceStationOffShore serviceStationOffShore;

    public ControllerStationOffShore(RepositoryStationOffShore repository) {
        this.serviceStationOffShore = new ServiceStationOffShore(repository) {};
    }

    @PostMapping("") @PreAuthorize("hasAnyRole('MODERATOR', 'ADMIN')")
    public ResponseEntity<DTOResponseStationOffShore> create(@RequestBody @Valid DTORequestStationOffShore created){
        try {
            return new ResponseEntity<>(serviceStationOffShore.create(created), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/retrieve")
    public List<DTOResponseStationOffShore> retrieve(){
        return serviceStationOffShore.retrieve();
    }
    @GetMapping("") @PreAuthorize("hasAnyRole('MODERATOR', 'ADMIN')")
    public ResponseEntity<Page<DTOResponseStationOffShore>> retrieve(Pageable pageable){
        return new ResponseEntity<>(serviceStationOffShore.retrieve(pageable), HttpStatus.FOUND);
    }
    @GetMapping("/{id}") @PreAuthorize("hasAnyRole('MODERATOR', 'ADMIN')")
    public ResponseEntity<DTOResponseStationOffShore> retrieve(@PathVariable UUID id){
        try {
            return new ResponseEntity<>(serviceStationOffShore.retrieve(id), HttpStatus.FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/source") @PreAuthorize("hasAnyRole('MODERATOR', 'ADMIN')")
    public ResponseEntity<Page<DTOResponseStationOffShore>> retrieve(Pageable pageable, @RequestParam(required = false) String q){
        try {
            return new ResponseEntity<>(serviceStationOffShore.retrieve(pageable, q), HttpStatus.FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PutMapping("/{id}") @PreAuthorize("hasAnyRole('MODERATOR', 'ADMIN')")
    public ResponseEntity<DTOResponseStationOffShore> update(@PathVariable("id") UUID id, @RequestBody @Valid DTORequestStationOffShore updated){
        try {
            return new ResponseEntity<>(serviceStationOffShore.update(id, updated), HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @DeleteMapping("/{id}") @PreAuthorize("hasAnyRole('MODERATOR', 'ADMIN')")
    public ResponseEntity<DTOResponseStationOffShore> delete(@PathVariable UUID id){
        try {
            return new ResponseEntity<>(serviceStationOffShore.delete(id), HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @DeleteMapping("") @PreAuthorize("hasAnyRole('MODERATOR', 'ADMIN')")
    public ResponseEntity<HttpStatus> delete(){
        try {
            serviceStationOffShore.delete();
            return new ResponseEntity<>(null, HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}