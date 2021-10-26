package br.eti.gadelha.services;

import br.eti.gadelha.persistence.dto.request.DTORequestShipSynop;
import br.eti.gadelha.persistence.dto.response.DTOResponseShipSynop;
import br.eti.gadelha.persistence.model.ShipSynop;
import br.eti.gadelha.persistence.repository.RepositoryShipSynop;
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
public class ServiceShipSynop {

    private final RepositoryShipSynop repository;

    public ServiceShipSynop(RepositoryShipSynop repository) {
        this.repository = repository;
    }

    public DTOResponseShipSynop create(DTORequestShipSynop created){
        return DTOResponseShipSynop.toDTO(repository.save(created.toObject()));
    }

    public List<DTOResponseShipSynop> retrieveAll(){
        List<DTOResponseShipSynop> list = new ArrayList<>();
        for(ShipSynop shipSynop: repository.findAll()) {
            list.add(DTOResponseShipSynop.toDTO(shipSynop));
        }
        return list;
    }

    public Page<DTOResponseShipSynop> retrieve(Pageable pageable){
        List<DTOResponseShipSynop> list = new ArrayList<>();
        for(ShipSynop shipSynop: repository.findAll()) {
            list.add(DTOResponseShipSynop.toDTO(shipSynop));
        }
        return new PageImpl<DTOResponseShipSynop>(list, pageable, list.size());
    }
    public DTOResponseShipSynop retrieve(UUID id){
        return DTOResponseShipSynop.toDTO(repository.findById(id).get());
    }
    public Page<DTOResponseShipSynop> retrieveSource(Pageable pageable, String source){
        final List<DTOResponseShipSynop> list = new ArrayList<>();
        if (source == null) {
            for (ShipSynop shipSynop : repository.findAll()) {
                list.add(DTOResponseShipSynop.toDTO(shipSynop));
            }
        } else {
            for (ShipSynop shipSynop : repository.findByEstacaoContainingIgnoreCaseOrderByEstacaoAsc(source)) {
                list.add(DTOResponseShipSynop.toDTO(shipSynop));
            }
        }
        return new PageImpl<DTOResponseShipSynop>(list, pageable, list.size());
    }
    public DTOResponseShipSynop update(UUID id, DTORequestShipSynop updated){
        ShipSynop shipSynop = repository.findById(id).get();
        shipSynop.setObservador(updated.getObservador());
        shipSynop.setDataObservacao(updated.getDataObservacao());
        shipSynop.setEstacao(updated.getEstacao());
        shipSynop.setIw(updated.getIw());
        shipSynop.setIi(updated.getIi());
        shipSynop.setIr(updated.getIr());
        shipSynop.setIx(updated.getIx());
        shipSynop.setH(updated.getH());
        shipSynop.setDd(updated.getDd());
        shipSynop.setFf(updated.getFf());
        shipSynop.setFixo00_1(updated.getFixo00_1());
        shipSynop.setFff(updated.getFff());
        shipSynop.setFixo1_1(updated.getFixo1_1());
        shipSynop.setFixo2_1(updated.getFixo2_1());
        shipSynop.setFixo3_1(updated.getFixo3_1());
        shipSynop.setFixo4_1(updated.getFixo4_1());
        shipSynop.setFixo5_1(updated.getFixo5_1());
        shipSynop.setA(updated.getA());
        shipSynop.setPpp(updated.getPpp());
        shipSynop.setFixo6_1(updated.getFixo6_1());
        shipSynop.setTr(updated.getTr());
        shipSynop.setFixo7_1(updated.getFixo7_1());
        shipSynop.setWw(updated.getWw());
        shipSynop.setFixo8_1(updated.getFixo8_1());
        shipSynop.setFixo9_1(updated.getFixo9_1());
        shipSynop.setFixo222_2(updated.getFixo222_2());
        shipSynop.setFixo0_2(updated.getFixo0_2());
        shipSynop.setFixo1_2(updated.getFixo1_2());
        shipSynop.setFixo2_2(updated.getFixo2_2());
        shipSynop.setFixo3_2(updated.getFixo3_2());
        shipSynop.setDw1dw1(updated.getDw1dw1());
        shipSynop.setDw2dw2(updated.getDw2dw2());
        shipSynop.setFixo4_2(updated.getFixo4_2());
        shipSynop.setFixo5_2(updated.getFixo5_2());
        shipSynop.setFixo6_2(updated.getFixo6_2());
        shipSynop.setFixo70_2(updated.getFixo70_2());
        shipSynop.setFixo8_2(updated.getFixo8_2());
        shipSynop.setCi(updated.getCi());
        shipSynop.setBi(updated.getBi());
        shipSynop.setZi(updated.getZi());
        shipSynop.setFixo_333(updated.getFixo_333());
        shipSynop.setFixo1_3(updated.getFixo1_3());
        shipSynop.setFixo2_3(updated.getFixo2_3());
        shipSynop.setFixo5_3(updated.getFixo5_3());
        shipSynop.setInd89(updated.getInd89());
        shipSynop.setFixo555_5(updated.getFixo555_5());
        shipSynop.setIChw(updated.getIChw());
        shipSynop.setICM(updated.getICM());
        shipSynop.setCs(updated.getCs());
        shipSynop.setICF(updated.getICF());
        shipSynop.setICP(updated.getICP());
        shipSynop.setICQ(updated.getICQ());
        shipSynop.set_2snTdTdTdUUU(updated.get_2snTdTdTdUUU());
        shipSynop.set_5Pw2Pw2Hw2Hw2(updated.get_5Pw2Pw2Hw2Hw2());
        shipSynop.set_8NhClCmCh(updated.get_8NhClCmCh());
        shipSynop.setDddddd(updated.getDddddd());
        shipSynop.set_2PwPwHwHw(updated.get_2PwPwHwHw());
        shipSynop.set_00fff(updated.get_00fff());
        shipSynop.set_3PoPoPoPo(updated.get_3PoPoPoPo());
        shipSynop.set_2snTnTnTn(updated.get_2snTnTnTn());
        shipSynop.setYyggiw(updated.getYyggiw());
        shipSynop.set_1snTTT(updated.get_1snTTT());
        shipSynop.set_5appp(updated.get_5appp());
        shipSynop.set_6RRRtr(updated.get_6RRRtr());
        shipSynop.set_222DsVs(updated.get_222DsVs());
        shipSynop.set_4Pw1Pw1Hw1Hw1(updated.get_4Pw1Pw1Hw1Hw1());
        shipSynop.setIrixhVV(updated.getIrixhVV());
        shipSynop.setIiiii(updated.getIiiii());
        shipSynop.set_99LaLaLa(updated.get_99LaLaLa());
        shipSynop.setQcLoLoLoLo(updated.getQcLoLoLoLo());
        shipSynop.set_3dw1dw1dw2dw2(updated.get_3dw1dw1dw2dw2());
        shipSynop.set_6IsEsEsRs(updated.get_6IsEsEsRs());
        shipSynop.setNddff(updated.getNddff());
        shipSynop.set_4PPPP(updated.get_4PPPP());
        shipSynop.set_1PwaPwaHwaHwa(updated.get_1PwaPwaHwaHwa());
        shipSynop.set_70HwaHwaHwa(updated.get_70HwaHwaHwa());
        shipSynop.set_7wwW1W2(updated.get_7wwW1W2());
        shipSynop.setCiSibiDizi(updated.getCiSibiDizi());
        shipSynop.setIce(updated.getIce());
        shipSynop.set_1snTxTxTx(updated.get_1snTxTxTx());
        shipSynop.set_0SsTwTwTw(updated.get_0SsTwTwTw());
        shipSynop.set_8SwTbTbTb(updated.get_8SwTbTbTb());
        shipSynop.setYy(updated.getYy());
        shipSynop.setFixo99(updated.getFixo99());
        shipSynop.setLaLaLa(updated.getLaLaLa());
        shipSynop.setQc(updated.getQc());
        shipSynop.setIi(updated.getIi());
        shipSynop.setLoLoLoLo(updated.getLoLoLoLo());
        shipSynop.setVv(updated.getVv());
        shipSynop.setAabbxx(updated.getAabbxx());
        shipSynop.setGg(updated.getGg());
        shipSynop.setPoPoPoPo(updated.getPoPoPoPo());
        shipSynop.setCh(updated.getCh());
        shipSynop.setTdTdTd_UUU(updated.getTdTdTd_UUU());
        shipSynop.setN(updated.getN());
        shipSynop.setSn1_1(updated.getSn1_1());
        shipSynop.setTtt(updated.getTtt());
        shipSynop.setRrr(updated.getRrr());
        shipSynop.setPppp(updated.getPppp());
        shipSynop.setW1W2(updated.getW1W2());
        shipSynop.setNh(updated.getNh());
        shipSynop.setSn2_1(updated.getSn2_1());
        shipSynop.setCl(updated.getCl());
        shipSynop.setCm(updated.getCm());
        shipSynop.setHw1Hw1(updated.getHw1Hw1());
        shipSynop.setPw2Pw2(updated.getPw2Pw2());
        shipSynop.setHwHw(updated.getHwHw());
        shipSynop.setSs(updated.getSs());
        shipSynop.setPwaPwa(updated.getPwaPwa());
        shipSynop.setPw1Pw1(updated.getPw1Pw1());
        shipSynop.setVs(updated.getVs());
        shipSynop.set_is(updated.get_is());
        shipSynop.setGggg(updated.getGggg());
        shipSynop.setDs(updated.getDs());
        shipSynop.setTwTwTw(updated.getTwTwTw());
        shipSynop.setHwaHwa(updated.getHwaHwa());
        shipSynop.setPwPw(updated.getPwPw());
        shipSynop.setHw2Hw2(updated.getHw2Hw2());
        shipSynop.setEsEs(updated.getEsEs());
        shipSynop.setSw(updated.getSw());
        shipSynop.setSn2_3(updated.getSn2_3());
        shipSynop.setDi(updated.getDi());
        shipSynop.setHwa2Hwa2Hwa2(updated.getHwa2Hwa2Hwa2());
        shipSynop.setP24P24P24(updated.getP24P24P24());
        shipSynop.setTnTnTn(updated.getTnTnTn());
        shipSynop.set_9GGgg(updated.get_9GGgg());
        shipSynop.setSn1_3(updated.getSn1_3());
        shipSynop.setSi(updated.getSi());
        shipSynop.setTbTbTb(updated.getTbTbTb());
        shipSynop.setTxTxTx(updated.getTxTxTx());
        shipSynop.setRs(updated.getRs());
        shipSynop.setShip(updated.isShip());
        shipSynop.setSynop(updated.isSynop());
        shipSynop.setIChwiCMCsiCFiCpiCQ(updated.getIChwiCMCsiCFiCpiCQ());
        shipSynop.set_5ind89P24P24P24(updated.get_5ind89P24P24P24());
        shipSynop.setFile(updated.getFile());
        return DTOResponseShipSynop.toDTO(repository.save(shipSynop));
    }
    public void delete(UUID id){
        repository.deleteById(id);
    }
    public void delete() {
        repository.deleteAll();
    };

    public boolean isEstacaoValid(String value) {
        return repository.existsByEstacao(value);
    }
    public List<DTOResponseShipSynop> retrieveByEstacao(String source){
        final List<DTOResponseShipSynop> list = new ArrayList<>();
        for (ShipSynop shipSynop : repository.findByEstacaoContainingIgnoreCaseOrderByEstacaoAsc(source)) {
            list.add(DTOResponseShipSynop.toDTO(shipSynop));
        }
        return list;
    }
}