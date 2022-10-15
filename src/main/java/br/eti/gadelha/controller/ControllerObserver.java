package br.eti.gadelha.controller;

import br.eti.gadelha.persistence.payload.request.DTORequestObserver;
import br.eti.gadelha.persistence.payload.response.DTOResponseObserver;
import br.eti.gadelha.services.ServiceObserver;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
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

@RestController @RequestMapping("/observer") @RequiredArgsConstructor
@CrossOrigin(origins = "*", maxAge = 3600)
public class ControllerObserver implements ControllerInterface<DTOResponseObserver, DTORequestObserver> {

    @Autowired
    private final ServiceObserver serviceObserver;

    @PostMapping("") @PreAuthorize("hasAnyRole('MODERATOR', 'ADMIN')")
    public ResponseEntity<DTOResponseObserver> create(@RequestBody @Valid DTORequestObserver created){
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/observer").toUriString());
        return ResponseEntity.created(uri).body(serviceObserver.create(created));
    }
    @GetMapping("/retrieve")
    public List<DTOResponseObserver> retrieve(){
        return serviceObserver.retrieve();
    }
    @GetMapping("") @PreAuthorize("hasAnyRole('MODERATOR', 'ADMIN')")
    public ResponseEntity<Page<DTOResponseObserver>> retrieve(Pageable pageable){
        return ResponseEntity.ok().body(serviceObserver.retrieve(pageable));
    }
    @GetMapping("/{id}") @PreAuthorize("hasAnyRole('MODERATOR', 'ADMIN')")
    public ResponseEntity<DTOResponseObserver> retrieve(@PathVariable UUID id){
        return ResponseEntity.ok().body(serviceObserver.retrieve(id));
    }
    @GetMapping("/source") @PreAuthorize("hasAnyRole('MODERATOR', 'ADMIN')")
    public ResponseEntity<Page<DTOResponseObserver>> retrieve(Pageable pageable, @RequestParam(required = false) String q){
        return ResponseEntity.ok().body(serviceObserver.retrieve(pageable, q));
    }
    @PutMapping("/{id}") @PreAuthorize("hasAnyRole('MODERATOR', 'ADMIN')")
    public ResponseEntity<DTOResponseObserver> update(@PathVariable("id") UUID id, @RequestBody @Valid DTORequestObserver updated){
        return ResponseEntity.accepted().body(serviceObserver.update(id, updated));
    }
    @DeleteMapping("/{id}") @PreAuthorize("hasAnyRole('MODERATOR', 'ADMIN')")
    public ResponseEntity<DTOResponseObserver> delete(@PathVariable UUID id){
        return ResponseEntity.accepted().body(serviceObserver.delete(id));
    }
    @DeleteMapping("") @PreAuthorize("hasAnyRole('MODERATOR', 'ADMIN')")
    public ResponseEntity<HttpStatus> delete(){
        try {
            serviceObserver.delete();
            return new ResponseEntity<>(null, HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(HttpStatus.BAD_REQUEST);
        }
    }
}