package br.eti.gadelha.services;

import br.eti.gadelha.persistence.dto.request.DTORequestUser;
import br.eti.gadelha.persistence.dto.request.DTORequestUserLogin;
import br.eti.gadelha.persistence.dto.response.DTOResponseUser;
import br.eti.gadelha.exception.enumeration.ERole;
import br.eti.gadelha.persistence.model.RefreshToken;
import br.eti.gadelha.persistence.model.Role;
import br.eti.gadelha.persistence.model.User;
import br.eti.gadelha.persistence.dto.request.DTORequestLogOut;
import br.eti.gadelha.persistence.dto.response.DTOResponseJwt;
import br.eti.gadelha.persistence.model.UserDetailsImpl;
import br.eti.gadelha.persistence.repository.RepositoryRole;
import br.eti.gadelha.persistence.repository.RepositoryUser;
import br.eti.gadelha.security.jwt.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author	Marcelo Ribeiro Gadelha
 * @mail	gadelha.ti@gmail.com
 * @link	www.gadelha.eti.br
 **/

@Service
public class ServiceUser implements UserDetailsService {

    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    JwtUtils jwtUtils;
    @Autowired
    ServiceRefreshToken serviceRefreshToken;
    @Autowired
    PasswordEncoder encoder;
    private final RepositoryUser repositoryUser;
    private final RepositoryRole repositoryRole;

    public ServiceUser(RepositoryUser repository, RepositoryRole repositoryRole) {
        this.repositoryUser = repository;
        this.repositoryRole = repositoryRole;
    }
    public DTOResponseJwt signin(DTORequestUserLogin dtoRequestUser) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(dtoRequestUser.getUsername(), dtoRequestUser.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        String jwt = jwtUtils.generateJwtToken(userDetails);
        List<String> roles = userDetails.getAuthorities().stream().map(item -> item.getAuthority()).collect(Collectors.toList());
        RefreshToken refreshToken = serviceRefreshToken.createRefreshToken(userDetails.getId());
        return new DTOResponseJwt(jwt, refreshToken.getToken(), userDetails.getId(), userDetails.getUsername(), userDetails.getEmail(), roles);
    }
    public void logout(DTORequestLogOut value) {
        serviceRefreshToken.deleteByUserId(value.getUserId());
    }
    public DTOResponseUser signup(DTORequestUser dtoRequestUser) {
        User user = new User(dtoRequestUser.getUsername(), dtoRequestUser.getEmail(), encoder.encode(dtoRequestUser.getPassword()));
        Set<Role> roles = new HashSet<>();
        roles.add(repositoryRole.findByName(ERole.ROLE_USER));
        user.setRoles(roles);
        return DTOResponseUser.toDTO(repositoryUser.save(user));
    }
    public DTOResponseUser create(DTORequestUser created){
        Set<Role> roles = new HashSet<>();
        roles.add(repositoryRole.findByName(ERole.ROLE_USER));
        created.setRoles(roles);
        return DTOResponseUser.toDTO(repositoryUser.save(created.toObject()));
    }
    public Page<DTOResponseUser> retrieve(Pageable pageable){
        List<DTOResponseUser> list = new ArrayList<>();
        for(User user: repositoryUser.findAll()) {
            list.add(DTOResponseUser.toDTO(user));
        }
        return new PageImpl<DTOResponseUser>(list, pageable, list.size());
    }
    public DTOResponseUser retrieve(UUID id){
        return DTOResponseUser.toDTO(repositoryUser.findById(id).get());
    }
    public Page<DTOResponseUser> retrieveSource(Pageable pageable, String source){
        final List<DTOResponseUser> list = new ArrayList<>();
        if (source == null) {
            for (User user : repositoryUser.findAll()) {
                list.add(DTOResponseUser.toDTO(user));
            }
        } else {
            for (User user : repositoryUser.findByUsernameContainingIgnoreCaseOrderByUsernameAsc(source)) {
                list.add(DTOResponseUser.toDTO(user));
            }
        }
        return new PageImpl<DTOResponseUser>(list, pageable, list.size());
    }
    public List<DTOResponseUser> retrieve(){
        List<DTOResponseUser> list = new ArrayList<>();
        for(User user: repositoryUser.findAll()) {
//            if(getCurrentUser().getRoles().getNome().equals("ROLE_ADMIN")) {
//                list.add(DTOResponseUser.toDTO(user));
//            } else {
                list.add(DTOResponseUser.toDTO(user));
//            }
        }
        return list;
    }
    public DTOResponseUser update(UUID id, DTORequestUser updated){
        User user = repositoryUser.findById(id).get();
        user.setUsername(updated.getUsername());
        user.setEmail(updated.getEmail());
        user.setPassword(encoder.encode(updated.getPassword()));
        user.setActive(updated.getActive());
        user.setOm(updated.getOm());
        user.setRoles(updated.getRoles());
        return DTOResponseUser.toDTO(repositoryUser.save(user));
    }
    public void delete(UUID id){
        repositoryUser.deleteById(id);
    }
    public void delete() {
        repositoryUser.deleteAll();
    };

    public boolean isNameValid(String value) {
        return repositoryUser.existsByUsername(value);
    }
    public boolean isEmailValid(String value) {
        return repositoryUser.existsByEmail(value);
    }

    public User getUserByUsername(String username) {
        return repositoryUser.getUserByUsername(username);
    }
    public User getCurrentUser() {
        return getUserByUsername(((UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsername());
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = repositoryUser.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + username));

        return UserDetailsImpl.build(user);
    }
}