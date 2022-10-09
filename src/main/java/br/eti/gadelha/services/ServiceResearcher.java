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
public class ServiceResearcher implements ServiceInterface<DTOResponseResearcher, DTORequestResearcher, Researcher> {

    private final RepositoryResearcher repositoryResearcher;

    public ServiceResearcher(RepositoryResearcher repositoryResearcher) {
        this.repositoryResearcher = repositoryResearcher;
    }

    public DTOResponseResearcher create(DTORequestResearcher created){
        return DTOResponseResearcher.toDTO(repositoryResearcher.save(created.toObject()));
    }
    public DTOResponseResearcher retrieve(UUID id){
        return DTOResponseResearcher.toDTO(repositoryResearcher.findById(id).orElse(null));
    }
    public List<DTOResponseResearcher> retrieve(){
        List<DTOResponseResearcher> list = new ArrayList<>();
        for(Researcher object: repositoryResearcher.findAll()) {
            list.add(DTOResponseResearcher.toDTO(object));
        }
        return list;
    }
    public Page<DTOResponseResearcher> retrieve(Pageable pageable){
        List<DTOResponseResearcher> list = new ArrayList<>();
        for(Researcher object: repositoryResearcher.findAll()) {
            list.add(DTOResponseResearcher.toDTO(object));
        }
        return new PageImpl<DTOResponseResearcher>(list, pageable, list.size());
    }
    public Page<DTOResponseResearcher> retrieve(Pageable pageable, String source){
        final List<DTOResponseResearcher> list = new ArrayList<>();
        if (source == null) {
            for (Researcher object : repositoryResearcher.findAll()) {
                list.add(DTOResponseResearcher.toDTO(object));
            }
        } else {
            for (Researcher object : repositoryResearcher.findByNameContainingIgnoreCaseOrderByNameAsc(source)) {
                list.add(DTOResponseResearcher.toDTO(object));
            }
        }
        return new PageImpl<>(list, pageable, list.size());
    }
    public DTOResponseResearcher update(UUID id, DTORequestResearcher updated){
        Researcher object = repositoryResearcher.findById(id).orElse(null);
        object.setName(updated.getName());
        object.setEmail(updated.getEmail());
        object.setAddress(updated.getAddress());
        return DTOResponseResearcher.toDTO(repositoryResearcher.save(object));
    }
    public DTOResponseResearcher delete(UUID id){
        Researcher object = repositoryResearcher.findById(id).orElse(null);
        repositoryResearcher.deleteById(id);
        return DTOResponseResearcher.toDTO(object);
    }
    public void delete() {
        repositoryResearcher.deleteAll();
    }

    public Researcher findByName(String value) { return  repositoryResearcher.findByName(value); }
}