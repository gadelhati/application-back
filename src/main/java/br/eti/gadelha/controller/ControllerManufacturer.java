package br.eti.gadelha.controller;

import br.eti.gadelha.persistence.payload.request.DTORequestManufacturer;
import br.eti.gadelha.persistence.payload.response.DTOResponseManufacturer;
import br.eti.gadelha.services.ServiceManufacturer;
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

@RestController @RequestMapping("/manufacturer") @RequiredArgsConstructor
@CrossOrigin(origins = "*", maxAge = 3600)
public class ControllerManufacturer implements ControllerInterface<DTOResponseManufacturer, DTORequestManufacturer> {

    @Autowired
    private final ServiceManufacturer serviceManufacturer;

    @PostMapping("") @PreAuthorize("hasAnyRole('MODERATOR', 'ADMIN')")
    public ResponseEntity<DTOResponseManufacturer> create(@RequestBody @Valid DTORequestManufacturer created){
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/manufacturer").toUriString());
        return ResponseEntity.created(uri).body(serviceManufacturer.create(created));
    }
    @GetMapping("/retrieve")
    public List<DTOResponseManufacturer> retrieve(){
        return serviceManufacturer.retrieve();
    }
    @GetMapping("") @PreAuthorize("hasAnyRole('MODERATOR', 'ADMIN')")
    public ResponseEntity<Page<DTOResponseManufacturer>> retrieve(Pageable pageable){
        return ResponseEntity.ok().body(serviceManufacturer.retrieve(pageable));
    }
    @GetMapping("/{id}") @PreAuthorize("hasAnyRole('MODERATOR', 'ADMIN')")
    public ResponseEntity<DTOResponseManufacturer> retrieve(@PathVariable UUID id){
        return ResponseEntity.ok().body(serviceManufacturer.retrieve(id));
    }
    @GetMapping("/source") @PreAuthorize("hasAnyRole('MODERATOR', 'ADMIN')")
    public ResponseEntity<Page<DTOResponseManufacturer>> retrieve(Pageable pageable, @RequestParam(required = false) String q){
        return ResponseEntity.ok().body(serviceManufacturer.retrieve(pageable, q));
    }
    @PutMapping("/{id}") @PreAuthorize("hasAnyRole('MODERATOR', 'ADMIN')")
    public ResponseEntity<DTOResponseManufacturer> update(@PathVariable("id") UUID id, @RequestBody @Valid DTORequestManufacturer updated){
        return ResponseEntity.accepted().body(serviceManufacturer.update(id, updated));
    }
    @DeleteMapping("/{id}") @PreAuthorize("hasAnyRole('MODERATOR', 'ADMIN')")
    public ResponseEntity<DTOResponseManufacturer> delete(@PathVariable UUID id){
        return ResponseEntity.accepted().body(serviceManufacturer.delete(id));
    }
    @DeleteMapping("") @PreAuthorize("hasAnyRole('MODERATOR', 'ADMIN')")
    public ResponseEntity<HttpStatus> delete(){
        try {
            serviceManufacturer.delete();
            return new ResponseEntity<>(null, HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(HttpStatus.BAD_REQUEST);
        }
    }
}