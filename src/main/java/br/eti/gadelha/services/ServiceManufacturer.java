package br.eti.gadelha.services;

import br.eti.gadelha.persistence.MapStruct;
import br.eti.gadelha.persistence.payload.request.DTORequestManufacturer;
import br.eti.gadelha.persistence.payload.response.DTOResponseManufacturer;
import br.eti.gadelha.persistence.model.Manufacturer;
import br.eti.gadelha.persistence.repository.RepositoryManufacturer;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service @RequiredArgsConstructor
public class ServiceManufacturer implements ServiceInterface<DTOResponseManufacturer, DTORequestManufacturer, Manufacturer> {

    private final RepositoryManufacturer repositoryManufacturer;

    public DTOResponseManufacturer create(DTORequestManufacturer created){
        return MapStruct.MAPPER.toDTO(repositoryManufacturer.save(MapStruct.MAPPER.toObject(created)));
    }
    public DTOResponseManufacturer retrieve(UUID id){
        return MapStruct.MAPPER.toDTO(repositoryManufacturer.findById(id).orElse(null));
    }
    public List<DTOResponseManufacturer> retrieve(){
        List<DTOResponseManufacturer> list = new ArrayList<>();
        for(Manufacturer object: repositoryManufacturer.findAll()) {
            list.add(MapStruct.MAPPER.toDTO(object));
        }
        return list;
    }
    public Page<DTOResponseManufacturer> retrieve(Pageable pageable){
        List<DTOResponseManufacturer> list = new ArrayList<>();
        for(Manufacturer object: repositoryManufacturer.findAll()) {
            list.add(MapStruct.MAPPER.toDTO(object));
        }
        return new PageImpl<DTOResponseManufacturer>(list, pageable, list.size());
    }
    public Page<DTOResponseManufacturer> retrieve(Pageable pageable, String source){
        final List<DTOResponseManufacturer> list = new ArrayList<>();
        if (source == null) {
            for (Manufacturer object : repositoryManufacturer.findAll()) {
                list.add(MapStruct.MAPPER.toDTO(object));
            }
        } else {
            for (Manufacturer object : repositoryManufacturer.findByNameContainingIgnoreCaseOrderByNameAsc(source)) {
                list.add(MapStruct.MAPPER.toDTO(object));
            }
        }
        return new PageImpl<>(list, pageable, list.size());
    }
    public DTOResponseManufacturer update(UUID id, DTORequestManufacturer updated){
        return MapStruct.MAPPER.toDTO(repositoryManufacturer.save(MapStruct.MAPPER.toObject(updated)));
    }
    public DTOResponseManufacturer delete(UUID id){
        Manufacturer object = repositoryManufacturer.findById(id).orElse(null);
        repositoryManufacturer.deleteById(id);
        return MapStruct.MAPPER.toDTO(object);
    }
    public void delete() {
        repositoryManufacturer.deleteAll();
    }
    public Manufacturer findByName(String value) { return  repositoryManufacturer.findByName(value); }
    public boolean existsByName(String value) {
        return repositoryManufacturer.existsByNameContainingIgnoreCase(value);
    }
}