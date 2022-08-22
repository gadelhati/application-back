package br.eti.gadelha.services;

import br.eti.gadelha.persistence.dto.request.DTORequestStationOnShore;
import br.eti.gadelha.persistence.dto.response.DTOResponseStationOnShore;
import br.eti.gadelha.persistence.model.unity.StationOnShore;
import br.eti.gadelha.persistence.repository.RepositoryStationOnShore;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class ServiceStationOnShore {

    private final RepositoryStationOnShore repository;

    public ServiceStationOnShore(RepositoryStationOnShore repository) {
        this.repository = repository;
    }

    public DTOResponseStationOnShore create(DTORequestStationOnShore created){
        return DTOResponseStationOnShore.toDTO(repository.save(created.toObject()));
    }
    public DTOResponseStationOnShore retrieve(UUID id){
        return DTOResponseStationOnShore.toDTO(repository.findById(id).orElse(null));
    }
    public List<DTOResponseStationOnShore> retrieve(){
        List<DTOResponseStationOnShore> list = new ArrayList<>();
        for(StationOnShore object: repository.findAll()) {
            list.add(DTOResponseStationOnShore.toDTO(object));
        }
        return list;
    }
    public Page<DTOResponseStationOnShore> retrieve(Pageable pageable){
        List<DTOResponseStationOnShore> list = new ArrayList<>();
        for(StationOnShore object: repository.findAll()) {
            list.add(DTOResponseStationOnShore.toDTO(object));
        }
        return new PageImpl<DTOResponseStationOnShore>(list, pageable, list.size());
    }
    public Page<DTOResponseStationOnShore> retrieve(Pageable pageable, String source){
        final List<DTOResponseStationOnShore> list = new ArrayList<>();
        if (source == null) {
            for (StationOnShore object : repository.findAll()) {
                list.add(DTOResponseStationOnShore.toDTO(object));
            }
        } else {
            for (StationOnShore object : repository.findByNameContainingIgnoreCaseOrderByNameAsc(source)) {
                list.add(DTOResponseStationOnShore.toDTO(object));
            }
        }
        return new PageImpl<>(list, pageable, list.size());
    }
    public DTOResponseStationOnShore update(UUID id, DTORequestStationOnShore updated){
        StationOnShore object = repository.findById(id).orElse(null);
        object.setLocalDepth(updated.getLocalDepth());
        object.setCom(updated.getCom());
        object.setCommission(updated.getCommission());
        object.setStationCategory(updated.getStationCategory());
        object.setCountry(updated.getCountry());
        object.setEquipment(updated.getEquipment());
        object.setSurveying(updated.getSurveying());
        object.setResponsible(updated.getResponsible());
        object.setCountry(updated.getCountry());
        object.setName(updated.getName());
        object.setDateTime(updated.getDateTime());
        object.setLatitude(updated.getLatitude());
        object.setLongitude(updated.getLongitude());
        object.setMarsdenSquare_10(updated.getMarsdenSquare_10());
        object.setMarsdenSubSquare_1(updated.getMarsdenSubSquare_1());
        object.setWmoSquare(updated.getWmoSquare());
        object.setMarsdenSubSquare_5(updated.getMarsdenSubSquare_5());
        object.setCollectionDepth(updated.getCollectionDepth());
        return DTOResponseStationOnShore.toDTO(repository.save(object));
    }
    public DTOResponseStationOnShore delete(UUID id){
        StationOnShore object = repository.findById(id).orElse(null);
        repository.deleteById(id);
        return DTOResponseStationOnShore.toDTO(object);
    }
    public void delete() {
        repository.deleteAll();
    }

    public StationOnShore findByName(String value) { return  repository.findByName(value); }
}