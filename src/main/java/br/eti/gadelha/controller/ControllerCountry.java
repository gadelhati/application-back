package br.eti.gadelha.controller;

import br.eti.gadelha.persistence.payload.request.DTORequestCountry;
import br.eti.gadelha.persistence.payload.response.DTOResponseCountry;
import br.eti.gadelha.services.ServiceCountry;
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

@RestController @RequestMapping("/country") @RequiredArgsConstructor
@CrossOrigin(origins = "*", maxAge = 3600)
public class ControllerCountry implements ControllerInterface<DTOResponseCountry, DTORequestCountry> {

    @Autowired
    private final ServiceCountry serviceCountry;

    @PostMapping("") @PreAuthorize("hasAnyRole('MODERATOR', 'ADMIN')")
    public ResponseEntity<DTOResponseCountry> create(@RequestBody @Valid DTORequestCountry created){
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/country").toUriString());
        return ResponseEntity.created(uri).body(serviceCountry.create(created));
    }
    @GetMapping("/retrieve")
    public List<DTOResponseCountry> retrieve(){
        return serviceCountry.retrieve();
    }
    @GetMapping("") @PreAuthorize("hasAnyRole('MODERATOR', 'ADMIN')")
    public ResponseEntity<Page<DTOResponseCountry>> retrieve(Pageable pageable){
        return ResponseEntity.ok().body(serviceCountry.retrieve(pageable));
    }
    @GetMapping("/{id}") @PreAuthorize("hasAnyRole('MODERATOR', 'ADMIN')")
    public ResponseEntity<DTOResponseCountry> retrieve(@PathVariable UUID id){
        return ResponseEntity.ok().body(serviceCountry.retrieve(id));
    }
    @GetMapping("/source") @PreAuthorize("hasAnyRole('MODERATOR', 'ADMIN')")
    public ResponseEntity<Page<DTOResponseCountry>> retrieve(Pageable pageable, @RequestParam(required = false) String q){
        return ResponseEntity.ok().body(serviceCountry.retrieve(pageable, q));
    }
    @PutMapping("/{id}") @PreAuthorize("hasAnyRole('MODERATOR', 'ADMIN')")
    public ResponseEntity<DTOResponseCountry> update(@PathVariable("id") UUID id, @RequestBody @Valid DTORequestCountry updated){
        return ResponseEntity.accepted().body(serviceCountry.update(id, updated));
    }
    @DeleteMapping("/{id}") @PreAuthorize("hasAnyRole('MODERATOR', 'ADMIN')")
    public ResponseEntity<DTOResponseCountry> delete(@PathVariable UUID id){
        return ResponseEntity.accepted().body(serviceCountry.delete(id));
    }
    @DeleteMapping("") @PreAuthorize("hasAnyRole('MODERATOR', 'ADMIN')")
    public ResponseEntity<HttpStatus> delete(){
        try {
            serviceCountry.delete();
            return new ResponseEntity<>(null, HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(HttpStatus.BAD_REQUEST);
        }
    }
}