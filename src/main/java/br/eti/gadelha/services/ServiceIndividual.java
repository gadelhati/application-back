package br.eti.gadelha.services;

import br.eti.gadelha.persistence.payload.request.DTORequestIndividual;
import br.eti.gadelha.persistence.payload.response.DTOResponseIndividual;
import br.eti.gadelha.persistence.model.Individual;
import br.eti.gadelha.persistence.repository.RepositoryIndividual;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service @RequiredArgsConstructor
public class ServiceIndividual implements ServiceInterface<DTOResponseIndividual, DTORequestIndividual, Individual> {

    private final RepositoryIndividual repositoryIndividual;

    public DTOResponseIndividual create(DTORequestIndividual created){
        return DTOResponseIndividual.toDTO(repositoryIndividual.save(created.toObject()));
    }
    public List<DTOResponseIndividual> retrieve(){
        List<DTOResponseIndividual> list = new ArrayList<>();
        for(Individual om: repositoryIndividual.findAll()) {
            list.add(DTOResponseIndividual.toDTO(om));
        }
        return list;
    }
    public Page<DTOResponseIndividual> retrieve(Pageable pageable){
        List<DTOResponseIndividual> list = new ArrayList<>();
        for(Individual role: repositoryIndividual.findAll()) {
            list.add(DTOResponseIndividual.toDTO(role));
        }
        return new PageImpl<DTOResponseIndividual>(list, pageable, list.size());
    }
    public Page<DTOResponseIndividual> retrieve(Pageable pageable, String source) {
        List<DTOResponseIndividual> list = new ArrayList<>();
        for(Individual object: repositoryIndividual.findAll()) {
            list.add(DTOResponseIndividual.toDTO(object));
        }
        return new PageImpl<DTOResponseIndividual>(list, pageable, list.size());
    }
    public DTOResponseIndividual retrieve(UUID id){
        return DTOResponseIndividual.toDTO(repositoryIndividual.findById(id).orElse(null));
    }
    public Page<DTOResponseIndividual> retrieveSource(Pageable pageable, String source){
        final List<DTOResponseIndividual> list = new ArrayList<>();
        if (source == null) {
            for (Individual role : repositoryIndividual.findAll()) {
                list.add(DTOResponseIndividual.toDTO(role));
            }
        } else {
            for (Individual role : repositoryIndividual.findByNameContainingIgnoreCaseOrderByNameAsc(source)) {
                list.add(DTOResponseIndividual.toDTO(role));
            }
        }
        return new PageImpl<>(list, pageable, list.size());
    }
    public DTOResponseIndividual update(UUID id, DTORequestIndividual updated){
        Individual object = repositoryIndividual.findById(id).orElse(null);
        object.setName(updated.getName());
        object.setBirthdate(updated.getBirthdate());
        object.setGender(updated.getGender());
        object.setCpf(updated.getCpf());
        return DTOResponseIndividual.toDTO(repositoryIndividual.save(object));
    }
    public DTOResponseIndividual delete(UUID id){
        Individual object = repositoryIndividual.findById(id).orElse(null);
        repositoryIndividual.deleteById(id);
        return DTOResponseIndividual.toDTO(object);
    }
    public void delete() {
        repositoryIndividual.deleteAll();
    }
    public Individual findByName(String value) { return  repositoryIndividual.findByName(value); }
    public boolean existsByName(String value) {
        return repositoryIndividual.existsByNameContainingIgnoreCase(value);
    }
}