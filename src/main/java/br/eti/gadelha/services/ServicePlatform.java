package br.eti.gadelha.services;

import br.eti.gadelha.persistence.MapStruct;
import br.eti.gadelha.persistence.payload.request.DTORequestPlatform;
import br.eti.gadelha.persistence.payload.response.DTOResponsePlatform;
import br.eti.gadelha.persistence.model.synopticObservation.Platform;
import br.eti.gadelha.persistence.repository.RepositoryPlatform;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service @RequiredArgsConstructor
public class ServicePlatform implements ServiceInterface<DTOResponsePlatform, DTORequestPlatform, Platform> {

    private final RepositoryPlatform repositoryPlatform;

    public DTOResponsePlatform create(DTORequestPlatform created){
        return MapStruct.MAPPER.toDTO(repositoryPlatform.save(MapStruct.MAPPER.toObject(created)));
    }
    public DTOResponsePlatform retrieve(UUID id){
        return MapStruct.MAPPER.toDTO(repositoryPlatform.findById(id).orElse(null));
    }
    public List<DTOResponsePlatform> retrieve(){
        List<DTOResponsePlatform> list = new ArrayList<>();
        for(Platform object: repositoryPlatform.findAll()) {
            list.add(MapStruct.MAPPER.toDTO(object));
        }
        return list;
    }
    public Page<DTOResponsePlatform> retrieve(Pageable pageable){
        List<DTOResponsePlatform> list = new ArrayList<>();
        for(Platform object: repositoryPlatform.findAll()) {
            list.add(MapStruct.MAPPER.toDTO(object));
        }
        return new PageImpl<DTOResponsePlatform>(list, pageable, list.size());
    }
    public Page<DTOResponsePlatform> retrieve(Pageable pageable, String source){
        final List<DTOResponsePlatform> list = new ArrayList<>();
        if (source == null) {
            for (Platform object : repositoryPlatform.findAll()) {
                list.add(MapStruct.MAPPER.toDTO(object));
            }
        } else {
            for (Platform object : repositoryPlatform.findByNameContainingIgnoreCaseOrderByNameAsc(source)) {
                list.add(MapStruct.MAPPER.toDTO(object));
            }
        }
        return new PageImpl<>(list, pageable, list.size());
    }
    public DTOResponsePlatform update(UUID id, DTORequestPlatform updated){
        return MapStruct.MAPPER.toDTO(repositoryPlatform.save(MapStruct.MAPPER.toObject(updated)));
    }
    public DTOResponsePlatform delete(UUID id){
        Platform object = repositoryPlatform.findById(id).orElse(null);
        repositoryPlatform.deleteById(id);
        return MapStruct.MAPPER.toDTO(object);
    }
    public void delete() {
        repositoryPlatform.deleteAll();
    }
    public Platform findByName(String value) { return  repositoryPlatform.findByName(value); }
    public boolean existsByName(String value) {
        return repositoryPlatform.existsByNameContainingIgnoreCase(value);
    }
    public boolean existsByTelegraphicCallsign(String value) {
        return repositoryPlatform.existsByTelegraphicCallsign(value);
    }
    public boolean existsByInternationalCallsign(String value) {
        return repositoryPlatform.existsByInternationalCallsign(value);
    }
    public boolean existsByInternationalName(String value) {
        return repositoryPlatform.existsByInternationalName(value);
    }
}