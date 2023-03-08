package br.eti.gadelha.controller;

import br.eti.gadelha.persistence.payload.request.DTORequestCommission;
import br.eti.gadelha.persistence.payload.response.DTOResponseCommission;
import br.eti.gadelha.services.ServiceCommission;
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

@RestController @RequestMapping("/commission") @RequiredArgsConstructor
@CrossOrigin(origins = "*", maxAge = 3600)
public class ControllerCommission implements ControllerInterface<DTOResponseCommission, DTORequestCommission> {

    @Autowired
    private final ServiceCommission serviceCommission;

    @PostMapping("") @PreAuthorize("hasAnyRole('MODERATOR', 'ADMIN')")
    public ResponseEntity<DTOResponseCommission> create(@RequestBody @Valid DTORequestCommission created){
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/commission").toUriString());
        return ResponseEntity.created(uri).body(serviceCommission.create(created));
    }
    @GetMapping("/retrieve")
    public List<DTOResponseCommission> retrieve(){
        return serviceCommission.retrieve();
    }
    @GetMapping("") @PreAuthorize("hasAnyRole('MODERATOR', 'ADMIN')")
    public ResponseEntity<Page<DTOResponseCommission>> retrieve(Pageable pageable){
        return ResponseEntity.ok().body(serviceCommission.retrieve(pageable));
    }
    @GetMapping("/{id}") @PreAuthorize("hasAnyRole('MODERATOR', 'ADMIN')")
    public ResponseEntity<DTOResponseCommission> retrieve(@PathVariable UUID id){
        return ResponseEntity.ok().body(serviceCommission.retrieve(id));
    }
    @GetMapping("/source") @PreAuthorize("hasAnyRole('MODERATOR', 'ADMIN')")
    public ResponseEntity<Page<DTOResponseCommission>> retrieve(Pageable pageable, @RequestParam(required = false) String q){
        return ResponseEntity.ok().body(serviceCommission.retrieve(pageable, q));
    }
    @PutMapping("/{id}") @PreAuthorize("hasAnyRole('MODERATOR', 'ADMIN')")
    public ResponseEntity<DTOResponseCommission> update(@PathVariable("id") UUID id, @RequestBody @Valid DTORequestCommission updated){
        return ResponseEntity.accepted().body(serviceCommission.update(id, updated));
    }
    @DeleteMapping("/{id}") @PreAuthorize("hasAnyRole('MODERATOR', 'ADMIN')")
    public ResponseEntity<DTOResponseCommission> delete(@PathVariable UUID id){
        return ResponseEntity.accepted().body(serviceCommission.delete(id));
    }
    @DeleteMapping("") @PreAuthorize("hasAnyRole('MODERATOR', 'ADMIN')")
    public ResponseEntity<HttpStatus> delete(){
        try {
            serviceCommission.delete();
            return new ResponseEntity<>(null, HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(HttpStatus.BAD_REQUEST);
        }
    }
}