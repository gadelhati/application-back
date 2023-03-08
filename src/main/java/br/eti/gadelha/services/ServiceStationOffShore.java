package br.eti.gadelha.services;

import br.eti.gadelha.persistence.MapStruct;
import br.eti.gadelha.persistence.model.synopticObservation.StationOffShore;
import br.eti.gadelha.persistence.payload.request.DTORequestStationOffShore;
import br.eti.gadelha.persistence.payload.response.DTOResponseStationOffShore;
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
public class ServiceStationOffShore implements ServiceInterface<DTOResponseStationOffShore, DTORequestStationOffShore, StationOffShore> {

    private final RepositoryStationShip repositoryStationShip;

    public DTOResponseStationOffShore create(DTORequestStationOffShore created){
        return MapStruct.MAPPER.toDTO(repositoryStationShip.save(MapStruct.MAPPER.toObject(created)));
    }
    public DTOResponseStationOffShore retrieve(UUID id){
        return MapStruct.MAPPER.toDTO(repositoryStationShip.findById(id).orElse(null));
    }
    public List<DTOResponseStationOffShore> retrieve(){
        List<DTOResponseStationOffShore> list = new ArrayList<>();
        for(StationOffShore object: repositoryStationShip.findAll()) {
            list.add(MapStruct.MAPPER.toDTO(object));
        }
        return list;
    }
    public Page<DTOResponseStationOffShore> retrieve(Pageable pageable){
        List<DTOResponseStationOffShore> list = new ArrayList<>();
        for(StationOffShore object: repositoryStationShip.findAll()) {
            list.add(MapStruct.MAPPER.toDTO(object));
        }
        return new PageImpl<DTOResponseStationOffShore>(list, pageable, list.size());
    }
    public Page<DTOResponseStationOffShore> retrieve(Pageable pageable, String source){
        final List<DTOResponseStationOffShore> list = new ArrayList<>();
        if (source == null) {
            for (StationOffShore object : repositoryStationShip.findAll()) {
                list.add(MapStruct.MAPPER.toDTO(object));
            }
        } else {
//            for (StationShip object : repositoryStationShip.findByNameContainingIgnoreCaseOrderByNameAsc(source)) {
//                list.add(MapStruct.MAPPER.toDTO(object));
//            }
        }
        return new PageImpl<>(list, pageable, list.size());
    }
    public DTOResponseStationOffShore update(UUID id, DTORequestStationOffShore updated){
        return MapStruct.MAPPER.toDTO(repositoryStationShip.save(MapStruct.MAPPER.toObject(updated)));
    }
    public DTOResponseStationOffShore delete(UUID id){
        StationOffShore object = repositoryStationShip.findById(id).orElse(null);
        repositoryStationShip.deleteById(id);
        return MapStruct.MAPPER.toDTO(object);
    }
    public void delete() {
        repositoryStationShip.deleteAll();
    }
    public StationOffShore findByName(String value) { return  null; }
    public boolean existsByName(String value) {
        return false;
    }
}