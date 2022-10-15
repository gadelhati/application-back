package br.eti.gadelha.controller;

import br.eti.gadelha.persistence.payload.request.DTORequestInstitution;
import br.eti.gadelha.persistence.payload.response.DTOResponseInstitution;
import br.eti.gadelha.services.ServiceInstitution;
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

@RestController @RequestMapping("/institution") @RequiredArgsConstructor
@CrossOrigin(origins = "*", maxAge = 3600)
public class ControllerInstitution implements ControllerInterface<DTOResponseInstitution, DTORequestInstitution> {

    @Autowired
    private final ServiceInstitution serviceInstitution;

    @PostMapping("") @PreAuthorize("hasAnyRole('MODERATOR', 'ADMIN')")
    public ResponseEntity<DTOResponseInstitution> create(@RequestBody @Valid DTORequestInstitution created){
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/institution").toUriString());
        return ResponseEntity.created(uri).body(serviceInstitution.create(created));
    }
    @GetMapping("/retrieve")
    public List<DTOResponseInstitution> retrieve(){
        return serviceInstitution.retrieve();
    }
    @GetMapping("") @PreAuthorize("hasAnyRole('MODERATOR', 'ADMIN')")
    public ResponseEntity<Page<DTOResponseInstitution>> retrieve(Pageable pageable){
        return ResponseEntity.ok().body(serviceInstitution.retrieve(pageable));
    }
    @GetMapping("/{id}") @PreAuthorize("hasAnyRole('MODERATOR', 'ADMIN')")
    public ResponseEntity<DTOResponseInstitution> retrieve(@PathVariable UUID id){
        return ResponseEntity.ok().body(serviceInstitution.retrieve(id));
    }
    @GetMapping("/source") @PreAuthorize("hasAnyRole('MODERATOR', 'ADMIN')")
    public ResponseEntity<Page<DTOResponseInstitution>> retrieve(Pageable pageable, @RequestParam(required = false) String q){
        return ResponseEntity.ok().body(serviceInstitution.retrieve(pageable, q));
    }
    @PutMapping("/{id}") @PreAuthorize("hasAnyRole('MODERATOR', 'ADMIN')")
    public ResponseEntity<DTOResponseInstitution> update(@PathVariable("id") UUID id, @RequestBody @Valid DTORequestInstitution updated){
        return ResponseEntity.accepted().body(serviceInstitution.update(id, updated));
    }
    @DeleteMapping("/{id}") @PreAuthorize("hasAnyRole('MODERATOR', 'ADMIN')")
    public ResponseEntity<DTOResponseInstitution> delete(@PathVariable UUID id){
        return ResponseEntity.accepted().body(serviceInstitution.delete(id));
    }
    @DeleteMapping("") @PreAuthorize("hasAnyRole('MODERATOR', 'ADMIN')")
    public ResponseEntity<HttpStatus> delete(){
        try {
            serviceInstitution.delete();
            return new ResponseEntity<>(null, HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(HttpStatus.BAD_REQUEST);
        }
    }
}