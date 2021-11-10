package br.eti.gadelha.services;

import br.eti.gadelha.persistence.dto.request.DTORequestObservation;
import br.eti.gadelha.persistence.dto.response.DTOResponseObservation;
import br.eti.gadelha.persistence.model.observation.Observation;
import br.eti.gadelha.persistence.repository.RepositoryObservation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @author	Marcelo Ribeiro Gadelha
 * @mail	gadelha.ti@gmail.com
 * @link	www.gadelha.eti.br
 **/

@Service
public class ServiceObservation {

    private final RepositoryObservation repository;

    public ServiceObservation(RepositoryObservation repository) {
        this.repository = repository;
    }

    public DTOResponseObservation create(DTORequestObservation created){
        return DTOResponseObservation.toDTO(repository.save(created.toObject()));
    }

    public List<DTOResponseObservation> retrieveAll(){
        List<DTOResponseObservation> list = new ArrayList<>();
        for(Observation observation: repository.findAll()) {
            list.add(DTOResponseObservation.toDTO(observation));
        }
        return list;
    }

    public Page<DTOResponseObservation> retrieve(Pageable pageable){
        List<DTOResponseObservation> list = new ArrayList<>();
        for(Observation observation: repository.findAll()) {
            list.add(DTOResponseObservation.toDTO(observation));
        }
        return new PageImpl<DTOResponseObservation>(list, pageable, list.size());
    }
    public DTOResponseObservation retrieve(UUID id){
        return DTOResponseObservation.toDTO(repository.findById(id).get());
    }
    public Page<DTOResponseObservation> retrieveSource(Pageable pageable, String source){
        final List<DTOResponseObservation> list = new ArrayList<>();
        if (source == null) {
            for (Observation observation : repository.findAll()) {
                list.add(DTOResponseObservation.toDTO(observation));
            }
        } else {
//            for (Observation observation : repository.findByEstacaoContainingIgnoreCaseOrderByEstacaoAsc(source)) {
//                list.add(DTOResponseObservation.toDTO(observation));
//            }
        }
        return new PageImpl<DTOResponseObservation>(list, pageable, list.size());
    }
    public DTOResponseObservation update(UUID id, DTORequestObservation updated){
        Observation observation = repository.findById(id).get();
        observation.setMimi(observation.getMimi());
        observation.setMjmj(observation.getMjmj());
        observation.setDdddddd(observation.getDdddddd());
        observation.setA1(observation.getA1());
        observation.setBw(observation.getBw());
        observation.setNbnbnb(observation.getNbnbnb());
        observation.setYy(observation.getYy());
        observation.setGg(observation.getGg());
        observation.setIw(observation.getIw());
        observation.setIi(observation.getIi());
        observation.setIii(observation.getIii());
        observation.setLalala(observation.getLalala());
        observation.setQc(observation.getQc());
        observation.setLolololo(observation.getLolololo());
        observation.setIr(observation.getIr());
        observation.setIx(observation.getIx());
        observation.setH(observation.getH());
        observation.setVv(observation.getVv());
        observation.setN(observation.getN());
        observation.setDd(observation.getDd());
        observation.setFf(observation.getFf());
        observation.setFff(observation.getFff());
        observation.setSn1_1(observation.getSn1_1());
        observation.setTtt(observation.getTtt());
        observation.setSn2_1(observation.getSn2_1());
        observation.setTdtdtd(observation.getTdtdtd());
        observation.setP0p0p0p0(observation.getP0p0p0p0());
        observation.setPppp(observation.getPppp());
        observation.setA3(observation.getA3());
        observation.setHhh(observation.getHhh());
        observation.setA(observation.getA());
        observation.setPpp(observation.getPpp());
        observation.setRrr(observation.getRrr());
        observation.setTr(observation.getTr());
        observation.setWw(observation.getWw());
        observation.setW1(observation.getW1());
        observation.setW2(observation.getW2());
        observation.setWawa(observation.getWawa());
        observation.setWa1(observation.getWa1());
        observation.setWa2(observation.getWa2());
        observation.setNh(observation.getNh());
        observation.setCl(observation.getCl());
        observation.setCm(observation.getCm());
        observation.setCh(observation.getCh());
        observation.setGggg(observation.getGggg());
        observation.setDs(observation.getDs());
        observation.setVs(observation.getVs());
        observation.setSs(observation.getSs());
        observation.setTwtwtw(observation.getTwtwtw());
        observation.setPwapwa(observation.getPwapwa());
        observation.setHwahwa(observation.getHwahwa());
        observation.setPwpw(observation.getPwpw());
        observation.setHwhw(observation.getHwhw());
        observation.setDw1dw1(observation.getDw1dw1());
        observation.setDw2dw2(observation.getDw2dw2());
        observation.setPw1pw1(observation.getPw1pw1());
        observation.setHw1hw1(observation.getHw1hw1());
        observation.setPw2pw2(observation.getPw2pw2());
        observation.setHw2hw2(observation.getHw2hw2());
        observation.setIs_ice(observation.getIs_ice());
        observation.setEses(observation.getEses());
        observation.setRs(observation.getRs());
        observation.setHwahwahwa(observation.getHwahwahwa());
        observation.setSw(observation.getSw());
        observation.setTbtbtb(observation.getTbtbtb());
        observation.setCi(observation.getCi());
        observation.setSi(observation.getSi());
        observation.setBi(observation.getBi());
        observation.setDi(observation.getDi());
        observation.setZi(observation.getZi());
        observation.setSn1_3(observation.getSn1_3());
        observation.setTxtxtx(observation.getTxtxtx());
        observation.setSn2_3(observation.getSn2_3());
        observation.setTntntn(observation.getTntntn());
        observation.set_89(observation.get_89());
        observation.setP24p24p24(observation.getP24p24p24());
        observation.setIchw(observation.getIchw());
        observation.setIcm(observation.getIcm());
        observation.setCs(observation.getCs());
        observation.setIcf(observation.getIcf());
        observation.setIcp(observation.getIcp());
        observation.setIcq(observation.getIcq());
        observation.setObservador(observation.getObservador());
        observation.setDataObservacao(observation.getDataObservacao());
        observation.setEstacao(observation.getEstacao());
        observation.setFile(updated.getFile());
        return DTOResponseObservation.toDTO(repository.save(observation));
    }
    public void delete(UUID id){
        repository.deleteById(id);
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