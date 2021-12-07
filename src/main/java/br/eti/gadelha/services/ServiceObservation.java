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
        observation.setMimi(updated.getMimi());
        observation.setMjmj(updated.getMjmj());
        observation.setDdddddd(updated.getDdddddd());
        observation.setA1(updated.getA1());
        observation.setBw(updated.getBw());
        observation.setNbnbnb(updated.getNbnbnb());
        observation.setYy(updated.getYy());
        observation.setGg(updated.getGg());
        observation.setIw(updated.getIw());
        observation.setIi(updated.getIi());
        observation.setIii(updated.getIii());
        observation.setLalala(updated.getLalala());
        observation.setQc(updated.getQc());
        observation.setLolololo(updated.getLolololo());
        observation.setIr(updated.getIr());
        observation.setIx(updated.getIx());
        observation.setH(updated.getH());
        observation.setVv(updated.getVv());
        observation.setN(updated.getN());
        observation.setDd(updated.getDd());
        observation.setFf(updated.getFf());
        observation.setFff(updated.getFff());
        observation.setSn1_1(updated.getSn1_1());
        observation.setTtt(updated.getTtt());
        observation.setSn2_1(updated.getSn2_1());
        observation.setTdtdtd(updated.getTdtdtd());
        observation.setP0p0p0p0(updated.getP0p0p0p0());
        observation.setPppp(updated.getPppp());
        observation.setA3(updated.getA3());
        observation.setHhh(updated.getHhh());
        observation.setA(updated.getA());
        observation.setPpp(updated.getPpp());
        observation.setRrr(updated.getRrr());
        observation.setTr(updated.getTr());
        observation.setWw(updated.getWw());
        observation.setW1w2(updated.getW1w2());
//        observation.setW1(updated.getW1());
//        observation.setW2(updated.getW2());
        observation.setWawa(updated.getWawa());
        observation.setWa1(updated.getWa1());
        observation.setWa2(updated.getWa2());
        observation.setNh(updated.getNh());
        observation.setCl(updated.getCl());
        observation.setCm(updated.getCm());
        observation.setCh(updated.getCh());
        observation.setGggg(updated.getGggg());
        observation.setDs(updated.getDs());
        observation.setVs(updated.getVs());
        observation.setSs(updated.getSs());
        observation.setTwtwtw(updated.getTwtwtw());
        observation.setPwapwa(updated.getPwapwa());
        observation.setHwahwa(updated.getHwahwa());
        observation.setPwpw(updated.getPwpw());
        observation.setHwhw(updated.getHwhw());
        observation.setDw1dw1(updated.getDw1dw1());
        observation.setDw2dw2(updated.getDw2dw2());
        observation.setPw1pw1(updated.getPw1pw1());
        observation.setHw1hw1(updated.getHw1hw1());
        observation.setPw2pw2(updated.getPw2pw2());
        observation.setHw2hw2(updated.getHw2hw2());
        observation.setIs_ice(updated.getIs_ice());
        observation.setEses(updated.getEses());
        observation.setRs(updated.getRs());
        observation.setHwahwahwa(updated.getHwahwahwa());
        observation.setSw(updated.getSw());
        observation.setTbtbtb(updated.getTbtbtb());
        observation.setCi(updated.getCi());
        observation.setSi(updated.getSi());
        observation.setBi(updated.getBi());
        observation.setDi(updated.getDi());
        observation.setZi(updated.getZi());
        observation.setSn1_3(updated.getSn1_3());
        observation.setTxtxtx(updated.getTxtxtx());
        observation.setSn2_3(updated.getSn2_3());
        observation.setTntntn(updated.getTntntn());
        observation.setInd89(updated.getInd89());
        observation.setP24p24p24(updated.getP24p24p24());
        observation.setIchw(updated.getIchw());
        observation.setIcm(updated.getIcm());
        observation.setCs(updated.getCs());
        observation.setIcf(updated.getIcf());
        observation.setIcp(updated.getIcp());
        observation.setIcq(updated.getIcq());
        observation.setObservador(updated.getObservador());
        observation.setDataObservacao(updated.getDataObservacao());
        observation.setEstacao(updated.getEstacao());
        observation.setFile(updated.getFile());
        return DTOResponseObservation.toDTO(repository.save(observation));
    }
    public DTOResponseObservation delete(UUID id){
        DTOResponseObservation deleted = DTOResponseObservation.toDTO(repository.findById(id).get());
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