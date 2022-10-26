package br.eti.gadelha.services;

import br.eti.gadelha.persistence.payload.request.DTORequestFederativeUnit;
import br.eti.gadelha.persistence.payload.response.DTOResponseFederativeUnit;
import br.eti.gadelha.persistence.model.FederativeUnit;
import br.eti.gadelha.persistence.repository.RepositoryFederativeUnit;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service @RequiredArgsConstructor
public class ServiceFederativeUnit implements ServiceInterface<DTOResponseFederativeUnit, DTORequestFederativeUnit, FederativeUnit> {

    private final RepositoryFederativeUnit repositoryFederativeUnit;

    public DTOResponseFederativeUnit create(DTORequestFederativeUnit created){
        return DTOResponseFederativeUnit.toDTO(repositoryFederativeUnit.save(created.toObject()));
    }
    public List<DTOResponseFederativeUnit> retrieve(){
        List<DTOResponseFederativeUnit> list = new ArrayList<>();
        for(FederativeUnit om: repositoryFederativeUnit.findAll()) {
            list.add(DTOResponseFederativeUnit.toDTO(om));
        }
        return list;
    }
    public Page<DTOResponseFederativeUnit> retrieve(Pageable pageable){
        List<DTOResponseFederativeUnit> list = new ArrayList<>();
        for(FederativeUnit role: repositoryFederativeUnit.findAll()) {
            list.add(DTOResponseFederativeUnit.toDTO(role));
        }
        return new PageImpl<DTOResponseFederativeUnit>(list, pageable, list.size());
    }
    public Page<DTOResponseFederativeUnit> retrieve(Pageable pageable, String source) {
        List<DTOResponseFederativeUnit> list = new ArrayList<>();
        for(FederativeUnit object: repositoryFederativeUnit.findAll()) {
            list.add(DTOResponseFederativeUnit.toDTO(object));
        }
        return new PageImpl<DTOResponseFederativeUnit>(list, pageable, list.size());
    }
    public DTOResponseFederativeUnit retrieve(UUID id){
        return DTOResponseFederativeUnit.toDTO(repositoryFederativeUnit.findById(id).orElse(null));
    }
    public Page<DTOResponseFederativeUnit> retrieveSource(Pageable pageable, String source){
        final List<DTOResponseFederativeUnit> list = new ArrayList<>();
        if (source == null) {
            for (FederativeUnit role : repositoryFederativeUnit.findAll()) {
                list.add(DTOResponseFederativeUnit.toDTO(role));
            }
        } else {
            for (FederativeUnit role : repositoryFederativeUnit.findByNameContainingIgnoreCaseOrderByNameAsc(source)) {
                list.add(DTOResponseFederativeUnit.toDTO(role));
            }
        }
        return new PageImpl<>(list, pageable, list.size());
    }
    public DTOResponseFederativeUnit update(UUID id, DTORequestFederativeUnit updated){
        FederativeUnit object = repositoryFederativeUnit.findById(id).orElse(null);
        object.setName(updated.getName());
        return DTOResponseFederativeUnit.toDTO(repositoryFederativeUnit.save(object));
    }
    public DTOResponseFederativeUnit delete(UUID id){
        FederativeUnit object = repositoryFederativeUnit.findById(id).orElse(null);
        repositoryFederativeUnit.deleteById(id);
        return DTOResponseFederativeUnit.toDTO(object);
    }
    public void delete() {
        repositoryFederativeUnit.deleteAll();
    }
    public FederativeUnit findByName(String value) { return  repositoryFederativeUnit.findByName(value); }
    public boolean existsByName(String value) {
        return repositoryFederativeUnit.existsByName(value);
    }
    public boolean existsByInitials(String value) {
        return repositoryFederativeUnit.existsByInitialsIgnoreCase(value);
    }
}