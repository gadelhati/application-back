package br.eti.gadelha.services;

import br.eti.gadelha.persistence.payload.request.DTORequestObserver;
import br.eti.gadelha.persistence.payload.response.DTOResponseObserver;
import br.eti.gadelha.persistence.model.synopticObservation.Observer;
import br.eti.gadelha.persistence.repository.RepositoryObserver;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service @RequiredArgsConstructor
public class ServiceObserver implements ServiceInterface<DTOResponseObserver, DTORequestObserver, Observer> {

    private final RepositoryObserver repositoryObserver;

    public DTOResponseObserver create(DTORequestObserver created){
        return DTOResponseObserver.toDTO(repositoryObserver.save(created.toObject()));
    }
    public DTOResponseObserver retrieve(UUID id){
        return DTOResponseObserver.toDTO(repositoryObserver.findById(id).orElse(null));
    }
    public List<DTOResponseObserver> retrieve(){
        List<DTOResponseObserver> list = new ArrayList<>();
        for(Observer object: repositoryObserver.findAll()) {
            list.add(DTOResponseObserver.toDTO(object));
        }
        return list;
    }
    public Page<DTOResponseObserver> retrieve(Pageable pageable){
        List<DTOResponseObserver> list = new ArrayList<>();
        for(Observer object: repositoryObserver.findAll()) {
            list.add(DTOResponseObserver.toDTO(object));
        }
        return new PageImpl<DTOResponseObserver>(list, pageable, list.size());
    }
    public Page<DTOResponseObserver> retrieve(Pageable pageable, String source){
        final List<DTOResponseObserver> list = new ArrayList<>();
        if (source == null) {
            for (Observer object : repositoryObserver.findAll()) {
                list.add(DTOResponseObserver.toDTO(object));
            }
        } else {
            for (Observer object : repositoryObserver.findByNameContainingIgnoreCaseOrderByNameAsc(source)) {
                list.add(DTOResponseObserver.toDTO(object));
            }
        }
        return new PageImpl<>(list, pageable, list.size());
    }
    public DTOResponseObserver update(UUID id, DTORequestObserver updated){
        Observer object = repositoryObserver.findById(id).orElse(null);
        object.setName(updated.getName());
        object.setNip(updated.getNip());
        return DTOResponseObserver.toDTO(repositoryObserver.save(object));
    }
    public DTOResponseObserver delete(UUID id){
        Observer object = repositoryObserver.findById(id).orElse(null);
        repositoryObserver.deleteById(id);
        return DTOResponseObserver.toDTO(object);
    }
    public void delete() {
        repositoryObserver.deleteAll();
    }
    public Observer findByName(String value) { return  repositoryObserver.findByName(value); }
    public boolean existsByName(String value) {
        return repositoryObserver.existsByNameContainingIgnoreCase(value);
    }
    public boolean existsByNip(String value) {
        return repositoryObserver.existsByNipContainingIgnoreCase(value);
    }
}