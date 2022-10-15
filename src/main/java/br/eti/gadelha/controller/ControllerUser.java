package br.eti.gadelha.controller;

import br.eti.gadelha.exception.ErrorResponse;
import br.eti.gadelha.exception.TokenRefreshException;
import br.eti.gadelha.persistence.payload.request.DTORequestTokenRefresh;
import br.eti.gadelha.persistence.payload.request.DTORequestUser;
import br.eti.gadelha.persistence.payload.request.DTORequestJwt;
import br.eti.gadelha.persistence.payload.response.DTOResponseTokenRefresh;
import br.eti.gadelha.persistence.payload.response.DTOResponseUser;
import br.eti.gadelha.persistence.model.RefreshToken;
import br.eti.gadelha.persistence.payload.request.DTORequestLogOut;
import br.eti.gadelha.security.jwt.JwtUtils;
import br.eti.gadelha.services.ServiceRefreshToken;
import br.eti.gadelha.services.ServiceUser;
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

@RestController @RequestMapping("/user") @RequiredArgsConstructor
@CrossOrigin(origins = "*", maxAge = 3600)
public class ControllerUser implements ControllerInterface<DTOResponseUser, DTORequestUser> {

    @Autowired
    private final ServiceUser serviceUser;
    @Autowired
    JwtUtils jwtUtils;
    @Autowired
    ServiceRefreshToken serviceRefreshToken;

    @PostMapping("") @PreAuthorize("hasAnyRole('MODERATOR', 'ADMIN')")
    public ResponseEntity<DTOResponseUser> create(@RequestBody @Valid DTORequestUser created){
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/user").toUriString());
        return ResponseEntity.created(uri).body(serviceUser.create(created));
    }
    @GetMapping("/retrieve")
    public List<DTOResponseUser> retrieve(){
        return serviceUser.retrieve();
    }
    @GetMapping("") @PreAuthorize("hasAnyRole('MODERATOR', 'ADMIN')")
    public ResponseEntity<Page<DTOResponseUser>> retrieve(Pageable pageable){
        return ResponseEntity.ok().body(serviceUser.retrieve(pageable));
    }
    @GetMapping("/{id}") @PreAuthorize("hasAnyRole('MODERATOR', 'ADMIN')")
    public ResponseEntity<DTOResponseUser> retrieve(@PathVariable UUID id){
        return ResponseEntity.ok().body(serviceUser.retrieve(id));
    }
    @GetMapping("/source") @PreAuthorize("hasAnyRole('MODERATOR', 'ADMIN')")
    public ResponseEntity<Page<DTOResponseUser>> retrieve(Pageable pageable, @RequestParam(required = false) String q){
        return ResponseEntity.ok().body(serviceUser.retrieve(pageable, q));
    }
    @PutMapping("/{id}") @PreAuthorize("hasAnyRole('MODERATOR', 'ADMIN')")
    public ResponseEntity<DTOResponseUser> update(@PathVariable("id") UUID id, @RequestBody @Valid DTORequestUser updated){
        return ResponseEntity.accepted().body(serviceUser.update(id, updated));
    }
    @DeleteMapping("/{id}") @PreAuthorize("hasAnyRole('MODERATOR', 'ADMIN')")
    public ResponseEntity<DTOResponseUser> delete(@PathVariable UUID id){
        return ResponseEntity.accepted().body(serviceUser.delete(id));
    }
    @DeleteMapping("") @PreAuthorize("hasAnyRole('MODERATOR', 'ADMIN')")
    public ResponseEntity<HttpStatus> delete(){
        try {
            serviceUser.delete();
            return new ResponseEntity<>(null, HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/signin")
    public ResponseEntity<?> signin(@Valid @RequestBody DTORequestJwt dtoRequestJwt) {
        try {
            return new ResponseEntity<>(serviceUser.signin(dtoRequestJwt), HttpStatus.OK);
        } catch (Exception e) {
            ErrorResponse errorResponse = new ErrorResponse(HttpStatus.FORBIDDEN, e.getStackTrace().toString(), e.toString());
            errorResponse.addValidationError(e.getMessage(), e.getMessage());
            return new ResponseEntity<>(errorResponse, HttpStatus.FORBIDDEN);
        }
    }
    @PostMapping("/logout")
    public ResponseEntity<HttpStatus> logout(@Valid @RequestBody DTORequestLogOut DTORequestLogOut) {
        try {
            serviceUser.logout(DTORequestLogOut);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PostMapping("/refreshtoken")
    public ResponseEntity<?> refreshtoken(@Valid @RequestBody DTORequestTokenRefresh request) {
        String requestRefreshToken = request.getRefreshToken();

        return serviceRefreshToken.findByToken(requestRefreshToken)
                .map(serviceRefreshToken::verifyExpiration)
                .map(RefreshToken::getUser)
                .map(user -> {
                    String token = jwtUtils.generateTokenFromUsername(user.getUsername());
                    return ResponseEntity.ok(new DTOResponseTokenRefresh(token, requestRefreshToken));
                })
                .orElseThrow(() -> new TokenRefreshException(requestRefreshToken,
                        "Refresh token is not in database!"));
    }
    @PutMapping("/changePassword/{id}")
    public ResponseEntity<DTOResponseUser> changePassword(@PathVariable("id") UUID id, @RequestBody @Valid DTORequestUser updated){
        try {
            return new ResponseEntity<>(serviceUser.changePassword(id, updated), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}