package br.eti.gadelha.persistence.payload.response;

import br.eti.gadelha.persistence.model.synopticObservation.SynopticObservation;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.locationtech.jts.geom.Point;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

@Getter @AllArgsConstructor @NoArgsConstructor
public class DTOResponseSynopticObservation {

    @Column(columnDefinition = "POINT")
    private Point coordinates;
    private String latitude;
    private String longitude;
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
    private String w1w2;
//    private String w1;
//    private String w2;
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
    private String ind89;
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

    @Temporal(TemporalType.TIMESTAMP)
    private Date dataObservacao;
    private LocalDateTime dateObservation;
    private String observerName;

//    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
//    @JoinColumn(name = "station")
//    private Station station;
//    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
//    @JoinColumn(name = "observer")
//    private User observer;

    public static DTOResponseSynopticObservation toDTO(SynopticObservation value) {
        return new DTOResponseSynopticObservation(
                value.getCoordinates(),
                value.getLatitude(),
                value.getLongitude(),
                value.getMimi(),
                value.getMjmj(),
                value.getDdddddd(),
                value.getA1(),
                value.getBw(),
                value.getNbnbnb(),
                value.getYy(),
                value.getGg(),
                value.getIw(),
                value.getIi(),
                value.getIii(),
                value.getLalala(),
                value.getQc(),
                value.getLolololo(),
                value.getIr(),
                value.getIx(),
                value.getH(),
                value.getVv(),
                value.getN(),
                value.getDd(),
                value.getFf(),
                value.getFff(),
                value.getSn1_1(),
                value.getTtt(),
                value.getSn2_1(),
                value.getTdtdtd(),
                value.getP0p0p0p0(),
                value.getPppp(),
                value.getA3(),
                value.getHhh(),
                value.getA(),
                value.getPpp(),
                value.getRrr(),
                value.getTr(),
                value.getWw(),
                value.getW1w2(),
//                value.getW1(),
//                value.getW2(),
                value.getWawa(),
                value.getWa1(),
                value.getWa2(),
                value.getNh(),
                value.getCl(),
                value.getCm(),
                value.getCh(),
                value.getGggg(),
                value.getDs(),
                value.getVs(),
                value.getSs(),
                value.getTwtwtw(),
                value.getPwapwa(),
                value.getHwahwa(),
                value.getPwpw(),
                value.getHwhw(),
                value.getDw1dw1(),
                value.getDw2dw2(),
                value.getPw1pw1(),
                value.getHw1hw1(),
                value.getPw2pw2(),
                value.getHw2hw2(),
                value.getIs_ice(),
                value.getEses(),
                value.getRs(),
                value.getHwahwahwa(),
                value.getSw(),
                value.getTbtbtb(),
                value.getCi(),
                value.getSi(),
                value.getBi(),
                value.getDi(),
                value.getZi(),
                value.getSn1_3(),
                value.getTxtxtx(),
                value.getSn2_3(),
                value.getTntntn(),
                value.getInd89(),
                value.getP24p24p24(),
                value.getIchw(),
                value.getIcm(),
                value.getCs(),
                value.getIcf(),
                value.getIcp(),
                value.getIcq(),
                Date.from(value.getDateObservation().atZone(ZoneId.systemDefault()).toInstant()),
                value.getDateObservation(),
                value.getObserverName()
//                value.getStation()
//                value.getObserver()
        );
    }
}