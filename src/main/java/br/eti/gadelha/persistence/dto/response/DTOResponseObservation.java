package br.eti.gadelha.persistence.dto.response;

import br.eti.gadelha.persistence.model.File;
import br.eti.gadelha.persistence.model.observation.Observation;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

/**
 * @author	Marcelo Ribeiro Gadelha
 * @mail	gadelha.ti@gmail.com
 * @link	www.gadelha.eti.br
 **/

@Getter @AllArgsConstructor
public class DTOResponseObservation {

    //SECTION 0

    //AABB
    private String mimi;
    private String mjmj;
    //DDDDDDD
    private String ddddddd;
    //A1bwnbnbnb
    private String a1;
    private String bw;
    private String nbnbnb;
    //YYGGiw
    private String yy;
    private String gg;
    private String iw;
    //IIiii
    private String ii;
    private String iii;
    //99LaLaLa
    private String lalala;
    //QcLoLOLOLO
    private String qc;
    private String lolololo;

    //SECTION 1

    //iRiXhVV
    private String ir;
    private String ix;
    private String h;
    private String vv;
    //Nddff
    private String n;
    private String dd;
    private String ff;
    private String fff;
    //1snTTT
    private String sn1_1;
    private String ttt;
    //2snTdTdTd (ou 29UUU)
    private String sn2_1;
    private String tdtdtd;
    //3P0P0P0P0
    private String p0p0p0p0;
    //4PPPP
    private String pppp;
    //4a3hhh
    private String a3;
    private String hhh;
    //5appp
    private String a;
    private String ppp;
    //6RRRtR
    private String rrr;
    private String tr;
    //7wwW1W2
    private String ww;
    private String w1;
    private String w2;
    //7wawaWa1Wa2
    private String wawa;
    private String wa1;
    private String wa2;
    //8NhCLCMCH
    private String nh;
    private String cl;
    private String cm;
    private String ch;
    //9GGgg
    private String gggg;

    //SECTION 2

    //222DsVs
    private String ds;
    private String vs;
    //0SsTwTwTw
    private String ss;
    private String twtwtw;
    //1PwaPwaHwaHwa
    private String pwapwa;
    private String hwahwa;
    //2PwPwHwHw
    private String pwpw;
    private String hwhw;
    //3dw1dw1dw2dw2
    private String dw1dw1;
    private String dw2dw2;
    //4Pw1Pw1Hw1Hw1
    private String pw1pw1;
    private String hw1hw1;
    //5Pw2Pw2Hw2Hw2
    private String pw2pw2;
    private String hw2hw2;
    //6IsEsEsRs (ou ICING + lig. clara)
    private String is_ice;
    private String eses;
    private String rs;
    //70HwaHwaHwa
    private String hwahwahwa;
    //8swTbTbTb
    private String sw;
    private String tbtbtb;
    //ICE ciSibiDizi (ou ling. clara)
    private String ci;
    private String si;
    private String bi;
    private String di;
    private String zi;

    //SECTION 3

    //333
    //1snTxTxTx
    private String sn1_3;
    private String txtxtx;
    //2snTnTnTn
    private String sn2_3;
    private String tntntn;
    //58/9P24P24P24
    private String _89;
    private String p24p24p24;

    //SECTION 5

    //555
    //chwicMcsicFicpicQ
    private String ichw;
    private String icm;
    private String cs;
    private String icf;
    private String icp;
    private String icq;

    private String observador;
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataObservacao;
    private String estacao;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
    @JoinColumn(name = "file", nullable = true)
    private File file;

    public static DTOResponseObservation toDTO(Observation observation) {
        return new DTOResponseObservation(
                observation.getMimi(),
                observation.getMjmj(),
                observation.getDdddddd(),
                observation.getA1(),
                observation.getBw(),
                observation.getNbnbnb(),
                observation.getYy(),
                observation.getGg(),
                observation.getIw(),
                observation.getIi(),
                observation.getIii(),
                observation.getLalala(),
                observation.getQc(),
                observation.getLolololo(),
                observation.getIr(),
                observation.getIx(),
                observation.getH(),
                observation.getVv(),
                observation.getN(),
                observation.getDd(),
                observation.getFf(),
                observation.getFff(),
                observation.getSn1_1(),
                observation.getTtt(),
                observation.getSn2_1(),
                observation.getTdtdtd(),
                observation.getP0p0p0p0(),
                observation.getPppp(),
                observation.getA3(),
                observation.getHhh(),
                observation.getA(),
                observation.getPpp(),
                observation.getRrr(),
                observation.getTr(),
                observation.getWw(),
                observation.getW1(),
                observation.getW2(),
                observation.getWawa(),
                observation.getWa1(),
                observation.getWa2(),
                observation.getNh(),
                observation.getCl(),
                observation.getCm(),
                observation.getCh(),
                observation.getGggg(),
                observation.getDs(),
                observation.getVs(),
                observation.getSs(),
                observation.getTwtwtw(),
                observation.getPwapwa(),
                observation.getHwahwa(),
                observation.getPwpw(),
                observation.getHwhw(),
                observation.getDw1dw1(),
                observation.getDw2dw2(),
                observation.getPw1pw1(),
                observation.getHw1hw1(),
                observation.getPw2pw2(),
                observation.getHw2hw2(),
                observation.getIs_ice(),
                observation.getEses(),
                observation.getRs(),
                observation.getHwahwahwa(),
                observation.getSw(),
                observation.getTbtbtb(),
                observation.getCi(),
                observation.getSi(),
                observation.getBi(),
                observation.getDi(),
                observation.getZi(),
                observation.getSn1_3(),
                observation.getTxtxtx(),
                observation.getSn2_3(),
                observation.getTntntn(),
                observation.get_89(),
                observation.getP24p24p24(),
                observation.getIchw(),
                observation.getIcm(),
                observation.getCs(),
                observation.getIcf(),
                observation.getIcp(),
                observation.getIcq(),
                observation.getObservador(),
                observation.getDataObservacao(),
                observation.getEstacao(),
                observation.getFile()
        );
    }
}