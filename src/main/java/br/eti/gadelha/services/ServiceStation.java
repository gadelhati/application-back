package br.eti.gadelha.services;

import br.eti.gadelha.persistence.MapStruct;
import br.eti.gadelha.persistence.payload.request.DTORequestStation;
import br.eti.gadelha.persistence.payload.response.DTOResponseStation;
import br.eti.gadelha.persistence.model.synopticObservation.Station;
import br.eti.gadelha.persistence.repository.RepositoryStation;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service @RequiredArgsConstructor
public class ServiceStation implements ServiceInterface<DTOResponseStation, DTORequestStation, Station> {

    private final RepositoryStation repositoryStation;

    public DTOResponseStation create(DTORequestStation created){
        return MapStruct.MAPPER.toDTO(repositoryStation.save(MapStruct.MAPPER.toObject(created)));
    }
    public DTOResponseStation retrieve(UUID id){
        return MapStruct.MAPPER.toDTO(repositoryStation.findById(id).orElse(null));
    }
    public List<DTOResponseStation> retrieve(){
        List<DTOResponseStation> list = new ArrayList<>();
        for(Station object: repositoryStation.findAll()) {
            list.add(MapStruct.MAPPER.toDTO(object));
        }
        return list;
    }
    public Page<DTOResponseStation> retrieve(Pageable pageable){
        List<DTOResponseStation> list = new ArrayList<>();
        for(Station object: repositoryStation.findAll()) {
            list.add(MapStruct.MAPPER.toDTO(object));
        }
        return new PageImpl<DTOResponseStation>(list, pageable, list.size());
    }
    public Page<DTOResponseStation> retrieve(Pageable pageable, String source){
        final List<DTOResponseStation> list = new ArrayList<>();
        if (source == null) {
            for (Station object : repositoryStation.findAll()) {
                list.add(MapStruct.MAPPER.toDTO(object));
            }
        } else {
//            for (Station object : repositoryStation.findByComContainingIgnoreCaseOrderByComAsc(source)) {
//                list.add(DTOResponseStation.toDTO(object));
//            }
        }
        return new PageImpl<>(list, pageable, list.size());
    }
    public DTOResponseStation update(UUID id, DTORequestStation updated){
        return MapStruct.MAPPER.toDTO(repositoryStation.save(MapStruct.MAPPER.toObject(updated)));
    }
    public DTOResponseStation delete(UUID id){
        Station object = repositoryStation.findById(id).orElse(null);
        repositoryStation.deleteById(id);
        return MapStruct.MAPPER.toDTO(object);
    }
    public void delete() {
        repositoryStation.deleteAll();
    }
    public Station findByName(String value) { return  null; }
    public boolean existsByName(String value) {
        return false;
    }
}