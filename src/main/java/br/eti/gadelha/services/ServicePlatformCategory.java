package br.eti.gadelha.services;

import br.eti.gadelha.persistence.payload.request.DTORequestPlatformCategory;
import br.eti.gadelha.persistence.payload.response.DTOResponsePlatformCategory;
import br.eti.gadelha.persistence.model.synopticObservation.PlatformCategory;
import br.eti.gadelha.persistence.repository.RepositoryPlatformCategory;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service @RequiredArgsConstructor
public class ServicePlatformCategory implements ServiceInterface<DTOResponsePlatformCategory, DTORequestPlatformCategory, PlatformCategory> {

    private final RepositoryPlatformCategory repositoryPlatformCategory;

    public DTOResponsePlatformCategory create(DTORequestPlatformCategory created){
        return DTOResponsePlatformCategory.toDTO(repositoryPlatformCategory.save(created.toObject()));
    }
    public DTOResponsePlatformCategory retrieve(UUID id){
        return DTOResponsePlatformCategory.toDTO(repositoryPlatformCategory.findById(id).orElse(null));
    }
    public List<DTOResponsePlatformCategory> retrieve(){
        List<DTOResponsePlatformCategory> list = new ArrayList<>();
        for(PlatformCategory object: repositoryPlatformCategory.findAll()) {
            list.add(DTOResponsePlatformCategory.toDTO(object));
        }
        return list;
    }
    public Page<DTOResponsePlatformCategory> retrieve(Pageable pageable){
        List<DTOResponsePlatformCategory> list = new ArrayList<>();
        for(PlatformCategory object: repositoryPlatformCategory.findAll()) {
            list.add(DTOResponsePlatformCategory.toDTO(object));
        }
        return new PageImpl<DTOResponsePlatformCategory>(list, pageable, list.size());
    }
    public Page<DTOResponsePlatformCategory> retrieve(Pageable pageable, String source){
        final List<DTOResponsePlatformCategory> list = new ArrayList<>();
        if (source == null) {
            for (PlatformCategory object : repositoryPlatformCategory.findAll()) {
                list.add(DTOResponsePlatformCategory.toDTO(object));
            }
        } else {
            for (PlatformCategory object : repositoryPlatformCategory.findByNameContainingIgnoreCaseOrderByNameAsc(source)) {
                list.add(DTOResponsePlatformCategory.toDTO(object));
            }
        }
        return new PageImpl<>(list, pageable, list.size());
    }
    public DTOResponsePlatformCategory update(UUID id, DTORequestPlatformCategory updated){
        PlatformCategory object = repositoryPlatformCategory.findById(id).orElse(null);
        object.setName(updated.getName());
        return DTOResponsePlatformCategory.toDTO(repositoryPlatformCategory.save(object));
    }
    public DTOResponsePlatformCategory delete(UUID id){
        PlatformCategory object = repositoryPlatformCategory.findById(id).orElse(null);
        repositoryPlatformCategory.deleteById(id);
        return DTOResponsePlatformCategory.toDTO(object);
    }
    public void delete() {
        repositoryPlatformCategory.deleteAll();
    }
    public PlatformCategory findByName(String value) { return  repositoryPlatformCategory.findByName(value); }
    public boolean existsByName(String value) {
        return repositoryPlatformCategory.existsByName(value);
    }
    public boolean existsByNameContainingIgnoreCase(String value) { return repositoryPlatformCategory.existsByNameContainingIgnoreCase(value); }
}