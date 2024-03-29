package br.eti.gadelha.services;

import br.eti.gadelha.persistence.MapStruct;
import br.eti.gadelha.persistence.payload.request.DTORequestResearcher;
import br.eti.gadelha.persistence.payload.response.DTOResponseResearcher;
import br.eti.gadelha.persistence.model.Researcher;
import br.eti.gadelha.persistence.repository.RepositoryResearcher;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service @RequiredArgsConstructor
public class ServiceResearcher implements ServiceInterface<DTOResponseResearcher, DTORequestResearcher, Researcher> {

    private final RepositoryResearcher repositoryResearcher;

    public DTOResponseResearcher create(DTORequestResearcher created){
        return MapStruct.MAPPER.toDTO(repositoryResearcher.save(MapStruct.MAPPER.toObject(created)));
    }
    public DTOResponseResearcher retrieve(UUID id){
        return MapStruct.MAPPER.toDTO(repositoryResearcher.findById(id).orElse(null));
    }
    public List<DTOResponseResearcher> retrieve(){
        List<DTOResponseResearcher> list = new ArrayList<>();
        for(Researcher object: repositoryResearcher.findAll()) {
            list.add(MapStruct.MAPPER.toDTO(object));
        }
        return list;
    }
    public Page<DTOResponseResearcher> retrieve(Pageable pageable){
        List<DTOResponseResearcher> list = new ArrayList<>();
        for(Researcher object: repositoryResearcher.findAll()) {
            list.add(MapStruct.MAPPER.toDTO(object));
        }
        return new PageImpl<DTOResponseResearcher>(list, pageable, list.size());
    }
    public Page<DTOResponseResearcher> retrieve(Pageable pageable, String source){
        final List<DTOResponseResearcher> list = new ArrayList<>();
        if (source == null) {
            for (Researcher object : repositoryResearcher.findAll()) {
                list.add(MapStruct.MAPPER.toDTO(object));
            }
        } else {
            for (Researcher object : repositoryResearcher.findByNameContainingIgnoreCaseOrderByNameAsc(source)) {
                list.add(MapStruct.MAPPER.toDTO(object));
            }
        }
        return new PageImpl<>(list, pageable, list.size());
    }
    public DTOResponseResearcher update(UUID id, DTORequestResearcher updated){
        return MapStruct.MAPPER.toDTO(repositoryResearcher.save(MapStruct.MAPPER.toObject(updated)));
    }
    public DTOResponseResearcher delete(UUID id){
        Researcher object = repositoryResearcher.findById(id).orElse(null);
        repositoryResearcher.deleteById(id);
        return MapStruct.MAPPER.toDTO(object);
    }
    public void delete() {
        repositoryResearcher.deleteAll();
    }
    public Researcher findByName(String value) { return  repositoryResearcher.findByName(value); }
    public boolean existsByName(String value) {
        return repositoryResearcher.existsByNameContainingIgnoreCase(value);
    }
    public boolean existsByEmail(String value) {
        return repositoryResearcher.existsByEmail(value);
    }
}