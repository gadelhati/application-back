package br.eti.gadelha.controller;

import br.eti.gadelha.persistence.payload.request.DTORequestResearcher;
import br.eti.gadelha.persistence.payload.response.DTOResponseResearcher;
import br.eti.gadelha.services.ServiceResearcher;
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

@RestController @RequestMapping("/researcher") @RequiredArgsConstructor
@CrossOrigin(origins = "*", maxAge = 3600)
public class ControllerResearcher implements ControllerInterface<DTOResponseResearcher, DTORequestResearcher> {

    @Autowired
    private final ServiceResearcher serviceResearcher;

    @PostMapping("") @PreAuthorize("hasAnyRole('MODERATOR', 'ADMIN')")
    public ResponseEntity<DTOResponseResearcher> create(@RequestBody @Valid DTORequestResearcher created){
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/researcher").toUriString());
        return ResponseEntity.created(uri).body(serviceResearcher.create(created));
    }
    @GetMapping("/retrieve")
    public List<DTOResponseResearcher> retrieve(){
        return serviceResearcher.retrieve();
    }
    @GetMapping("") @PreAuthorize("hasAnyRole('MODERATOR', 'ADMIN')")
    public ResponseEntity<Page<DTOResponseResearcher>> retrieve(Pageable pageable){
        return ResponseEntity.ok().body(serviceResearcher.retrieve(pageable));
    }
    @GetMapping("/{id}") @PreAuthorize("hasAnyRole('MODERATOR', 'ADMIN')")
    public ResponseEntity<DTOResponseResearcher> retrieve(@PathVariable UUID id){
        return ResponseEntity.ok().body(serviceResearcher.retrieve(id));
    }
    @GetMapping("/source") @PreAuthorize("hasAnyRole('MODERATOR', 'ADMIN')")
    public ResponseEntity<Page<DTOResponseResearcher>> retrieve(Pageable pageable, @RequestParam(required = false) String q){
        return ResponseEntity.ok().body(serviceResearcher.retrieve(pageable, q));
    }
    @PutMapping("/{id}") @PreAuthorize("hasAnyRole('MODERATOR', 'ADMIN')")
    public ResponseEntity<DTOResponseResearcher> update(@PathVariable("id") UUID id, @RequestBody @Valid DTORequestResearcher updated){
        return ResponseEntity.accepted().body(serviceResearcher.update(id, updated));
    }
    @DeleteMapping("/{id}") @PreAuthorize("hasAnyRole('MODERATOR', 'ADMIN')")
    public ResponseEntity<DTOResponseResearcher> delete(@PathVariable UUID id){
        return ResponseEntity.accepted().body(serviceResearcher.delete(id));
    }
    @DeleteMapping("") @PreAuthorize("hasAnyRole('MODERATOR', 'ADMIN')")
    public ResponseEntity<HttpStatus> delete(){
        try {
            serviceResearcher.delete();
            return new ResponseEntity<>(null, HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(HttpStatus.BAD_REQUEST);
        }
    }
}