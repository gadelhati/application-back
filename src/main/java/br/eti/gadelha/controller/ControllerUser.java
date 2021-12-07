package br.eti.gadelha.controller;

import br.eti.gadelha.exception.TokenRefreshException;
import br.eti.gadelha.persistence.dto.request.DTORequestUser;
import br.eti.gadelha.persistence.dto.request.DTORequestUserLogin;
import br.eti.gadelha.persistence.dto.response.DTOResponseUser;
import br.eti.gadelha.persistence.model.RefreshToken;
import br.eti.gadelha.persistence.payload.request.LogOutRequest;
import br.eti.gadelha.persistence.payload.request.TokenRefreshRequest;
import br.eti.gadelha.persistence.payload.response.JwtResponse;
import br.eti.gadelha.persistence.payload.response.TokenRefreshResponse;
import br.eti.gadelha.persistence.repository.RepositoryRole;
import br.eti.gadelha.persistence.repository.RepositoryUser;
import br.eti.gadelha.security.jwt.JwtUtils;
import br.eti.gadelha.security.services.RefreshTokenService;
import br.eti.gadelha.services.ServiceUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

/**
 * @author	Marcelo Ribeiro Gadelha
 * @mail	gadelha.ti@gmail.com
 * @link	www.gadelha.eti.br
 **/

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "*", maxAge = 3600)
public class ControllerUser {

    private final ServiceUser serviceUser;
    @Autowired
    JwtUtils jwtUtils;
    @Autowired
    RefreshTokenService refreshTokenService;

    public ControllerUser(RepositoryUser repositoryUser, RepositoryRole repositoryRole) {
        this.serviceUser = new ServiceUser(repositoryUser, repositoryRole) {};
    }

    @PostMapping("/signin")
    public ResponseEntity<JwtResponse> authenticateUser(@Valid @RequestBody DTORequestUserLogin dtoRequestUser) {
        try {
            return new ResponseEntity<>(serviceUser.signin(dtoRequestUser), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PostMapping("/signup")	//@PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    public ResponseEntity<DTOResponseUser> registerUser(@Valid @RequestBody DTORequestUser dtoRequestUser) {
        try {
            return new ResponseEntity<>(serviceUser.signup(dtoRequestUser), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PostMapping("/logout")
    public ResponseEntity<HttpStatus> logoutUser(@Valid @RequestBody LogOutRequest logOutRequest) {
        try {
            serviceUser.logout(logOutRequest);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/refreshtoken")
    public ResponseEntity<?> refreshtoken(@Valid @RequestBody TokenRefreshRequest request) {
        String requestRefreshToken = request.getRefreshToken();

        return refreshTokenService.findByToken(requestRefreshToken)
                .map(refreshTokenService::verifyExpiration)
                .map(RefreshToken::getUser)
                .map(user -> {
                    String token = jwtUtils.generateTokenFromUsername(user.getUsername());
                    return ResponseEntity.ok(new TokenRefreshResponse(token, requestRefreshToken));
                })
                .orElseThrow(() -> new TokenRefreshException(requestRefreshToken,
                        "Refresh token is not in database!"));
    }

    @PostMapping("") @PreAuthorize("hasAnyRole('MODERATOR', 'ADMIN')")
    public ResponseEntity<DTOResponseUser> create(@RequestBody @Valid DTORequestUser created){
        try {
            return new ResponseEntity<>(serviceUser.create(created), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("") @PreAuthorize("hasAnyRole('MODERATOR', 'ADMIN')")
    public ResponseEntity<Page<DTOResponseUser>> retrieve(Pageable pageable){
        return new ResponseEntity<>(serviceUser.retrieve(pageable), HttpStatus.FOUND);
    }
    @GetMapping("/{id}") @PreAuthorize("hasAnyRole('MODERATOR', 'ADMIN')")
    public ResponseEntity<DTOResponseUser> retrieve(@PathVariable UUID id){
        try {
            return new ResponseEntity<>(serviceUser.retrieve(id), HttpStatus.FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/source") @PreAuthorize("hasAnyRole('MODERATOR', 'ADMIN')")
    public ResponseEntity<Page<DTOResponseUser>> retrieveSource(Pageable pageable, @RequestParam(required = false) String q){
        try {
            return new ResponseEntity<>(serviceUser.retrieveSource(pageable, q), HttpStatus.FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PutMapping("/{id}") @PreAuthorize("hasAnyRole('MODERATOR', 'ADMIN')")
    public ResponseEntity<DTOResponseUser> update(@PathVariable("id") UUID id, @RequestBody @Valid DTORequestUser updated){
        try {
            return new ResponseEntity<>(serviceUser.update(id, updated), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/{id}") @PreAuthorize("hasAnyRole('MODERATOR', 'ADMIN')")
    public ResponseEntity<HttpStatus> delete(@PathVariable UUID id){
        try {
            serviceUser.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("") @PreAuthorize("hasAnyRole('MODERATOR', 'ADMIN')")
    public ResponseEntity<HttpStatus> delete(){
        try {
            serviceUser.delete();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}