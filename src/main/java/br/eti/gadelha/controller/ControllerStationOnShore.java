package br.eti.gadelha.controller;

import br.eti.gadelha.persistence.payload.request.DTORequestStationOnShore;
import br.eti.gadelha.persistence.payload.response.DTOResponseStationOnShore;
import br.eti.gadelha.services.ServiceStationOnShore;
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

@RestController @RequestMapping("/stationOnShore") @RequiredArgsConstructor
@CrossOrigin(origins = "*", maxAge = 3600)
public class ControllerStationOnShore implements ControllerInterface<DTOResponseStationOnShore, DTORequestStationOnShore> {

    @Autowired
    private final ServiceStationOnShore serviceStationOnShore;

    @PostMapping("") @PreAuthorize("hasAnyRole('MODERATOR', 'ADMIN')")
    public ResponseEntity<DTOResponseStationOnShore> create(@RequestBody @Valid DTORequestStationOnShore created){
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/stationOnShore").toUriString());
        return ResponseEntity.created(uri).body(serviceStationOnShore.create(created));
    }
    @GetMapping("/retrieve")
    public List<DTOResponseStationOnShore> retrieve(){
        return serviceStationOnShore.retrieve();
    }
    @GetMapping("") @PreAuthorize("hasAnyRole('MODERATOR', 'ADMIN')")
    public ResponseEntity<Page<DTOResponseStationOnShore>> retrieve(Pageable pageable){
        return ResponseEntity.ok().body(serviceStationOnShore.retrieve(pageable));
    }
    @GetMapping("/{id}") @PreAuthorize("hasAnyRole('MODERATOR', 'ADMIN')")
    public ResponseEntity<DTOResponseStationOnShore> retrieve(@PathVariable UUID id){
        return ResponseEntity.ok().body(serviceStationOnShore.retrieve(id));
    }
    @GetMapping("/source") @PreAuthorize("hasAnyRole('MODERATOR', 'ADMIN')")
    public ResponseEntity<Page<DTOResponseStationOnShore>> retrieve(Pageable pageable, @RequestParam(required = false) String q){
        return ResponseEntity.ok().body(serviceStationOnShore.retrieve(pageable, q));
    }
    @PutMapping("/{id}") @PreAuthorize("hasAnyRole('MODERATOR', 'ADMIN')")
    public ResponseEntity<DTOResponseStationOnShore> update(@PathVariable("id") UUID id, @RequestBody @Valid DTORequestStationOnShore updated){
        return ResponseEntity.accepted().body(serviceStationOnShore.update(id, updated));
    }
    @DeleteMapping("/{id}") @PreAuthorize("hasAnyRole('MODERATOR', 'ADMIN')")
    public ResponseEntity<DTOResponseStationOnShore> delete(@PathVariable UUID id){
        return ResponseEntity.accepted().body(serviceStationOnShore.delete(id));
    }
    @DeleteMapping("") @PreAuthorize("hasAnyRole('MODERATOR', 'ADMIN')")
    public ResponseEntity<HttpStatus> delete(){
        try {
            serviceStationOnShore.delete();
            return new ResponseEntity<>(null, HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(HttpStatus.BAD_REQUEST);
        }
    }
}