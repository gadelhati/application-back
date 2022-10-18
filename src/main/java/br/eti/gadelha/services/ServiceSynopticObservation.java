package br.eti.gadelha.services;

import br.eti.gadelha.persistence.payload.request.DTORequestSynopticObservation;
import br.eti.gadelha.persistence.payload.response.DTOResponseSynopticObservation;
import br.eti.gadelha.persistence.model.synopticObservation.SynopticObservation;
import br.eti.gadelha.persistence.model.synopticObservation.SynopticObservationId;
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

    public DTOResponseSynopticObservation create(DTORequestSynopticObservation created){
        return DTOResponseSynopticObservation.toDTO(repositorySynopticObservation.save(created.toObject()));
    }
    public List<DTOResponseSynopticObservation> create(List<DTORequestSynopticObservation> createds){
        List<DTOResponseSynopticObservation> list = new ArrayList<>();
        Set<ConstraintViolation<DTORequestSynopticObservation>> violations = new HashSet<>();
        for(DTORequestSynopticObservation created : createds){
            created.setDateObservation(created.getDataObservacao().toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime().withHour(Integer.parseInt(created.getGg())));
            created.setDdddddd(created.getEstacao());
            created.setObserverName(created.getObservador());
            created.setMimi(created.getAabbxx().substring(0,2));
            created.setMjmj("XX");
            repositorySynopticObservation.save(created.toObject());
            list.add(DTOResponseSynopticObservation.toDTO(created.toObject()));
        }
        return list;
    }
    public DTOResponseSynopticObservation retrieve(DTORequestSynopticObservation updated){
        return DTOResponseSynopticObservation.toDTO(repositorySynopticObservation.findById(new SynopticObservationId(updated.getDateObservation(), updated.getDdddddd())).orElse(null));
    }
    public List<DTOResponseSynopticObservation> retrieve(){
        List<DTOResponseSynopticObservation> list = new ArrayList<>();
        for(SynopticObservation synopticObservation : repositorySynopticObservation.findAll()) {
            list.add(DTOResponseSynopticObservation.toDTO(synopticObservation));
        }
        return list;
    }
    public Page<DTOResponseSynopticObservation> retrieve(Pageable pageable){
        List<DTOResponseSynopticObservation> list = new ArrayList<>();
        for(SynopticObservation synopticObservation : repositorySynopticObservation.findAll()) {
            list.add(DTOResponseSynopticObservation.toDTO(synopticObservation));
        }
        return new PageImpl<DTOResponseSynopticObservation>(list, pageable, list.size());
    }
    public Page<DTOResponseSynopticObservation> retrieveSource(Pageable pageable, String source){
        final List<DTOResponseSynopticObservation> list = new ArrayList<>();
        if (source == null) {
            for (SynopticObservation synopticObservation : repositorySynopticObservation.findAll()) {
                list.add(DTOResponseSynopticObservation.toDTO(synopticObservation));
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
        SynopticObservation synopticObservation = repositorySynopticObservation.findById(new SynopticObservationId(updated.getDateObservation(), updated.getDdddddd())).orElse(null);
        synopticObservation.setMimi(updated.getMimi());
        synopticObservation.setMjmj(updated.getMjmj());
        synopticObservation.setDdddddd(updated.getDdddddd());
        synopticObservation.setA1(updated.getA1());
        synopticObservation.setBw(updated.getBw());
        synopticObservation.setNbnbnb(updated.getNbnbnb());
        synopticObservation.setYy(updated.getYy());
        synopticObservation.setGg(updated.getGg());
        synopticObservation.setIw(updated.getIw());
        synopticObservation.setIi(updated.getIi());
        synopticObservation.setIii(updated.getIii());
        synopticObservation.setLalala(updated.getLalala());
        synopticObservation.setQc(updated.getQc());
        synopticObservation.setLolololo(updated.getLolololo());
        synopticObservation.setIr(updated.getIr());
        synopticObservation.setIx(updated.getIx());
        synopticObservation.setH(updated.getH());
        synopticObservation.setVv(updated.getVv());
        synopticObservation.setN(updated.getN());
        synopticObservation.setDd(updated.getDd());
        synopticObservation.setFf(updated.getFf());
        synopticObservation.setFff(updated.getFff());
        synopticObservation.setSn1_1(updated.getSn1_1());
        synopticObservation.setTtt(updated.getTtt());
        synopticObservation.setSn2_1(updated.getSn2_1());
        synopticObservation.setTdtdtd(updated.getTdtdtd());
        synopticObservation.setP0p0p0p0(updated.getP0p0p0p0());
        synopticObservation.setPppp(updated.getPppp());
        synopticObservation.setA3(updated.getA3());
        synopticObservation.setHhh(updated.getHhh());
        synopticObservation.setA(updated.getA());
        synopticObservation.setPpp(updated.getPpp());
        synopticObservation.setRrr(updated.getRrr());
        synopticObservation.setTr(updated.getTr());
        synopticObservation.setWw(updated.getWw());
        synopticObservation.setW1w2(updated.getW1w2());
//        observation.setW1(updated.getW1());
//        observation.setW2(updated.getW2());
        synopticObservation.setWawa(updated.getWawa());
        synopticObservation.setWa1(updated.getWa1());
        synopticObservation.setWa2(updated.getWa2());
        synopticObservation.setNh(updated.getNh());
        synopticObservation.setCl(updated.getCl());
        synopticObservation.setCm(updated.getCm());
        synopticObservation.setCh(updated.getCh());
        synopticObservation.setGggg(updated.getGggg());
        synopticObservation.setDs(updated.getDs());
        synopticObservation.setVs(updated.getVs());
        synopticObservation.setSs(updated.getSs());
        synopticObservation.setTwtwtw(updated.getTwtwtw());
        synopticObservation.setPwapwa(updated.getPwapwa());
        synopticObservation.setHwahwa(updated.getHwahwa());
        synopticObservation.setPwpw(updated.getPwpw());
        synopticObservation.setHwhw(updated.getHwhw());
        synopticObservation.setDw1dw1(updated.getDw1dw1());
        synopticObservation.setDw2dw2(updated.getDw2dw2());
        synopticObservation.setPw1pw1(updated.getPw1pw1());
        synopticObservation.setHw1hw1(updated.getHw1hw1());
        synopticObservation.setPw2pw2(updated.getPw2pw2());
        synopticObservation.setHw2hw2(updated.getHw2hw2());
        synopticObservation.setIs_ice(updated.getIs_ice());
        synopticObservation.setEses(updated.getEses());
        synopticObservation.setRs(updated.getRs());
        synopticObservation.setHwahwahwa(updated.getHwahwahwa());
        synopticObservation.setSw(updated.getSw());
        synopticObservation.setTbtbtb(updated.getTbtbtb());
        synopticObservation.setCi(updated.getCi());
        synopticObservation.setSi(updated.getSi());
        synopticObservation.setBi(updated.getBi());
        synopticObservation.setDi(updated.getDi());
        synopticObservation.setZi(updated.getZi());
        synopticObservation.setSn1_3(updated.getSn1_3());
        synopticObservation.setTxtxtx(updated.getTxtxtx());
        synopticObservation.setSn2_3(updated.getSn2_3());
        synopticObservation.setTntntn(updated.getTntntn());
        synopticObservation.setInd89(updated.getInd89());
        synopticObservation.setP24p24p24(updated.getP24p24p24());
        synopticObservation.setIchw(updated.getIchw());
        synopticObservation.setIcm(updated.getIcm());
        synopticObservation.setCs(updated.getCs());
        synopticObservation.setIcf(updated.getIcf());
        synopticObservation.setIcp(updated.getIcp());
        synopticObservation.setIcq(updated.getIcq());
        synopticObservation.setObserverName(updated.getObserverName());
//        synopticObservation.setStation(updated.getStation());
//        synopticObservation.setDateObservation(updated.getDateObservation());
        return DTOResponseSynopticObservation.toDTO(repositorySynopticObservation.save(synopticObservation));
    }
    public DTOResponseSynopticObservation delete(String dateObservation, String ddddddd){
        String str = dateObservation;
        LocalDateTime localDateTime = LocalDateTime.parse(str);
        DTOResponseSynopticObservation deleted = DTOResponseSynopticObservation.toDTO(repositorySynopticObservation.findById(new SynopticObservationId(localDateTime, ddddddd)).orElse(null));
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