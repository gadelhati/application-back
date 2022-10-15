package br.eti.gadelha.controller;

import br.eti.gadelha.persistence.payload.request.DTORequestStation;
import br.eti.gadelha.persistence.payload.response.DTOResponseStation;
import br.eti.gadelha.services.ServiceStation;
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

@RestController @RequestMapping("/station") @RequiredArgsConstructor
@CrossOrigin(origins = "*", maxAge = 3600)
public class ControllerStation implements ControllerInterface<DTOResponseStation, DTORequestStation> {

    @Autowired
    private final ServiceStation serviceStation;

    @PostMapping("") @PreAuthorize("hasAnyRole('MODERATOR', 'ADMIN')")
    public ResponseEntity<DTOResponseStation> create(@RequestBody @Valid DTORequestStation created){
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/station").toUriString());
        return ResponseEntity.created(uri).body(serviceStation.create(created));
    }
    @GetMapping("/retrieve")
    public List<DTOResponseStation> retrieve(){
        return serviceStation.retrieve();
    }
    @GetMapping("") @PreAuthorize("hasAnyRole('MODERATOR', 'ADMIN')")
    public ResponseEntity<Page<DTOResponseStation>> retrieve(Pageable pageable){
        return ResponseEntity.ok().body(serviceStation.retrieve(pageable));
    }
    @GetMapping("/{id}") @PreAuthorize("hasAnyRole('MODERATOR', 'ADMIN')")
    public ResponseEntity<DTOResponseStation> retrieve(@PathVariable UUID id){
        return ResponseEntity.ok().body(serviceStation.retrieve(id));
    }
    @GetMapping("/source") @PreAuthorize("hasAnyRole('MODERATOR', 'ADMIN')")
    public ResponseEntity<Page<DTOResponseStation>> retrieve(Pageable pageable, @RequestParam(required = false) String q){
        return ResponseEntity.ok().body(serviceStation.retrieve(pageable, q));
    }
    @PutMapping("/{id}") @PreAuthorize("hasAnyRole('MODERATOR', 'ADMIN')")
    public ResponseEntity<DTOResponseStation> update(@PathVariable("id") UUID id, @RequestBody @Valid DTORequestStation updated){
        return ResponseEntity.accepted().body(serviceStation.update(id, updated));
    }
    @DeleteMapping("/{id}") @PreAuthorize("hasAnyRole('MODERATOR', 'ADMIN')")
    public ResponseEntity<DTOResponseStation> delete(@PathVariable UUID id){
        return ResponseEntity.accepted().body(serviceStation.delete(id));
    }
    @DeleteMapping("") @PreAuthorize("hasAnyRole('MODERATOR', 'ADMIN')")
    public ResponseEntity<HttpStatus> delete(){
        try {
            serviceStation.delete();
            return new ResponseEntity<>(null, HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(HttpStatus.BAD_REQUEST);
        }
    }
}