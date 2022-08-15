package br.eti.gadelha.services;

import br.eti.gadelha.persistence.dto.request.DTORequestRole;
import br.eti.gadelha.persistence.dto.response.DTOResponseRole;
import br.eti.gadelha.exception.enumeration.ERole;
import br.eti.gadelha.persistence.model.Role;
import br.eti.gadelha.persistence.repository.RepositoryRole;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class ServiceRole {

    private final RepositoryRole repository;

    public ServiceRole(RepositoryRole repository) {
        this.repository = repository;
    }

    public DTOResponseRole create(DTORequestRole created){
//        Role role = MAPPER_ROLE.toObject(created);
        return DTOResponseRole.toDTO(repository.save(created.toObject()));
    }
    public Page<DTOResponseRole> retrieve(Pageable pageable){
        List<DTOResponseRole> list = new ArrayList<>();
        for(Role role: repository.findAll()) {
            list.add(DTOResponseRole.toDTO(role));
        }
        return new PageImpl<DTOResponseRole>(list, pageable, list.size());
    }
    public DTOResponseRole retrieve(UUID id){
        return DTOResponseRole.toDTO(repository.findById(id).orElse(null));
    }
    public Page<DTOResponseRole> retrieve(Pageable pageable, String source){
        final List<DTOResponseRole> list = new ArrayList<>();
        if (source == null) {
            for (Role role : repository.findAll()) {
                list.add(DTOResponseRole.toDTO(role));
            }
        } else {
//            for (Role role : repository.findByNameContainingIgnoreCaseOrderByNameAsc(source)) {
//                list.add(DTOResponseRole.toDTO(role));
//            }
        }
        return new PageImpl<>(list, pageable, list.size());
    }
    public DTOResponseRole update(UUID id, DTORequestRole updated){
        Role role = repository.findById(id).orElse(null);
        role.setName(updated.getName());
        return DTOResponseRole.toDTO(repository.save(role));
    }
    public DTOResponseRole delete(UUID id){
        Role object = repository.findById(id).orElse(null);
        repository.deleteById(id);
        return DTOResponseRole.toDTO(object);
    }
    public void delete() {
        repository.deleteAll();
    }

    public boolean isNameValid(String value) {
        return repository.existsByName(value);
    }
    public Role findByName(ERole eRole) { return  repository.findByName(eRole); }
}