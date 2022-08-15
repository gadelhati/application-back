package br.eti.gadelha.services;

import br.eti.gadelha.persistence.dto.request.DTORequestCountry;
import br.eti.gadelha.persistence.dto.response.DTOResponseCountry;
import br.eti.gadelha.persistence.model.Country;
import br.eti.gadelha.persistence.repository.RepositoryCountry;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class ServiceCountry {

    private final RepositoryCountry repository;

    public ServiceCountry(RepositoryCountry repository) {
        this.repository = repository;
    }

    public DTOResponseCountry create(DTORequestCountry created){
        return DTOResponseCountry.toDTO(repository.save(created.toObject()));
    }
    public DTOResponseCountry retrieve(UUID id){
        return DTOResponseCountry.toDTO(repository.findById(id).orElse(null));
    }
    public List<DTOResponseCountry> retrieve(){
        List<DTOResponseCountry> list = new ArrayList<>();
        for(Country object: repository.findAll()) {
            list.add(DTOResponseCountry.toDTO(object));
        }
        return list;
    }
    public Page<DTOResponseCountry> retrieve(Pageable pageable){
        List<DTOResponseCountry> list = new ArrayList<>();
        for(Country object: repository.findAll()) {
            list.add(DTOResponseCountry.toDTO(object));
        }
        return new PageImpl<DTOResponseCountry>(list, pageable, list.size());
    }
    public Page<DTOResponseCountry> retrieve(Pageable pageable, String source){
        final List<DTOResponseCountry> list = new ArrayList<>();
        if (source == null) {
            for (Country object : repository.findAll()) {
                list.add(DTOResponseCountry.toDTO(object));
            }
        } else {
            for (Country object : repository.findByNameContainingIgnoreCaseOrderByNameAsc(source)) {
                list.add(DTOResponseCountry.toDTO(object));
            }
        }
        return new PageImpl<>(list, pageable, list.size());
    }
    public DTOResponseCountry update(UUID id, DTORequestCountry updated){
        Country object = repository.findById(id).orElse(null);
        object.setName(updated.getName());
        return DTOResponseCountry.toDTO(repository.save(object));
    }
    public DTOResponseCountry delete(UUID id){
        Country object = repository.findById(id).orElse(null);
        repository.deleteById(id);
        return DTOResponseCountry.toDTO(object);
    }
    public void delete() {
        repository.deleteAll();
    }

    public Country findByName(String value) { return  repository.findByName(value); }
}