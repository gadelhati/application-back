package br.eti.gadelha.services;

import br.eti.gadelha.persistence.dto.request.DTORequestResearcher;
import br.eti.gadelha.persistence.dto.response.DTOResponseResearcher;
import br.eti.gadelha.persistence.model.Researcher;
import br.eti.gadelha.persistence.repository.RepositoryResearcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class ServiceResearcher {

    private final RepositoryResearcher repository;

    public ServiceResearcher(RepositoryResearcher repository) {
        this.repository = repository;
    }

    public DTOResponseResearcher create(DTORequestResearcher created){
        return DTOResponseResearcher.toDTO(repository.save(created.toObject()));
    }
    public DTOResponseResearcher retrieve(UUID id){
        return DTOResponseResearcher.toDTO(repository.findById(id).orElse(null));
    }
    public List<DTOResponseResearcher> retrieve(){
        List<DTOResponseResearcher> list = new ArrayList<>();
        for(Researcher object: repository.findAll()) {
            list.add(DTOResponseResearcher.toDTO(object));
        }
        return list;
    }
    public Page<DTOResponseResearcher> retrieve(Pageable pageable){
        List<DTOResponseResearcher> list = new ArrayList<>();
        for(Researcher object: repository.findAll()) {
            list.add(DTOResponseResearcher.toDTO(object));
        }
        return new PageImpl<DTOResponseResearcher>(list, pageable, list.size());
    }
    public Page<DTOResponseResearcher> retrieve(Pageable pageable, String source){
        final List<DTOResponseResearcher> list = new ArrayList<>();
        if (source == null) {
            for (Researcher object : repository.findAll()) {
                list.add(DTOResponseResearcher.toDTO(object));
            }
        } else {
            for (Researcher object : repository.findByNameContainingIgnoreCaseOrderByNameAsc(source)) {
                list.add(DTOResponseResearcher.toDTO(object));
            }
        }
        return new PageImpl<>(list, pageable, list.size());
    }
    public DTOResponseResearcher update(UUID id, DTORequestResearcher updated){
        Researcher object = repository.findById(id).orElse(null);
        object.setName(updated.getName());
        object.setEmail(updated.getEmail());
        object.setAddress(updated.getAddress());
        return DTOResponseResearcher.toDTO(repository.save(object));
    }
    public DTOResponseResearcher delete(UUID id){
        Researcher object = repository.findById(id).orElse(null);
        repository.deleteById(id);
        return DTOResponseResearcher.toDTO(object);
    }
    public void delete() {
        repository.deleteAll();
    }

    public Researcher findByName(String value) { return  repository.findByName(value); }
}