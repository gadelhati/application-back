package br.eti.gadelha.services;

import br.eti.gadelha.persistence.dto.request.DTORequestStation;
import br.eti.gadelha.persistence.dto.response.DTOResponseStation;
import br.eti.gadelha.persistence.model.unity.Station;
import br.eti.gadelha.persistence.repository.RepositoryStation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class ServiceStation {

    private final RepositoryStation repository;

    public ServiceStation(RepositoryStation repository) {
        this.repository = repository;
    }

    public DTOResponseStation create(DTORequestStation created){
        return DTOResponseStation.toDTO(repository.save(created.toObject()));
    }
    public DTOResponseStation retrieve(UUID id){
        return DTOResponseStation.toDTO(repository.findById(id).orElse(null));
    }
    public List<DTOResponseStation> retrieve(){
        List<DTOResponseStation> list = new ArrayList<>();
        for(Station object: repository.findAll()) {
            list.add(DTOResponseStation.toDTO(object));
        }
        return list;
    }
    public Page<DTOResponseStation> retrieve(Pageable pageable){
        List<DTOResponseStation> list = new ArrayList<>();
        for(Station object: repository.findAll()) {
            list.add(DTOResponseStation.toDTO(object));
        }
        return new PageImpl<DTOResponseStation>(list, pageable, list.size());
    }
    public Page<DTOResponseStation> retrieve(Pageable pageable, String source){
        final List<DTOResponseStation> list = new ArrayList<>();
        if (source == null) {
            for (Station object : repository.findAll()) {
                list.add(DTOResponseStation.toDTO(object));
            }
        } else {
            for (Station object : repository.findByComContainingIgnoreCaseOrderByComAsc(source)) {
                list.add(DTOResponseStation.toDTO(object));
            }
        }
        return new PageImpl<>(list, pageable, list.size());
    }
    public DTOResponseStation update(UUID id, DTORequestStation updated){
        Station object = repository.findById(id).orElse(null);
        object.setLocalDepth(updated.getLocalDepth());
        object.setCom(updated.getCom());
        object.setCommission(updated.getCommission());
        object.setStationCategory(updated.getStationCategory());
        object.setCountry(updated.getCountry());
        object.setEquipment(updated.getEquipment());
        object.setSurveying(updated.getSurveying());
        object.setResponsible(updated.getResponsible());
        object.setCountry(updated.getCountry());
        return DTOResponseStation.toDTO(repository.save(object));
    }
    public DTOResponseStation delete(UUID id){
        Station object = repository.findById(id).orElse(null);
        repository.deleteById(id);
        return DTOResponseStation.toDTO(object);
    }
    public void delete() {
        repository.deleteAll();
    }

    public Station findByName(String value) { return  repository.findByCom(value); }
}