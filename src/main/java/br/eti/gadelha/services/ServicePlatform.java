package br.eti.gadelha.services;

import br.eti.gadelha.persistence.dto.request.DTORequestPlatform;
import br.eti.gadelha.persistence.dto.response.DTOResponsePlatform;
import br.eti.gadelha.persistence.model.unity.Platform;
import br.eti.gadelha.persistence.repository.RepositoryPlatform;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class ServicePlatform implements ServiceInterface<DTOResponsePlatform, DTORequestPlatform, Platform> {

    private final RepositoryPlatform repositoryPlatform;

    public ServicePlatform(RepositoryPlatform repositoryPlatform) {
        this.repositoryPlatform = repositoryPlatform;
    }

    public DTOResponsePlatform create(DTORequestPlatform created){
        return DTOResponsePlatform.toDTO(repositoryPlatform.save(created.toObject()));
    }
    public DTOResponsePlatform retrieve(UUID id){
        return DTOResponsePlatform.toDTO(repositoryPlatform.findById(id).orElse(null));
    }
    public List<DTOResponsePlatform> retrieve(){
        List<DTOResponsePlatform> list = new ArrayList<>();
        for(Platform object: repositoryPlatform.findAll()) {
            list.add(DTOResponsePlatform.toDTO(object));
        }
        return list;
    }
    public Page<DTOResponsePlatform> retrieve(Pageable pageable){
        List<DTOResponsePlatform> list = new ArrayList<>();
        for(Platform object: repositoryPlatform.findAll()) {
            list.add(DTOResponsePlatform.toDTO(object));
        }
        return new PageImpl<DTOResponsePlatform>(list, pageable, list.size());
    }
    public Page<DTOResponsePlatform> retrieve(Pageable pageable, String source){
        final List<DTOResponsePlatform> list = new ArrayList<>();
        if (source == null) {
            for (Platform object : repositoryPlatform.findAll()) {
                list.add(DTOResponsePlatform.toDTO(object));
            }
        } else {
            for (Platform object : repositoryPlatform.findByNameContainingIgnoreCaseOrderByNameAsc(source)) {
                list.add(DTOResponsePlatform.toDTO(object));
            }
        }
        return new PageImpl<>(list, pageable, list.size());
    }
    public DTOResponsePlatform update(UUID id, DTORequestPlatform updated){
        Platform object = repositoryPlatform.findById(id).orElse(null);
        object.setVisualCallsign(updated.getVisualCallsign());
        object.setTelegraphicCallsign(updated.getTelegraphicCallsign());
        object.setInternationalCallsign(updated.getInternationalCallsign());
        object.setName(updated.getName());
        object.setInternationalName(updated.getInternationalName());
        object.setCountry(updated.getCountry());
        object.setPlatformCategory(updated.getPlatformCategory());
        return DTOResponsePlatform.toDTO(repositoryPlatform.save(object));
    }
    public DTOResponsePlatform delete(UUID id){
        Platform object = repositoryPlatform.findById(id).orElse(null);
        repositoryPlatform.deleteById(id);
        return DTOResponsePlatform.toDTO(object);
    }
    public void delete() {
        repositoryPlatform.deleteAll();
    }
    public Platform findByName(String value) { return  repositoryPlatform.findByName(value); }
}