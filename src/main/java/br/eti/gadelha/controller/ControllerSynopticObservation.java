package br.eti.gadelha.controller;

import br.eti.gadelha.persistence.payload.request.DTORequestSynopticObservation;
import br.eti.gadelha.persistence.payload.response.DTOResponseSynopticObservation;
import br.eti.gadelha.services.ServiceSynopticObservation;
import lombok.RequiredArgsConstructor;
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

@RestController @RequestMapping("/synopticObservation") @RequiredArgsConstructor
@CrossOrigin(origins = "*", maxAge = 3600)
public class ControllerSynopticObservation {

    private final ServiceSynopticObservation serviceSynopticObservation;

    @PostMapping("") @PreAuthorize("hasAnyRole('USER', 'MODERATOR', 'ADMIN', 'OPERATOR', 'RECTIFIER')")
    public ResponseEntity<DTOResponseSynopticObservation> create(@RequestBody @Valid DTORequestSynopticObservation created){
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/synopticObservation").toUriString());
        return ResponseEntity.created(uri).body(serviceSynopticObservation.create(created));
    }
    @PostMapping("/createAll") @PreAuthorize("hasAnyRole('USER', 'MODERATOR', 'ADMIN', 'OPERATOR', 'RECTIFIER')")
    public ResponseEntity<List<DTOResponseSynopticObservation>> create(@RequestBody @Valid List<DTORequestSynopticObservation> createds){
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/synopticObservation/createAll").toUriString());
        return ResponseEntity.created(uri).body(serviceSynopticObservation.create(createds));
//        List<DTOResponseSynopticObservation> dtoResponseSynopticObservationsCreated = new ArrayList<>();
//        List<DTOResponseSynopticObservation> dtoResponseSynopticObservationsFailed = new ArrayList<>();
//        for(DTORequestSynopticObservation dtoRequestSynopticObservation : createds) {
//            try {
////                service.create(dtoRequestSynopticObservation);
//                create(dtoRequestSynopticObservation);
//                dtoResponseSynopticObservationsCreated.add(new DTOResponseSynopticObservation().toDTO(dtoRequestSynopticObservation.toObject()));
//            } catch (Exception e) {
//                dtoResponseSynopticObservationsFailed.add(new DTOResponseSynopticObservation().toDTO(dtoRequestSynopticObservation.toObject()));
//            }
//        }
//        if(!dtoResponseSynopticObservationsCreated.isEmpty()){
//            return new ResponseEntity<>(dtoResponseSynopticObservationsCreated, HttpStatus.CREATED);
//        } else {
//            return new ResponseEntity<>(dtoResponseSynopticObservationsFailed, HttpStatus.INTERNAL_SERVER_ERROR);
//        }
    }
    @GetMapping("/retrieve")
    public List<DTOResponseSynopticObservation> retrieve(){
        return serviceSynopticObservation.retrieve();
    }
    @GetMapping("")
    public ResponseEntity<Page<DTOResponseSynopticObservation>> retrieve(Pageable pageable){
        return ResponseEntity.ok().body(serviceSynopticObservation.retrieve(pageable));
    }
    @GetMapping("/{id}") @PreAuthorize("hasAnyRole('USER', 'MODERATOR', 'ADMIN', 'OPERATOR', 'RECTIFIER')")
    public ResponseEntity<DTOResponseSynopticObservation> retrieve(@RequestBody @Valid DTORequestSynopticObservation created){
        return ResponseEntity.ok().body(serviceSynopticObservation.retrieve(created));
    }
    @GetMapping("/source")
    public ResponseEntity<Page<DTOResponseSynopticObservation>> retrieve(Pageable pageable, @RequestParam(required = false) String q){
        return ResponseEntity.ok().body(serviceSynopticObservation.retrieveSource(pageable, q));
    }
    @PutMapping("/{id}") @PreAuthorize("hasAnyRole('USER', 'MODERATOR', 'ADMIN', 'OPERATOR', 'RECTIFIER')")
    public ResponseEntity<DTOResponseSynopticObservation> update(@PathVariable("id") String id, @RequestBody @Valid DTORequestSynopticObservation updated){
        return ResponseEntity.accepted().body(serviceSynopticObservation.update(updated));
    }
    @DeleteMapping("/{dateObservation}/{ddddddd}") @PreAuthorize("hasAnyRole('USER', 'MODERATOR', 'ADMIN', 'RECTIFIER')")
    public ResponseEntity<DTOResponseSynopticObservation> delete(@PathVariable String dateObservation, @PathVariable String ddddddd){
        return ResponseEntity.accepted().body(serviceSynopticObservation.delete(dateObservation, ddddddd));
    }
    @DeleteMapping("") @PreAuthorize("hasAnyRole('MODERATOR', 'ADMIN', 'RECTIFIER')")
    public ResponseEntity<HttpStatus> delete(){
        try {
            serviceSynopticObservation.delete();
            return new ResponseEntity<>(null, HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}