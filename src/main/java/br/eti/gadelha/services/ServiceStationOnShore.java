package br.eti.gadelha.services;

import br.eti.gadelha.persistence.MapStruct;
import br.eti.gadelha.persistence.payload.request.DTORequestStationOnShore;
import br.eti.gadelha.persistence.payload.response.DTOResponseStationOnShore;
import br.eti.gadelha.persistence.model.synopticObservation.StationOnShore;
import br.eti.gadelha.persistence.repository.RepositoryStationOffShore;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service @RequiredArgsConstructor
public class ServiceStationOnShore implements ServiceInterface<DTOResponseStationOnShore, DTORequestStationOnShore, StationOnShore> {

    private final RepositoryStationOffShore repositoryStationOffShore;

    public DTOResponseStationOnShore create(DTORequestStationOnShore created){
        return MapStruct.MAPPER.toDTO(repositoryStationOffShore.save(MapStruct.MAPPER.toObject(created)));
    }
    public DTOResponseStationOnShore retrieve(UUID id){
        return MapStruct.MAPPER.toDTO(repositoryStationOffShore.findById(id).orElse(null));
    }
    public List<DTOResponseStationOnShore> retrieve(){
        List<DTOResponseStationOnShore> list = new ArrayList<>();
        for(StationOnShore object: repositoryStationOffShore.findAll()) {
            list.add(MapStruct.MAPPER.toDTO(object));
        }
        return list;
    }
    public Page<DTOResponseStationOnShore> retrieve(Pageable pageable){
        List<DTOResponseStationOnShore> list = new ArrayList<>();
        for(StationOnShore object: repositoryStationOffShore.findAll()) {
            list.add(MapStruct.MAPPER.toDTO(object));
        }
        return new PageImpl<DTOResponseStationOnShore>(list, pageable, list.size());
    }
    public Page<DTOResponseStationOnShore> retrieve(Pageable pageable, String source){
        final List<DTOResponseStationOnShore> list = new ArrayList<>();
        if (source == null) {
            for (StationOnShore object : repositoryStationOffShore.findAll()) {
                list.add(MapStruct.MAPPER.toDTO(object));
            }
        } else {
//            for (StationOffShore object : repositoryStationOffShore.findByLatitudeMostBottomContainingIgnoreCaseOrderByLatitudeMostBottomAsc(source)) {
//                list.add(DTOResponseStationOffShore.toDTO(object));
//            }
        }
        return new PageImpl<>(list, pageable, list.size());
    }
    public DTOResponseStationOnShore update(UUID id, DTORequestStationOnShore updated){
        return MapStruct.MAPPER.toDTO(repositoryStationOffShore.save(MapStruct.MAPPER.toObject(updated)));
    }
    public DTOResponseStationOnShore delete(UUID id){
        StationOnShore object = repositoryStationOffShore.findById(id).orElse(null);
        repositoryStationOffShore.deleteById(id);
        return MapStruct.MAPPER.toDTO(object);
    }
    public void delete() {
        repositoryStationOffShore.deleteAll();
    }
    public StationOnShore findByName(String value) {
        return null;
    }
    public boolean existsByName(String value) {
        return false;
    }
}