package br.eti.gadelha.controller;

import javax.validation.Valid;

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
import br.eti.gadelha.services.ServiceRole;
import br.eti.gadelha.services.ServiceUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author	Marcelo Ribeiro Gadelha
 * @mail	gadelha.ti@gmail.com
 * @since	03/10/2021
 * @version 1.0
 * @link	www.gadelha.eti.br
 **/

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/auth")
public class ControllerAuth {

  @Autowired
  private final ServiceUser serviceUser;
  @Autowired
  private final ServiceRole serviceRole;
  @Autowired
  JwtUtils jwtUtils;
  @Autowired
  RefreshTokenService refreshTokenService;

  public ControllerAuth (RepositoryUser repositoryUser, RepositoryRole repositoryRole) {
    this.serviceUser = new ServiceUser(repositoryUser, repositoryRole) {};
    this.serviceRole = new ServiceRole(repositoryRole) {};
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
}