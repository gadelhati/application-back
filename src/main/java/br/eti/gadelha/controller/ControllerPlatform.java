package br.eti.gadelha.controller;

import br.eti.gadelha.persistence.payload.request.DTORequestPlatform;
import br.eti.gadelha.persistence.payload.response.DTOResponsePlatform;
import br.eti.gadelha.services.ServicePlatform;
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

@RestController @RequestMapping("/platform") @RequiredArgsConstructor
@CrossOrigin(origins = "*", maxAge = 3600)
public class ControllerPlatform implements ControllerInterface<DTOResponsePlatform, DTORequestPlatform> {

    @Autowired
    private final ServicePlatform servicePlatform;

    @PostMapping("") @PreAuthorize("hasAnyRole('MODERATOR', 'ADMIN')")
    public ResponseEntity<DTOResponsePlatform> create(@RequestBody @Valid DTORequestPlatform created){
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/platform").toUriString());
        return ResponseEntity.created(uri).body(servicePlatform.create(created));
    }
    @GetMapping("/retrieve")
    public List<DTOResponsePlatform> retrieve(){
        return servicePlatform.retrieve();
    }
    @GetMapping("") @PreAuthorize("hasAnyRole('MODERATOR', 'ADMIN')")
    public ResponseEntity<Page<DTOResponsePlatform>> retrieve(Pageable pageable){
        return ResponseEntity.ok().body(servicePlatform.retrieve(pageable));
    }
    @GetMapping("/{id}") @PreAuthorize("hasAnyRole('MODERATOR', 'ADMIN')")
    public ResponseEntity<DTOResponsePlatform> retrieve(@PathVariable UUID id){
        return ResponseEntity.ok().body(servicePlatform.retrieve(id));
    }
    @GetMapping("/source") @PreAuthorize("hasAnyRole('MODERATOR', 'ADMIN')")
    public ResponseEntity<Page<DTOResponsePlatform>> retrieve(Pageable pageable, @RequestParam(required = false) String q){
        return ResponseEntity.ok().body(servicePlatform.retrieve(pageable, q));
    }
    @PutMapping("/{id}") @PreAuthorize("hasAnyRole('MODERATOR', 'ADMIN')")
    public ResponseEntity<DTOResponsePlatform> update(@PathVariable("id") UUID id, @RequestBody @Valid DTORequestPlatform updated){
        return ResponseEntity.accepted().body(servicePlatform.update(id, updated));
    }
    @DeleteMapping("/{id}") @PreAuthorize("hasAnyRole('MODERATOR', 'ADMIN')")
    public ResponseEntity<DTOResponsePlatform> delete(@PathVariable UUID id){
        return ResponseEntity.accepted().body(servicePlatform.delete(id));
    }
    @DeleteMapping("") @PreAuthorize("hasAnyRole('MODERATOR', 'ADMIN')")
    public ResponseEntity<HttpStatus> delete(){
        try {
            servicePlatform.delete();
            return new ResponseEntity<>(null, HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(HttpStatus.BAD_REQUEST);
        }
    }
}