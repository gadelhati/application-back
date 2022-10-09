package br.eti.gadelha.services;

import br.eti.gadelha.persistence.dto.request.DTORequestRole;
import br.eti.gadelha.persistence.dto.response.DTOResponseRole;
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
public class ServiceRole implements ServiceInterface<DTOResponseRole, DTORequestRole, Role> {

    private final RepositoryRole repositoryRole;

    public ServiceRole(RepositoryRole repositoryRole) {
        this.repositoryRole = repositoryRole;
    }

    public DTOResponseRole create(DTORequestRole created){
        return DTOResponseRole.toDTO(repositoryRole.save(created.toObject()));
    }
    public DTOResponseRole retrieve(UUID id) {
        return DTOResponseRole.toDTO(repositoryRole.findById(id).orElse(null));
    }
    public List<DTOResponseRole> retrieve(){
        List<DTOResponseRole> list = new ArrayList<>();
        for(Role role: repositoryRole.findAll()) {
            list.add(DTOResponseRole.toDTO(role));
        }
        return list;
    }
    public Page<DTOResponseRole> retrieve(Pageable pageable){
        List<DTOResponseRole> list = new ArrayList<>();
        for(Role role: repositoryRole.findAll()) {
            list.add(DTOResponseRole.toDTO(role));
        }
        return new PageImpl<DTOResponseRole>(list, pageable, list.size());
    }
    public Page<DTOResponseRole> retrieve(Pageable pageable, String source){
        final List<DTOResponseRole> list = new ArrayList<>();
        if (source == null) {
            for (Role role : repositoryRole.findAll()) {
                list.add(DTOResponseRole.toDTO(role));
            }
        } else {
            for (Role role : repositoryRole.findByNameContainingIgnoreCaseOrderByNameAsc(source)) {
                list.add(DTOResponseRole.toDTO(role));
            }
        }
        return new PageImpl<>(list, pageable, list.size());
    }
    public DTOResponseRole update(UUID id, DTORequestRole updated){
        Role role = repositoryRole.findById(id).orElse(null);
        role.setName(updated.getName());
        return DTOResponseRole.toDTO(repositoryRole.save(role));
    }
    public DTOResponseRole delete(UUID id){
        Role object = repositoryRole.findById(id).orElse(null);
        repositoryRole.deleteById(id);
        return DTOResponseRole.toDTO(object);
    }
    public void delete() {
        repositoryRole.deleteAll();
    }

    public boolean isNameValid(String value) {
        return repositoryRole.existsByName(value);
    }
    public Role findByName(String role) { return  repositoryRole.findByName(role); }
}