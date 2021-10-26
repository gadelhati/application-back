package br.eti.gadelha.services;

import br.eti.gadelha.persistence.dto.request.DTORequestUser;
import br.eti.gadelha.persistence.dto.response.DTOResponseUser;
import br.eti.gadelha.persistence.model.User;
import br.eti.gadelha.persistence.repository.RepositoryUser;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @author	Marcelo Ribeiro Gadelha
 * @mail	gadelha.ti@gmail.com
 * @link	www.gadelha.eti.br
 **/

@Service
public class ServiceUser {

    private final RepositoryUser repository;

    public ServiceUser(RepositoryUser repository) {
        this.repository = repository;
    }

    public DTOResponseUser create(DTORequestUser created){
//        User user = DTORequestUser.toModel(created);
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
        user.setPassword(updated.getPassword());
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
}