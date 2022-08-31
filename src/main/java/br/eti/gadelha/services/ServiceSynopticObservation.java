package br.eti.gadelha.services;

import br.eti.gadelha.persistence.dto.request.DTORequestSynopticObservation;
import br.eti.gadelha.persistence.dto.response.DTOResponseSynopticObservation;
import br.eti.gadelha.persistence.model.synoptic.SynopticObservation;
import br.eti.gadelha.persistence.repository.RepositorySynopticObservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.validation.beanvalidation.CustomValidatorBean;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.*;

@Service
public class ServiceSynopticObservation {

    private final RepositorySynopticObservation repository;
    @Autowired
    private Validator validator;
//    LocalValidatorFactoryBean validator2 = new LocalValidatorFactoryBean();

    public ServiceSynopticObservation(RepositorySynopticObservation repository) {
        this.repository = repository;
    }

    public DTOResponseSynopticObservation create(DTORequestSynopticObservation created){
        System.out.println("3");
        return DTOResponseSynopticObservation.toDTO(repository.save(created.toObject()));
    }

    public List<DTOResponseSynopticObservation> create(List<DTORequestSynopticObservation> createds){
        System.out.println("all 3");
        List<DTOResponseSynopticObservation> list = new ArrayList<>();
        System.out.println("all 4");
        Set<ConstraintViolation<DTORequestSynopticObservation>> violations = new HashSet<>();
        System.out.println("all 5");
        System.out.println(createds.size());
        for(DTORequestSynopticObservation created : createds){
            System.out.println("all 6");
//            violations = validator.validate(created, DTORequestSynopticObservation.class);
//            if(!violations.isEmpty()) {
                repository.save(created.toObject());
                list.add(DTOResponseSynopticObservation.toDTO(created.toObject()));
//            }
        }
        System.out.println("all 7");
        return list;
    }

    public List<DTOResponseSynopticObservation> retrieve(){
        List<DTOResponseSynopticObservation> list = new ArrayList<>();
        for(SynopticObservation synopticObservation : repository.findAll()) {
            list.add(DTOResponseSynopticObservation.toDTO(synopticObservation));
        }
        return list;
    }

    public Page<DTOResponseSynopticObservation> retrieve(Pageable pageable){
        List<DTOResponseSynopticObservation> list = new ArrayList<>();
        for(SynopticObservation synopticObservation : repository.findAll()) {
            list.add(DTOResponseSynopticObservation.toDTO(synopticObservation));
        }
        return new PageImpl<DTOResponseSynopticObservation>(list, pageable, list.size());
    }
    public DTOResponseSynopticObservation retrieve(UUID id){
        return DTOResponseSynopticObservation.toDTO(repository.findById(id).orElse(null));
    }
    public Page<DTOResponseSynopticObservation> retrieveSource(Pageable pageable, String source){
        final List<DTOResponseSynopticObservation> list = new ArrayList<>();
        if (source == null) {
            for (SynopticObservation synopticObservation : repository.findAll()) {
                list.add(DTOResponseSynopticObservation.toDTO(synopticObservation));
            }
        } else {
//            for (Observation observation : repository.findByEstacaoContainingIgnoreCaseOrderByEstacaoAsc(source)) {
//                list.add(DTOResponseObservation.toDTO(observation));
//            }
        }
        return new PageImpl<DTOResponseSynopticObservation>(list, pageable, list.size());
    }
    public DTOResponseSynopticObservation update(UUID id, DTORequestSynopticObservation updated){
        SynopticObservation synopticObservation = repository.findById(id).orElse(null);
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
        synopticObservation.setStationName(updated.getStationName());
        synopticObservation.setObserverName(updated.getObserverName());
//        synopticObservation.setStation(updated.getStation());
//        synopticObservation.setDateObservation(updated.getDateObservation());
        return DTOResponseSynopticObservation.toDTO(repository.save(synopticObservation));
    }
    public DTOResponseSynopticObservation delete(UUID id){
        DTOResponseSynopticObservation deleted = DTOResponseSynopticObservation.toDTO(repository.findById(id).orElse(null));
        repository.deleteById(id);
        return deleted;
    }
    public void delete() {
        repository.deleteAll();
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