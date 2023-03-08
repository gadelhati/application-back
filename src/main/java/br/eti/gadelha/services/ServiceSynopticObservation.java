package br.eti.gadelha.services;

import br.eti.gadelha.persistence.MapStruct;
import br.eti.gadelha.persistence.model.synopticObservation.Observer;
import br.eti.gadelha.persistence.payload.request.DTORequestSynopticObservation;
import br.eti.gadelha.persistence.payload.response.DTOResponseSynopticObservation;
import br.eti.gadelha.persistence.model.synopticObservation.SynopticObservation;
import br.eti.gadelha.persistence.model.synopticObservation.SynopticObservationId;
import br.eti.gadelha.persistence.repository.RepositoryObserver;
import br.eti.gadelha.persistence.repository.RepositoryStationShip;
import br.eti.gadelha.persistence.repository.RepositorySynopticObservation;
import lombok.RequiredArgsConstructor;
import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.io.ParseException;
import org.locationtech.jts.io.WKTReader;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.*;

@Service @RequiredArgsConstructor
public class ServiceSynopticObservation {

    private final RepositorySynopticObservation repositorySynopticObservation;
    private final RepositoryStationShip repositoryStationShip;
    private final RepositoryObserver repositoryObserver;

    public DTOResponseSynopticObservation create(DTORequestSynopticObservation created){
        return MapStruct.MAPPER.toDTO(repositorySynopticObservation.save(MapStruct.MAPPER.toObject(created)));
    }
    public List<DTOResponseSynopticObservation> create(List<DTORequestSynopticObservation> createds){
        List<DTOResponseSynopticObservation> list = new ArrayList<>();
        Set<ConstraintViolation<DTORequestSynopticObservation>> violations = new HashSet<>();
        for(DTORequestSynopticObservation created : createds){
            created.setDateObservation(created.getDataObservacao().toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime().withHour(Integer.parseInt(created.getGg())));
            created.setDdddddd(created.getEstacao());
//            created.setObserverName(created.getObservador());
            created.setMimi(created.getAabbxx().substring(0,2));
            created.setMjmj("XX");
            repositorySynopticObservation.save(MapStruct.MAPPER.toObject(created));
            list.add(MapStruct.MAPPER.toDTO(MapStruct.MAPPER.toObject(created)));
        }
        return list;
    }
    public DTOResponseSynopticObservation retrieve(DTORequestSynopticObservation updated){
        return MapStruct.MAPPER.toDTO(repositorySynopticObservation.findById(new SynopticObservationId(updated.getDateObservation(), updated.getDdddddd())).orElse(null));
    }
    public List<DTOResponseSynopticObservation> retrieve(){
        List<DTOResponseSynopticObservation> list = new ArrayList<>();
        for(SynopticObservation synopticObservation : repositorySynopticObservation.findAll()) {
            list.add(MapStruct.MAPPER.toDTO(synopticObservation));
        }
        return list;
    }
    public Page<DTOResponseSynopticObservation> retrieve(Pageable pageable){
        List<DTOResponseSynopticObservation> list = new ArrayList<>();
        for(SynopticObservation synopticObservation : repositorySynopticObservation.findAll()) {
            list.add(MapStruct.MAPPER.toDTO(synopticObservation));
        }
        return new PageImpl<DTOResponseSynopticObservation>(list, pageable, list.size());
    }
    public Page<DTOResponseSynopticObservation> retrieveSource(Pageable pageable, String source){
        final List<DTOResponseSynopticObservation> list = new ArrayList<>();
        if (source == null) {
            for (SynopticObservation synopticObservation : repositorySynopticObservation.findAll()) {
                list.add(MapStruct.MAPPER.toDTO(synopticObservation));
            }
        } else {
//            for (SynopticObservation synopticObservation : repositorySynopticObservation.findByEstacaoContainingIgnoreCaseOrderByEstacaoAsc(source)) {
//                list.add(DTOResponseSynopticObservation.toDTO(synopticObservation));
//            }
        }
        return new PageImpl<DTOResponseSynopticObservation>(list, pageable, list.size());
    }
    public Geometry wktToGeometry(String wellKnownText) throws ParseException {
        return new WKTReader().read(wellKnownText);
    }
    public DTOResponseSynopticObservation update(DTORequestSynopticObservation updated) {
        return MapStruct.MAPPER.toDTO(repositorySynopticObservation.save(MapStruct.MAPPER.toObject(updated)));
    }
    public DTOResponseSynopticObservation delete(String dateObservation, String ddddddd){
        String str = dateObservation;
        LocalDateTime localDateTime = LocalDateTime.parse(str);
        DTOResponseSynopticObservation deleted = MapStruct.MAPPER.toDTO(repositorySynopticObservation.findById(new SynopticObservationId(localDateTime, ddddddd)).orElse(null));
        repositorySynopticObservation.deleteById(new SynopticObservationId(localDateTime, ddddddd));
        return deleted;
    }
    public void delete() {
        repositorySynopticObservation.deleteAll();
    };

//    public boolean isEstacaoValid(String value) {
//        return repository.existsByEstacao(value);
//    }
//    public List<DTOResponseObservation> retrieveByEstacao(String source){
//        final List<DTOResponseObservation> list = new ArrayList<>();
//        for (Observation observation : repository.findByEstacaoContainingIgnoreCaseOrderByEstacaoAsc(source)) {
//            list.add(DTOResponseObservation.toDTO(observation));
//        }
//        return list;
//    }
}