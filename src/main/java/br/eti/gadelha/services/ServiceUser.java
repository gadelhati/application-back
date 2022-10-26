package br.eti.gadelha.services;

import br.eti.gadelha.persistence.payload.request.DTORequestUser;
import br.eti.gadelha.persistence.payload.request.DTORequestJwt;
import br.eti.gadelha.persistence.payload.response.DTOResponseUser;
import br.eti.gadelha.persistence.model.*;
import br.eti.gadelha.persistence.payload.request.DTORequestLogOut;
import br.eti.gadelha.persistence.payload.response.DTOResponseJwt;
import br.eti.gadelha.persistence.repository.RepositoryOM;
import br.eti.gadelha.persistence.repository.RepositoryRole;
import br.eti.gadelha.persistence.repository.RepositoryUser;
import br.eti.gadelha.security.jwt.JwtUtils;
import lombok.RequiredArgsConstructor;
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

@Service @RequiredArgsConstructor
public class ServiceUser implements UserDetailsService, ServiceInterface<DTOResponseUser, DTORequestUser, User> {

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
    private final RepositoryOM repositoryOM;

    public DTOResponseUser create(DTORequestUser created){
        Collection<Role> roleList = new ArrayList<>();
        for(Role role: created.getRoles()) {
            Role search = repositoryRole.findByName(role.getName());
            roleList.add(search);
        }
        if(roleList == null) {
            created.setRoles(Arrays.asList(repositoryRole.findByName("ROLE_USER")));
        }
        created.setRoles(roleList);
        User user = new User(
                created.getUsername(),
                created.getEmail(),
                encoder.encode(created.getPassword()),
                created.isActive(),
                created.getRoles()
        );
        return DTOResponseUser.toDTO(repositoryUser.save(user));
    }
    public DTOResponseUser retrieve(UUID id){
        return DTOResponseUser.toDTO(repositoryUser.findById(id).orElse(null));
    }
    public List<DTOResponseUser> retrieve(){
        List<DTOResponseUser> list = new ArrayList<>();
        for(User user: repositoryUser.findAll()) {
            list.add(DTOResponseUser.toDTO(user));
        }
        return list;
    }
    public Page<DTOResponseUser> retrieve(Pageable pageable){
        List<DTOResponseUser> list = new ArrayList<>();
        for(User object: repositoryUser.findAll()) {
            list.add(DTOResponseUser.toDTO(object));
        }
        return new PageImpl<DTOResponseUser>(list, pageable, list.size());
    }
    public Page<DTOResponseUser> retrieve(Pageable pageable, String source){
        final List<DTOResponseUser> list = new ArrayList<>();
        if (source == null) {
            for (User user : repositoryUser.findAll()) {
                list.add(DTOResponseUser.toDTO(user));
            }
        } else {
            for (User object : repositoryUser.findByUsernameContainingIgnoreCaseOrderByUsernameAsc(source)) {
                list.add(DTOResponseUser.toDTO(object));
            }
        }
        return new PageImpl<DTOResponseUser>(list, pageable, list.size());
    }
    public DTOResponseUser update(UUID id, DTORequestUser updated){
        User user = repositoryUser.findById(id).orElse(null);
        user.setUsername(updated.getUsername());
        user.setEmail(updated.getEmail());
        if(!user.getPassword().equals(repositoryUser.getUserByUsername(updated.getUsername()).getPassword())) {
            user.setPassword(encoder.encode(updated.getPassword()));
        }
        user.setActive(updated.isActive());
        user.setOm(updated.getOm());
        List<Role> roleList = new ArrayList<>();
        for(Role role: updated.getRoles()) {
            Role search = repositoryRole.findByName(role.getName());
            roleList.add(search);
        }
        user.setRoles(roleList);
        return DTOResponseUser.toDTO(repositoryUser.save(user));
    }
    public DTOResponseUser delete(UUID id){
        User object = repositoryUser.findById(id).orElse(null);
        repositoryUser.deleteById(id);
        return DTOResponseUser.toDTO(object);
    }
    public void delete() {
        repositoryUser.deleteAll();
    }
    public User findByName(String value) {
        return repositoryUser.findByUsername(value).orElse(null);
    }
    public boolean existsByName(String value) {
        return repositoryUser.existsByUsernameContainingIgnoreCase(value);
    }

    public boolean existsByEmail(String value) {
        return repositoryUser.existsByEmail(value);
    }
    public DTOResponseJwt signin(DTORequestJwt dtoRequestJwt) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(dtoRequestJwt.getUsername(), dtoRequestJwt.getPassword()));
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
    public DTOResponseUser changePassword(UUID id, DTORequestUser updated){
        User user = repositoryUser.findById(id).orElse(null);
        user.setPassword(encoder.encode(updated.getPassword()));
        return DTOResponseUser.toDTO(repositoryUser.save(user));
    }
    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = repositoryUser.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + username));

        return UserDetailsImpl.build(user);
    }
    public User getCurrentUser() {
        return findByName(((UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsername());
    }
}