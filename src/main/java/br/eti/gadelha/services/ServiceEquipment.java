package br.eti.gadelha.services;

import br.eti.gadelha.persistence.dto.request.DTORequestEquipment;
import br.eti.gadelha.persistence.dto.response.DTOResponseEquipment;
import br.eti.gadelha.persistence.model.unity.Equipment;
import br.eti.gadelha.persistence.repository.RepositoryEquipment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class ServiceEquipment {

    private final RepositoryEquipment repository;

    public ServiceEquipment(RepositoryEquipment repository) {
        this.repository = repository;
    }

    public DTOResponseEquipment create(DTORequestEquipment created){
        return DTOResponseEquipment.toDTO(repository.save(created.toObject()));
    }
    public DTOResponseEquipment retrieve(UUID id){
        return DTOResponseEquipment.toDTO(repository.findById(id).orElse(null));
    }
    public List<DTOResponseEquipment> retrieve(){
        List<DTOResponseEquipment> list = new ArrayList<>();
        for(Equipment object: repository.findAll()) {
            list.add(DTOResponseEquipment.toDTO(object));
        }
        return list;
    }
    public Page<DTOResponseEquipment> retrieve(Pageable pageable){
        List<DTOResponseEquipment> list = new ArrayList<>();
        for(Equipment object: repository.findAll()) {
            list.add(DTOResponseEquipment.toDTO(object));
        }
        return new PageImpl<DTOResponseEquipment>(list, pageable, list.size());
    }
    public Page<DTOResponseEquipment> retrieve(Pageable pageable, String source){
        final List<DTOResponseEquipment> list = new ArrayList<>();
        if (source == null) {
            for (Equipment object : repository.findAll()) {
                list.add(DTOResponseEquipment.toDTO(object));
            }
        } else {
            for (Equipment object : repository.findByNameContainingIgnoreCaseOrderByNameAsc(source)) {
                list.add(DTOResponseEquipment.toDTO(object));
            }
        }
        return new PageImpl<>(list, pageable, list.size());
    }
    public DTOResponseEquipment update(UUID id, DTORequestEquipment updated){
        Equipment object = repository.findById(id).orElse(null);
        object.setName(updated.getName());
        object.setManufacturer(updated.getManufacturer());
        return DTOResponseEquipment.toDTO(repository.save(object));
    }
    public DTOResponseEquipment delete(UUID id){
        Equipment object = repository.findById(id).orElse(null);
        repository.deleteById(id);
        return DTOResponseEquipment.toDTO(object);
    }
    public void delete() {
        repository.deleteAll();
    }

    public Equipment findByName(String value) { return  repository.findByName(value); }
}