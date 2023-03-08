package br.eti.gadelha.controller;

import br.eti.gadelha.persistence.payload.request.DTORequestStationCategory;
import br.eti.gadelha.persistence.payload.response.DTOResponseStationCategory;
import br.eti.gadelha.services.ServiceStationCategory;
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

@RestController @RequestMapping("/station_category") @RequiredArgsConstructor
@CrossOrigin(origins = "*", maxAge = 3600)
public class ControllerStationCategory implements ControllerInterface<DTOResponseStationCategory, DTORequestStationCategory> {

    @Autowired
    private final ServiceStationCategory serviceStationCategory;

    @PostMapping("") @PreAuthorize("hasAnyRole('MODERATOR', 'ADMIN')")
    public ResponseEntity<DTOResponseStationCategory> create(@RequestBody @Valid DTORequestStationCategory created){
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/station_category").toUriString());
        return ResponseEntity.created(uri).body(serviceStationCategory.create(created));
    }
    @GetMapping("/retrieve")
    public List<DTOResponseStationCategory> retrieve(){
        return serviceStationCategory.retrieve();
    }
    @GetMapping("") @PreAuthorize("hasAnyRole('MODERATOR', 'ADMIN')")
    public ResponseEntity<Page<DTOResponseStationCategory>> retrieve(Pageable pageable){
        return ResponseEntity.ok().body(serviceStationCategory.retrieve(pageable));
    }
    @GetMapping("/{id}") @PreAuthorize("hasAnyRole('MODERATOR', 'ADMIN')")
    public ResponseEntity<DTOResponseStationCategory> retrieve(@PathVariable UUID id){
        return ResponseEntity.ok().body(serviceStationCategory.retrieve(id));
    }
    @GetMapping("/source") @PreAuthorize("hasAnyRole('MODERATOR', 'ADMIN')")
    public ResponseEntity<Page<DTOResponseStationCategory>> retrieve(Pageable pageable, @RequestParam(required = false) String q){
        return ResponseEntity.ok().body(serviceStationCategory.retrieve(pageable, q));
    }
    @PutMapping("/{id}") @PreAuthorize("hasAnyRole('MODERATOR', 'ADMIN')")
    public ResponseEntity<DTOResponseStationCategory> update(@PathVariable("id") UUID id, @RequestBody @Valid DTORequestStationCategory updated){
        return ResponseEntity.accepted().body(serviceStationCategory.update(id, updated));
    }
    @DeleteMapping("/{id}") @PreAuthorize("hasAnyRole('MODERATOR', 'ADMIN')")
    public ResponseEntity<DTOResponseStationCategory> delete(@PathVariable UUID id){
        return ResponseEntity.accepted().body(serviceStationCategory.delete(id));
    }
    @DeleteMapping("") @PreAuthorize("hasAnyRole('MODERATOR', 'ADMIN')")
    public ResponseEntity<HttpStatus> delete(){
        try {
            serviceStationCategory.delete();
            return new ResponseEntity<>(null, HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(HttpStatus.BAD_REQUEST);
        }
    }
}