package br.eti.gadelha.controller;

import br.eti.gadelha.exception.TokenRefreshException;
import br.eti.gadelha.persistence.dto.request.DTORequestTokenRefresh;
import br.eti.gadelha.persistence.dto.request.DTORequestUser;
import br.eti.gadelha.persistence.dto.request.DTORequestUserLogin;
import br.eti.gadelha.persistence.dto.response.DTOResponseTokenRefresh;
import br.eti.gadelha.persistence.dto.response.DTOResponseUser;
import br.eti.gadelha.persistence.model.RefreshToken;
import br.eti.gadelha.persistence.dto.request.DTORequestLogOut;
import br.eti.gadelha.persistence.dto.response.DTOResponseJwt;
import br.eti.gadelha.persistence.repository.RepositoryOM;
import br.eti.gadelha.persistence.repository.RepositoryRole;
import br.eti.gadelha.persistence.repository.RepositoryUser;
import br.eti.gadelha.security.jwt.JwtUtils;
import br.eti.gadelha.services.ServiceRefreshToken;
import br.eti.gadelha.services.ServiceUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
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
    ServiceRefreshToken serviceRefreshToken;

    public ControllerUser(RepositoryUser repositoryUser, RepositoryRole repositoryRole, RepositoryOM repositoryOM) {
        this.serviceUser = new ServiceUser(repositoryUser, repositoryRole, repositoryOM) {};
    }

    @PostMapping("/signin")
    public ResponseEntity<DTOResponseJwt> signin(@Valid @RequestBody DTORequestUserLogin dtoRequestUser) {
        try {
            return new ResponseEntity<>(serviceUser.signin(dtoRequestUser), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PostMapping("/signup")	@PreAuthorize("hasAnyRole('MODERATOR', 'ADMIN')")
    public ResponseEntity<DTOResponseUser> signup(@Valid @RequestBody DTORequestUser dtoRequestUser) {
        try {
            return new ResponseEntity<>(serviceUser.signup(dtoRequestUser), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PostMapping("/logout")
    public ResponseEntity<HttpStatus> logoutUser(@Valid @RequestBody DTORequestLogOut DTORequestLogOut) {
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

    @PostMapping("") @PreAuthorize("hasAnyRole('MODERATOR', 'ADMIN')")
    public ResponseEntity<DTOResponseUser> create(@RequestBody @Valid DTORequestUser created){
        try {
            return new ResponseEntity<>(serviceUser.create(created), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/retrieve")
    public List<DTOResponseUser> retrieveAll(){
        return serviceUser.retrieve();
    }
    @GetMapping("") @PreAuthorize("hasAnyRole('MODERATOR', 'ADMIN')")
    public ResponseEntity<Page<DTOResponseUser>> retrieve(Pageable pageable){
        return new ResponseEntity<>(serviceUser.retrieve(pageable), HttpStatus.FOUND);
    }
    @GetMapping("/{id}") @PreAuthorize("hasAnyRole('MODERATOR', 'ADMIN')")
    public ResponseEntity<DTOResponseUser> retrieve(@PathVariable UUID id){
        try {
            return new ResponseEntity<>(serviceUser.retrieve(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/source") @PreAuthorize("hasAnyRole('MODERATOR', 'ADMIN')")
    public ResponseEntity<Page<DTOResponseUser>> retrieveSource(Pageable pageable, @RequestParam(required = false) String q){
        try {
            return new ResponseEntity<>(serviceUser.retrieveSource(pageable, q), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PutMapping("/{id}") @PreAuthorize("hasAnyRole('MODERATOR', 'ADMIN')")
    public ResponseEntity<DTOResponseUser> update(@PathVariable("id") UUID id, @RequestBody @Valid DTORequestUser updated){
        try {
            return new ResponseEntity<>(serviceUser.update(id, updated), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @DeleteMapping("/{id}") @PreAuthorize("hasAnyRole('MODERATOR', 'ADMIN')")
    public ResponseEntity<DTOResponseUser> delete(@PathVariable UUID id){
        try {
            return new ResponseEntity<>(serviceUser.delete(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @DeleteMapping("") @PreAuthorize("hasAnyRole('MODERATOR', 'ADMIN')")
    public ResponseEntity<HttpStatus> delete(){
        try {
            serviceUser.delete();
            return new ResponseEntity<>(null, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PutMapping("/changePassword/{id}") @PreAuthorize("hasAnyRole('MODERATOR', 'ADMIN', 'USER')")
    public ResponseEntity<DTOResponseUser> changePassword(@PathVariable("id") UUID id, @RequestBody @Valid DTORequestUser updated){
        try {
            return new ResponseEntity<>(serviceUser.changePassword(id, updated), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}