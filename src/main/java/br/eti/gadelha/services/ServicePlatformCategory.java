package br.eti.gadelha.services;

import br.eti.gadelha.persistence.dto.request.DTORequestPlatformCategory;
import br.eti.gadelha.persistence.dto.response.DTOResponsePlatformCategory;
import br.eti.gadelha.persistence.model.unity.PlatformCategory;
import br.eti.gadelha.persistence.repository.RepositoryPlatformCategory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class ServicePlatformCategory {

    private final RepositoryPlatformCategory repository;

    public ServicePlatformCategory(RepositoryPlatformCategory repository) {
        this.repository = repository;
    }

    public DTOResponsePlatformCategory create(DTORequestPlatformCategory created){
        return DTOResponsePlatformCategory.toDTO(repository.save(created.toObject()));
    }
    public DTOResponsePlatformCategory retrieve(UUID id){
        return DTOResponsePlatformCategory.toDTO(repository.findById(id).orElse(null));
    }
    public List<DTOResponsePlatformCategory> retrieve(){
        List<DTOResponsePlatformCategory> list = new ArrayList<>();
        for(PlatformCategory object: repository.findAll()) {
            list.add(DTOResponsePlatformCategory.toDTO(object));
        }
        return list;
    }
    public Page<DTOResponsePlatformCategory> retrieve(Pageable pageable){
        List<DTOResponsePlatformCategory> list = new ArrayList<>();
        for(PlatformCategory object: repository.findAll()) {
            list.add(DTOResponsePlatformCategory.toDTO(object));
        }
        return new PageImpl<DTOResponsePlatformCategory>(list, pageable, list.size());
    }
    public Page<DTOResponsePlatformCategory> retrieve(Pageable pageable, String source){
        final List<DTOResponsePlatformCategory> list = new ArrayList<>();
        if (source == null) {
            for (PlatformCategory object : repository.findAll()) {
                list.add(DTOResponsePlatformCategory.toDTO(object));
            }
        } else {
            for (PlatformCategory object : repository.findByNameContainingIgnoreCaseOrderByNameAsc(source)) {
                list.add(DTOResponsePlatformCategory.toDTO(object));
            }
        }
        return new PageImpl<>(list, pageable, list.size());
    }
    public DTOResponsePlatformCategory update(UUID id, DTORequestPlatformCategory updated){
        PlatformCategory object = repository.findById(id).orElse(null);
        object.setName(updated.getName());
        return DTOResponsePlatformCategory.toDTO(repository.save(object));
    }
    public DTOResponsePlatformCategory delete(UUID id){
        PlatformCategory object = repository.findById(id).orElse(null);
        repository.deleteById(id);
        return DTOResponsePlatformCategory.toDTO(object);
    }
    public void delete() {
        repository.deleteAll();
    }

    public PlatformCategory findByName(String value) { return  repository.findByName(value); }
}