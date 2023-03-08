package br.eti.gadelha.controller;

import br.eti.gadelha.persistence.payload.request.DTORequestSurveying;
import br.eti.gadelha.persistence.payload.response.DTOResponseSurveying;
import br.eti.gadelha.services.ServiceSurveying;
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

@RestController @RequestMapping("/surveying") @RequiredArgsConstructor
@CrossOrigin(origins = "*", maxAge = 3600)
public class ControllerSurveying implements ControllerInterface<DTOResponseSurveying, DTORequestSurveying> {

    @Autowired
    private final ServiceSurveying serviceSurveying;

    @PostMapping("") @PreAuthorize("hasAnyRole('MODERATOR', 'ADMIN')")
    public ResponseEntity<DTOResponseSurveying> create(@RequestBody @Valid DTORequestSurveying created){
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/surveying").toUriString());
        return ResponseEntity.created(uri).body(serviceSurveying.create(created));
    }
    @GetMapping("/retrieve")
    public List<DTOResponseSurveying> retrieve(){
        return serviceSurveying.retrieve();
    }
    @GetMapping("") @PreAuthorize("hasAnyRole('MODERATOR', 'ADMIN')")
    public ResponseEntity<Page<DTOResponseSurveying>> retrieve(Pageable pageable){
        return ResponseEntity.ok().body(serviceSurveying.retrieve(pageable));
    }
    @GetMapping("/{id}") @PreAuthorize("hasAnyRole('MODERATOR', 'ADMIN')")
    public ResponseEntity<DTOResponseSurveying> retrieve(@PathVariable UUID id){
        return ResponseEntity.ok().body(serviceSurveying.retrieve(id));
    }
    @GetMapping("/source") @PreAuthorize("hasAnyRole('MODERATOR', 'ADMIN')")
    public ResponseEntity<Page<DTOResponseSurveying>> retrieve(Pageable pageable, @RequestParam(required = false) String q){
        return ResponseEntity.ok().body(serviceSurveying.retrieve(pageable, q));
    }
    @PutMapping("/{id}") @PreAuthorize("hasAnyRole('MODERATOR', 'ADMIN')")
    public ResponseEntity<DTOResponseSurveying> update(@PathVariable("id") UUID id, @RequestBody @Valid DTORequestSurveying updated){
        return ResponseEntity.accepted().body(serviceSurveying.update(id, updated));
    }
    @DeleteMapping("/{id}") @PreAuthorize("hasAnyRole('MODERATOR', 'ADMIN')")
    public ResponseEntity<DTOResponseSurveying> delete(@PathVariable UUID id){
        return ResponseEntity.accepted().body(serviceSurveying.delete(id));
    }
    @DeleteMapping("") @PreAuthorize("hasAnyRole('MODERATOR', 'ADMIN')")
    public ResponseEntity<HttpStatus> delete(){
        try {
            serviceSurveying.delete();
            return new ResponseEntity<>(null, HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(HttpStatus.BAD_REQUEST);
        }
    }
}