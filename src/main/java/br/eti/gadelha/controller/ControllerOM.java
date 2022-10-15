package br.eti.gadelha.controller;

import br.eti.gadelha.persistence.payload.request.DTORequestOM;
import br.eti.gadelha.persistence.payload.response.DTOResponseOM;
import br.eti.gadelha.services.ServiceOM;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.UUID;

@RestController @RequestMapping("/om") @RequiredArgsConstructor
@CrossOrigin(origins = "*", maxAge = 3600)
public class ControllerOM implements ControllerInterface<DTOResponseOM, DTORequestOM> {

    private final ServiceOM serviceOM;

    @PostMapping("") @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity<DTOResponseOM> create(@RequestBody @Valid DTORequestOM created){
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/om").toUriString());
        return ResponseEntity.created(uri).body(serviceOM.create(created));
    }
    @GetMapping("/retrieve")
    public List<DTOResponseOM> retrieve(){
        return serviceOM.retrieve();
    }
    @GetMapping("") @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity<Page<DTOResponseOM>> retrieve(Pageable pageable){
        return ResponseEntity.ok().body(serviceOM.retrieve(pageable));
    }
    @GetMapping("/{id}") @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity<DTOResponseOM> retrieve(@PathVariable UUID id){
        return ResponseEntity.ok().body(serviceOM.retrieve(id));
    }
    @GetMapping("/source") @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity<Page<DTOResponseOM>> retrieve(Pageable pageable, @RequestParam(required = false) String q){
        return ResponseEntity.ok().body(serviceOM.retrieveSource(pageable, q));
    }
    @PutMapping("/{id}") @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity<DTOResponseOM> update(@PathVariable("id") UUID id, @RequestBody @Valid DTORequestOM updated){
        return ResponseEntity.accepted().body(serviceOM.update(id, updated));
    }
    @DeleteMapping("/{id}") @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity<DTOResponseOM> delete(@PathVariable UUID id){
        return ResponseEntity.accepted().body(serviceOM.delete(id));
    }
    @DeleteMapping("") @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity<HttpStatus> delete(){
        try {
            serviceOM.delete();
            return new ResponseEntity<>(null, HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(HttpStatus.BAD_REQUEST);
        }
    }
}