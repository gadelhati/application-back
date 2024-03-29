package br.eti.gadelha.services;

import br.eti.gadelha.persistence.MapStruct;
import br.eti.gadelha.persistence.payload.request.DTORequestEquipment;
import br.eti.gadelha.persistence.payload.response.DTOResponseEquipment;
import br.eti.gadelha.persistence.model.Equipment;
import br.eti.gadelha.persistence.repository.RepositoryEquipment;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service @RequiredArgsConstructor
public class ServiceEquipment implements ServiceInterface<DTOResponseEquipment, DTORequestEquipment, Equipment> {

    private final RepositoryEquipment repositoryEquipment;

    public DTOResponseEquipment create(DTORequestEquipment created){
        return MapStruct.MAPPER.toDTO(repositoryEquipment.save(MapStruct.MAPPER.toObject(created)));
    }
    public DTOResponseEquipment retrieve(UUID id){
        return MapStruct.MAPPER.toDTO(repositoryEquipment.findById(id).orElse(null));
    }
    public List<DTOResponseEquipment> retrieve(){
        List<DTOResponseEquipment> list = new ArrayList<>();
        for(Equipment object: repositoryEquipment.findAll()) {
            list.add(MapStruct.MAPPER.toDTO(object));
        }
        return list;
    }
    public Page<DTOResponseEquipment> retrieve(Pageable pageable){
        List<DTOResponseEquipment> list = new ArrayList<>();
        for(Equipment object: repositoryEquipment.findAll()) {
            list.add(MapStruct.MAPPER.toDTO(object));
        }
        return new PageImpl<DTOResponseEquipment>(list, pageable, list.size());
    }
    public Page<DTOResponseEquipment> retrieve(Pageable pageable, String source){
        final List<DTOResponseEquipment> list = new ArrayList<>();
        if (source == null) {
            for (Equipment object : repositoryEquipment.findAll()) {
                list.add(MapStruct.MAPPER.toDTO(object));
            }
        } else {
            for (Equipment object : repositoryEquipment.findByNameContainingIgnoreCaseOrderByNameAsc(source)) {
                list.add(MapStruct.MAPPER.toDTO(object));
            }
        }
        return new PageImpl<>(list, pageable, list.size());
    }
    public DTOResponseEquipment update(UUID id, DTORequestEquipment updated){
        return MapStruct.MAPPER.toDTO(repositoryEquipment.save(MapStruct.MAPPER.toObject(updated)));
    }
    public DTOResponseEquipment delete(UUID id){
        Equipment object = repositoryEquipment.findById(id).orElse(null);
        repositoryEquipment.deleteById(id);
        return MapStruct.MAPPER.toDTO(object);
    }
    public void delete() {
        repositoryEquipment.deleteAll();
    }
    public Equipment findByName(String value) { return  repositoryEquipment.findByName(value); }
    public boolean existsByName(String value) {
        return repositoryEquipment.existsByNameContainingIgnoreCase(value);
    }
}