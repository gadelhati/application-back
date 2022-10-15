package br.eti.gadelha.controller;

import br.eti.gadelha.persistence.payload.request.DTORequestPlatformCategory;
import br.eti.gadelha.persistence.payload.response.DTOResponsePlatformCategory;
import br.eti.gadelha.services.ServicePlatformCategory;
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

@RestController @RequestMapping("/platformCategory") @RequiredArgsConstructor
@CrossOrigin(origins = "*", maxAge = 3600)
public class ControllerPlatformCategory implements ControllerInterface<DTOResponsePlatformCategory, DTORequestPlatformCategory> {

    @Autowired
    private final ServicePlatformCategory servicePlatformCategory;

    @PostMapping("") @PreAuthorize("hasAnyRole('MODERATOR', 'ADMIN')")
    public ResponseEntity<DTOResponsePlatformCategory> create(@RequestBody @Valid DTORequestPlatformCategory created){
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/platformCategory").toUriString());
        return ResponseEntity.created(uri).body(servicePlatformCategory.create(created));
    }
    @GetMapping("/retrieve")
    public List<DTOResponsePlatformCategory> retrieve(){
        return servicePlatformCategory.retrieve();
    }
    @GetMapping("") @PreAuthorize("hasAnyRole('MODERATOR', 'ADMIN')")
    public ResponseEntity<Page<DTOResponsePlatformCategory>> retrieve(Pageable pageable){
        return ResponseEntity.ok().body(servicePlatformCategory.retrieve(pageable));
    }
    @GetMapping("/{id}") @PreAuthorize("hasAnyRole('MODERATOR', 'ADMIN')")
    public ResponseEntity<DTOResponsePlatformCategory> retrieve(@PathVariable UUID id){
        return ResponseEntity.ok().body(servicePlatformCategory.retrieve(id));
    }
    @GetMapping("/source") @PreAuthorize("hasAnyRole('MODERATOR', 'ADMIN')")
    public ResponseEntity<Page<DTOResponsePlatformCategory>> retrieve(Pageable pageable, @RequestParam(required = false) String q){
        return ResponseEntity.ok().body(servicePlatformCategory.retrieve(pageable, q));
    }
    @PutMapping("/{id}") @PreAuthorize("hasAnyRole('MODERATOR', 'ADMIN')")
    public ResponseEntity<DTOResponsePlatformCategory> update(@PathVariable("id") UUID id, @RequestBody @Valid DTORequestPlatformCategory updated){
        return ResponseEntity.accepted().body(servicePlatformCategory.update(id, updated));
    }
    @DeleteMapping("/{id}") @PreAuthorize("hasAnyRole('MODERATOR', 'ADMIN')")
    public ResponseEntity<DTOResponsePlatformCategory> delete(@PathVariable UUID id){
        return ResponseEntity.accepted().body(servicePlatformCategory.delete(id));
    }
    @DeleteMapping("") @PreAuthorize("hasAnyRole('MODERATOR', 'ADMIN')")
    public ResponseEntity<HttpStatus> delete(){
        try {
            servicePlatformCategory.delete();
            return new ResponseEntity<>(null, HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(HttpStatus.BAD_REQUEST);
        }
    }
}