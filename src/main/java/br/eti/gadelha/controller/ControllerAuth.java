package br.eti.gadelha.controller;

import javax.validation.Valid;

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
import br.eti.gadelha.services.ServiceRole;
import br.eti.gadelha.services.ServiceUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author	Marcelo Ribeiro Gadelha
 * @mail	gadelha.ti@gmail.com
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
  ServiceRefreshToken serviceRefreshToken;

  public ControllerAuth (RepositoryUser repositoryUser, RepositoryRole repositoryRole, RepositoryOM repositoryOM) {
    this.serviceUser = new ServiceUser(repositoryUser, repositoryRole, repositoryOM) {};
    this.serviceRole = new ServiceRole(repositoryRole) {};
  }
  @PostMapping("/signin")
  public ResponseEntity<DTOResponseJwt> authenticateUser(@Valid @RequestBody DTORequestUserLogin dtoRequestUser) {
    try {
      return new ResponseEntity<>(serviceUser.signin(dtoRequestUser), HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }
  @PostMapping("/signup") @PreAuthorize("hasAnyRole('MODERATOR', 'ADMIN', 'RECTIFIER')")
  public ResponseEntity<DTOResponseUser> registerUser(@Valid @RequestBody DTORequestUser dtoRequestUser) {
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
}