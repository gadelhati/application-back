package br.eti.gadelha.controller;

import br.eti.gadelha.persistence.payload.request.DTORequestStationOffShore;
import br.eti.gadelha.persistence.payload.response.DTOResponseStationOffShore;
import br.eti.gadelha.services.ServiceStationOffShore;
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

@RestController @RequestMapping("/stationOffShore") @RequiredArgsConstructor
@CrossOrigin(origins = "*", maxAge = 3600)
public class ControllerStationOffShore implements ControllerInterface<DTOResponseStationOffShore, DTORequestStationOffShore> {

    @Autowired
    private final ServiceStationOffShore serviceStationOffShore;

    @PostMapping("") @PreAuthorize("hasAnyRole('MODERATOR', 'ADMIN')")
    public ResponseEntity<DTOResponseStationOffShore> create(@RequestBody @Valid DTORequestStationOffShore created){
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/stationOnShore").toUriString());
        return ResponseEntity.created(uri).body(serviceStationOffShore.create(created));
    }
    @GetMapping("/retrieve")
    public List<DTOResponseStationOffShore> retrieve(){
        return serviceStationOffShore.retrieve();
    }
    @GetMapping("") @PreAuthorize("hasAnyRole('MODERATOR', 'ADMIN')")
    public ResponseEntity<Page<DTOResponseStationOffShore>> retrieve(Pageable pageable){
        return ResponseEntity.ok().body(serviceStationOffShore.retrieve(pageable));
    }
    @GetMapping("/{id}") @PreAuthorize("hasAnyRole('MODERATOR', 'ADMIN')")
    public ResponseEntity<DTOResponseStationOffShore> retrieve(@PathVariable UUID id){
        return ResponseEntity.ok().body(serviceStationOffShore.retrieve(id));
    }
    @GetMapping("/source") @PreAuthorize("hasAnyRole('MODERATOR', 'ADMIN')")
    public ResponseEntity<Page<DTOResponseStationOffShore>> retrieve(Pageable pageable, @RequestParam(required = false) String q){
        return ResponseEntity.ok().body(serviceStationOffShore.retrieve(pageable, q));
    }
    @PutMapping("/{id}") @PreAuthorize("hasAnyRole('MODERATOR', 'ADMIN')")
    public ResponseEntity<DTOResponseStationOffShore> update(@PathVariable("id") UUID id, @RequestBody @Valid DTORequestStationOffShore updated){
        return ResponseEntity.accepted().body(serviceStationOffShore.update(id, updated));
    }
    @DeleteMapping("/{id}") @PreAuthorize("hasAnyRole('MODERATOR', 'ADMIN')")
    public ResponseEntity<DTOResponseStationOffShore> delete(@PathVariable UUID id){
        return ResponseEntity.accepted().body(serviceStationOffShore.delete(id));
    }
    @DeleteMapping("") @PreAuthorize("hasAnyRole('MODERATOR', 'ADMIN')")
    public ResponseEntity<HttpStatus> delete(){
        try {
            serviceStationOffShore.delete();
            return new ResponseEntity<>(null, HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(HttpStatus.BAD_REQUEST);
        }
    }
}