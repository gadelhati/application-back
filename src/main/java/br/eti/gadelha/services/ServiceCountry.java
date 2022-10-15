package br.eti.gadelha.services;

import br.eti.gadelha.persistence.payload.request.DTORequestCountry;
import br.eti.gadelha.persistence.payload.response.DTOResponseCountry;
import br.eti.gadelha.persistence.model.Country;
import br.eti.gadelha.persistence.repository.RepositoryCountry;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service @RequiredArgsConstructor
public class ServiceCountry implements ServiceInterface<DTOResponseCountry, DTORequestCountry, Country> {

    private final RepositoryCountry repositoryCountry;

    public DTOResponseCountry create(DTORequestCountry created){
        return DTOResponseCountry.toDTO(repositoryCountry.save(created.toObject()));
    }
    public DTOResponseCountry retrieve(UUID id){
        return DTOResponseCountry.toDTO(repositoryCountry.findById(id).orElse(null));
    }
    public List<DTOResponseCountry> retrieve(){
        List<DTOResponseCountry> list = new ArrayList<>();
        for(Country object: repositoryCountry.findAll()) {
            list.add(DTOResponseCountry.toDTO(object));
        }
        return list;
    }
    public Page<DTOResponseCountry> retrieve(Pageable pageable){
        List<DTOResponseCountry> list = new ArrayList<>();
        for(Country object: repositoryCountry.findAll()) {
            list.add(DTOResponseCountry.toDTO(object));
        }
        return new PageImpl<DTOResponseCountry>(list, pageable, list.size());
    }
    public Page<DTOResponseCountry> retrieve(Pageable pageable, String source){
        final List<DTOResponseCountry> list = new ArrayList<>();
        if (source == null) {
            for (Country object : repositoryCountry.findAll()) {
                list.add(DTOResponseCountry.toDTO(object));
            }
        } else {
            for (Country object : repositoryCountry.findByNameContainingIgnoreCaseOrderByNameAsc(source)) {
                list.add(DTOResponseCountry.toDTO(object));
            }
        }
        return new PageImpl<>(list, pageable, list.size());
    }
    public DTOResponseCountry update(UUID id, DTORequestCountry updated){
        Country object = repositoryCountry.findById(id).orElse(null);
        object.setName(updated.getName());
        return DTOResponseCountry.toDTO(repositoryCountry.save(object));
    }
    public DTOResponseCountry delete(UUID id){
        Country object = repositoryCountry.findById(id).orElse(null);
        repositoryCountry.deleteById(id);
        return DTOResponseCountry.toDTO(object);
    }
    public void delete() {
        repositoryCountry.deleteAll();
    }
    public Country findByName(String value) { return  repositoryCountry.findByName(value); }
    public boolean existsByName(String value) {
        return repositoryCountry.existsByName(value);
    }
}