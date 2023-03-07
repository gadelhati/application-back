package br.eti.gadelha.controller;

import br.eti.gadelha.persistence.payload.request.DTORequestStationShip;
import br.eti.gadelha.persistence.payload.response.DTOResponseStationShip;
import br.eti.gadelha.services.ServiceStationShip;
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
public class ControllerStationShip implements ControllerInterface<DTOResponseStationShip, DTORequestStationShip> {

    @Autowired
    private final ServiceStationShip serviceStationShip;

    @PostMapping("") @PreAuthorize("hasAnyRole('MODERATOR', 'ADMIN')")
    public ResponseEntity<DTOResponseStationShip> create(@RequestBody @Valid DTORequestStationShip created){
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/stationOnShore").toUriString());
        return ResponseEntity.created(uri).body(serviceStationShip.create(created));
    }
    @GetMapping("/retrieve")
    public List<DTOResponseStationShip> retrieve(){
        return serviceStationShip.retrieve();
    }
    @GetMapping("") @PreAuthorize("hasAnyRole('MODERATOR', 'ADMIN')")
    public ResponseEntity<Page<DTOResponseStationShip>> retrieve(Pageable pageable){
        return ResponseEntity.ok().body(serviceStationShip.retrieve(pageable));
    }
    @GetMapping("/{id}") @PreAuthorize("hasAnyRole('MODERATOR', 'ADMIN')")
    public ResponseEntity<DTOResponseStationShip> retrieve(@PathVariable UUID id){
        return ResponseEntity.ok().body(serviceStationShip.retrieve(id));
    }
    @GetMapping("/source") @PreAuthorize("hasAnyRole('MODERATOR', 'ADMIN')")
    public ResponseEntity<Page<DTOResponseStationShip>> retrieve(Pageable pageable, @RequestParam(required = false) String q){
        return ResponseEntity.ok().body(serviceStationShip.retrieve(pageable, q));
    }
    @PutMapping("/{id}") @PreAuthorize("hasAnyRole('MODERATOR', 'ADMIN')")
    public ResponseEntity<DTOResponseStationShip> update(@PathVariable("id") UUID id, @RequestBody @Valid DTORequestStationShip updated){
        return ResponseEntity.accepted().body(serviceStationShip.update(id, updated));
    }
    @DeleteMapping("/{id}") @PreAuthorize("hasAnyRole('MODERATOR', 'ADMIN')")
    public ResponseEntity<DTOResponseStationShip> delete(@PathVariable UUID id){
        return ResponseEntity.accepted().body(serviceStationShip.delete(id));
    }
    @DeleteMapping("") @PreAuthorize("hasAnyRole('MODERATOR', 'ADMIN')")
    public ResponseEntity<HttpStatus> delete(){
        try {
            serviceStationShip.delete();
            return new ResponseEntity<>(null, HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(HttpStatus.BAD_REQUEST);
        }
    }
}