package br.eti.gadelha.services;

import br.eti.gadelha.persistence.dto.request.DTORequestUser;
import br.eti.gadelha.persistence.dto.response.DTOResponseUser;
import br.eti.gadelha.persistence.model.ERole;
import br.eti.gadelha.persistence.model.Role;
import br.eti.gadelha.persistence.model.User;
import br.eti.gadelha.persistence.repository.RepositoryRole;
import br.eti.gadelha.persistence.repository.RepositoryUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @author	Marcelo Ribeiro Gadelha
 * @mail	gadelha.ti@gmail.com
 * @link	www.gadelha.eti.br
 **/

@Service
public class ServiceUser {

    @Autowired
    PasswordEncoder encoder;
    private final RepositoryUser repository;
    private final RepositoryRole repositoryRole;

    public ServiceUser(RepositoryUser repository, RepositoryRole repositoryRole) {
        this.repository = repository;
        this.repositoryRole = repositoryRole;
    }

    public DTOResponseUser create(DTORequestUser created){
//        User user = DTORequestUser.toModel(created);
//        User user = new User();
//        user.setRoles(ERole.ROLE_USER);
        Set<Role> roles = new HashSet<>();
        roles.add(repositoryRole.findByName(ERole.ROLE_USER));
        created.setRole(roles);
        return DTOResponseUser.toDTO(repository.save(created.toObject()));
    }
    public Page<DTOResponseUser> retrieve(Pageable pageable){
        List<DTOResponseUser> list = new ArrayList<>();
        for(User user: repository.findAll()) {
            list.add(DTOResponseUser.toDTO(user));
        }
        return new PageImpl<DTOResponseUser>(list, pageable, list.size());
    }
    public DTOResponseUser retrieve(UUID id){
        return DTOResponseUser.toDTO(repository.findById(id).get());
    }
    public Page<DTOResponseUser> retrieveSource(Pageable pageable, String source){
        final List<DTOResponseUser> list = new ArrayList<>();
        if (source == null) {
            for (User user : repository.findAll()) {
                list.add(DTOResponseUser.toDTO(user));
            }
        } else {
            for (User user : repository.findByUsernameContainingIgnoreCaseOrderByUsernameAsc(source)) {
                list.add(DTOResponseUser.toDTO(user));
            }
        }
        return new PageImpl<DTOResponseUser>(list, pageable, list.size());
    }
    public DTOResponseUser update(UUID id, DTORequestUser updated){
        User user = repository.findById(id).get();
        user.setUsername(updated.getUsername());
        user.setPassword(encoder.encode(updated.getPassword()));
        return DTOResponseUser.toDTO(repository.save(user));
    }
    public void delete(UUID id){
        repository.deleteById(id);
    }
    public void delete() {
        repository.deleteAll();
    };

    public boolean isNameValid(String value) {
        return repository.existsByUsername(value);
    }
    public boolean isEmailValid(String value) {
        return repository.existsByEmail(value);
    }
}