package br.eti.gadelha.services;

import br.eti.gadelha.persistence.model.synopticObservation.StationShip;
import br.eti.gadelha.persistence.payload.request.DTORequestStationShip;
import br.eti.gadelha.persistence.payload.response.DTOResponseStationShip;
import br.eti.gadelha.persistence.repository.RepositoryStationShip;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service @RequiredArgsConstructor
public class ServiceStationShip implements ServiceInterface<DTOResponseStationShip, DTORequestStationShip, StationShip> {

    private final RepositoryStationShip repositoryStationShip;

    public DTOResponseStationShip create(DTORequestStationShip created){
        return DTOResponseStationShip.toDTO(repositoryStationShip.save(created.toObject()));
    }
    public DTOResponseStationShip retrieve(UUID id){
        return DTOResponseStationShip.toDTO(repositoryStationShip.findById(id).orElse(null));
    }
    public List<DTOResponseStationShip> retrieve(){
        List<DTOResponseStationShip> list = new ArrayList<>();
        for(StationShip object: repositoryStationShip.findAll()) {
            list.add(DTOResponseStationShip.toDTO(object));
        }
        return list;
    }
    public Page<DTOResponseStationShip> retrieve(Pageable pageable){
        List<DTOResponseStationShip> list = new ArrayList<>();
        for(StationShip object: repositoryStationShip.findAll()) {
            list.add(DTOResponseStationShip.toDTO(object));
        }
        return new PageImpl<DTOResponseStationShip>(list, pageable, list.size());
    }
    public Page<DTOResponseStationShip> retrieve(Pageable pageable, String source){
        final List<DTOResponseStationShip> list = new ArrayList<>();
        if (source == null) {
            for (StationShip object : repositoryStationShip.findAll()) {
                list.add(DTOResponseStationShip.toDTO(object));
            }
        } else {
//            for (StationShip object : repositoryStationShip.findByNameContainingIgnoreCaseOrderByNameAsc(source)) {
//                list.add(DTOResponseStationShip.toDTO(object));
//            }
        }
        return new PageImpl<>(list, pageable, list.size());
    }
    public DTOResponseStationShip update(UUID id, DTORequestStationShip updated){
        StationShip object = repositoryStationShip.findById(id).orElse(null);
        object.setLocalDepth(updated.getLocalDepth());
        object.setCommission(updated.getCommission());
        object.setStationCategory(updated.getStationCategory());
        object.setEquipment(updated.getEquipment());
        object.setSurveying(updated.getSurveying());
        object.setResponsible(updated.getResponsible());
        object.setCountry(updated.getCountry());

//        object.setName(updated.getName());
        object.setDateTime(updated.getDateTime());
        object.setLatitude(updated.getLatitude());
        object.setLongitude(updated.getLongitude());
        object.setTelegraphicCallsign(updated.getTelegraphicCallsign());
        object.setMarsdenSquare(updated.getMarsdenSquare_10());
        object.setMarsdenSubSquare_1(updated.getMarsdenSubSquare_1());
        object.setWmoSquare(updated.getWmoSquare());
        object.setMarsdenSubSquare_5(updated.getMarsdenSubSquare_5());
//        object.setCollectionDepth(updated.getCollectionDepth());
        return DTOResponseStationShip.toDTO(repositoryStationShip.save(object));
    }
    public DTOResponseStationShip delete(UUID id){
        StationShip object = repositoryStationShip.findById(id).orElse(null);
        repositoryStationShip.deleteById(id);
        return DTOResponseStationShip.toDTO(object);
    }
    public void delete() {
        repositoryStationShip.deleteAll();
    }
    public StationShip findByName(String value) { return  null; }
    public boolean existsByName(String value) {
        return false;
    }
}