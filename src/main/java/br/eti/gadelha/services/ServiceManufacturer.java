package br.eti.gadelha.services;

import br.eti.gadelha.persistence.dto.request.DTORequestManufacturer;
import br.eti.gadelha.persistence.dto.response.DTOResponseManufacturer;
import br.eti.gadelha.persistence.model.unity.Manufacturer;
import br.eti.gadelha.persistence.repository.RepositoryManufacturer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class ServiceManufacturer {

    private final RepositoryManufacturer repository;

    public ServiceManufacturer(RepositoryManufacturer repository) {
        this.repository = repository;
    }

    public DTOResponseManufacturer create(DTORequestManufacturer created){
        return DTOResponseManufacturer.toDTO(repository.save(created.toObject()));
    }
    public DTOResponseManufacturer retrieve(UUID id){
        return DTOResponseManufacturer.toDTO(repository.findById(id).orElse(null));
    }
    public List<DTOResponseManufacturer> retrieve(){
        List<DTOResponseManufacturer> list = new ArrayList<>();
        for(Manufacturer object: repository.findAll()) {
            list.add(DTOResponseManufacturer.toDTO(object));
        }
        return list;
    }
    public Page<DTOResponseManufacturer> retrieve(Pageable pageable){
        List<DTOResponseManufacturer> list = new ArrayList<>();
        for(Manufacturer object: repository.findAll()) {
            list.add(DTOResponseManufacturer.toDTO(object));
        }
        return new PageImpl<DTOResponseManufacturer>(list, pageable, list.size());
    }
    public Page<DTOResponseManufacturer> retrieve(Pageable pageable, String source){
        final List<DTOResponseManufacturer> list = new ArrayList<>();
        if (source == null) {
            for (Manufacturer object : repository.findAll()) {
                list.add(DTOResponseManufacturer.toDTO(object));
            }
        } else {
            for (Manufacturer object : repository.findByNameContainingIgnoreCaseOrderByNameAsc(source)) {
                list.add(DTOResponseManufacturer.toDTO(object));
            }
        }
        return new PageImpl<>(list, pageable, list.size());
    }
    public DTOResponseManufacturer update(UUID id, DTORequestManufacturer updated){
        Manufacturer object = repository.findById(id).orElse(null);
        object.setName(updated.getName());
        return DTOResponseManufacturer.toDTO(repository.save(object));
    }
    public DTOResponseManufacturer delete(UUID id){
        Manufacturer object = repository.findById(id).orElse(null);
        repository.deleteById(id);
        return DTOResponseManufacturer.toDTO(object);
    }
    public void delete() {
        repository.deleteAll();
    }

    public Manufacturer findByName(String value) { return  repository.findByName(value); }
}