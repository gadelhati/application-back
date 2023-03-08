package br.eti.gadelha.controller;

import br.eti.gadelha.persistence.payload.request.DTORequestHarbor;
import br.eti.gadelha.persistence.payload.response.DTOResponseHarbor;
import br.eti.gadelha.services.ServiceHarbor;
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

@RestController @RequestMapping("/harbor") @RequiredArgsConstructor
@CrossOrigin(origins = "*", maxAge = 3600)
public class ControllerHarbor implements ControllerInterface<DTOResponseHarbor, DTORequestHarbor> {

    @Autowired
    private final ServiceHarbor serviceHarbor;

    @PostMapping("") @PreAuthorize("hasAnyRole('MODERATOR', 'ADMIN')")
    public ResponseEntity<DTOResponseHarbor> create(@RequestBody @Valid DTORequestHarbor created){
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/harbor").toUriString());
        return ResponseEntity.created(uri).body(serviceHarbor.create(created));
    }
    @GetMapping("/retrieve")
    public List<DTOResponseHarbor> retrieve(){
        return serviceHarbor.retrieve();
    }
    @GetMapping("") @PreAuthorize("hasAnyRole('MODERATOR', 'ADMIN')")
    public ResponseEntity<Page<DTOResponseHarbor>> retrieve(Pageable pageable){
        return ResponseEntity.ok().body(serviceHarbor.retrieve(pageable));
    }
    @GetMapping("/{id}") @PreAuthorize("hasAnyRole('MODERATOR', 'ADMIN')")
    public ResponseEntity<DTOResponseHarbor> retrieve(@PathVariable UUID id){
        return ResponseEntity.ok().body(serviceHarbor.retrieve(id));
    }
    @GetMapping("/source") @PreAuthorize("hasAnyRole('MODERATOR', 'ADMIN')")
    public ResponseEntity<Page<DTOResponseHarbor>> retrieve(Pageable pageable, @RequestParam(required = false) String q){
        return ResponseEntity.ok().body(serviceHarbor.retrieve(pageable, q));
    }
    @PutMapping("/{id}") @PreAuthorize("hasAnyRole('MODERATOR', 'ADMIN')")
    public ResponseEntity<DTOResponseHarbor> update(@PathVariable("id") UUID id, @RequestBody @Valid DTORequestHarbor updated){
        return ResponseEntity.accepted().body(serviceHarbor.update(id, updated));
    }
    @DeleteMapping("/{id}") @PreAuthorize("hasAnyRole('MODERATOR', 'ADMIN')")
    public ResponseEntity<DTOResponseHarbor> delete(@PathVariable UUID id){
        return ResponseEntity.accepted().body(serviceHarbor.delete(id));
    }
    @DeleteMapping("") @PreAuthorize("hasAnyRole('MODERATOR', 'ADMIN')")
    public ResponseEntity<HttpStatus> delete(){
        try {
            serviceHarbor.delete();
            return new ResponseEntity<>(null, HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(HttpStatus.BAD_REQUEST);
        }
    }
}