package br.eti.gadelha.controller;

import br.eti.gadelha.persistence.payload.request.DTORequestEquipment;
import br.eti.gadelha.persistence.payload.response.DTOResponseEquipment;
import br.eti.gadelha.services.ServiceEquipment;
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

@RestController @RequestMapping("/equipment") @RequiredArgsConstructor
@CrossOrigin(origins = "*", maxAge = 3600)
public class ControllerEquipment implements ControllerInterface<DTOResponseEquipment, DTORequestEquipment> {

    @Autowired
    private final ServiceEquipment serviceEquipment;

    @PostMapping("") @PreAuthorize("hasAnyRole('MODERATOR', 'ADMIN')")
    public ResponseEntity<DTOResponseEquipment> create(@RequestBody @Valid DTORequestEquipment created){
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/equipment").toUriString());
        return ResponseEntity.created(uri).body(serviceEquipment.create(created));
    }
    @GetMapping("/retrieve")
    public List<DTOResponseEquipment> retrieve(){
        return serviceEquipment.retrieve();
    }
    @GetMapping("") @PreAuthorize("hasAnyRole('MODERATOR', 'ADMIN')")
    public ResponseEntity<Page<DTOResponseEquipment>> retrieve(Pageable pageable){
        return ResponseEntity.ok().body(serviceEquipment.retrieve(pageable));
    }
    @GetMapping("/{id}") @PreAuthorize("hasAnyRole('MODERATOR', 'ADMIN')")
    public ResponseEntity<DTOResponseEquipment> retrieve(@PathVariable UUID id){
        return ResponseEntity.ok().body(serviceEquipment.retrieve(id));
    }
    @GetMapping("/source") @PreAuthorize("hasAnyRole('MODERATOR', 'ADMIN')")
    public ResponseEntity<Page<DTOResponseEquipment>> retrieve(Pageable pageable, @RequestParam(required = false) String q){
        return ResponseEntity.ok().body(serviceEquipment.retrieve(pageable, q));
    }
    @PutMapping("/{id}") @PreAuthorize("hasAnyRole('MODERATOR', 'ADMIN')")
    public ResponseEntity<DTOResponseEquipment> update(@PathVariable("id") UUID id, @RequestBody @Valid DTORequestEquipment updated){
        return ResponseEntity.accepted().body(serviceEquipment.update(id, updated));
    }
    @DeleteMapping("/{id}") @PreAuthorize("hasAnyRole('MODERATOR', 'ADMIN')")
    public ResponseEntity<DTOResponseEquipment> delete(@PathVariable UUID id){
        return ResponseEntity.accepted().body(serviceEquipment.delete(id));
    }
    @DeleteMapping("") @PreAuthorize("hasAnyRole('MODERATOR', 'ADMIN')")
    public ResponseEntity<HttpStatus> delete(){
        try {
            serviceEquipment.delete();
            return new ResponseEntity<>(null, HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(HttpStatus.BAD_REQUEST);
        }
    }
}