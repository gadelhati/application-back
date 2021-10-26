package br.eti.gadelha.persistence.dto.response;

import br.eti.gadelha.persistence.model.File;
import br.eti.gadelha.persistence.model.ShipSynop;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.persistence.*;
import java.util.Date;

/**
 * @author	Marcelo Ribeiro Gadelha
 * @mail	gadelha.ti@gmail.com
 * @link	www.gadelha.eti.br
 **/

@Getter @AllArgsConstructor
public class DTOResponseShipSynop {

    @Column(length = 128) //@Pattern(regexp = "[0-2][0-9]|30")
    private String observador;
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataObservacao;
    @Column(length = 128)
    private String estacao;
    @Column(length = 128)
    private String iw;
    @Column(length = 128)
    private String iii;
    @Column(length = 128)
    private String ir;
    @Column(length = 128)
    private String ix;
    @Column(length = 128)
    private String h;
    @Column(length = 128)
    private String dd;
    @Column(length = 128)
    private String ff;
    @Column(length = 128)
    private String fixo00_1;
    @Column(length = 128)
    private String fff;
    @Column(length = 128)
    private String fixo1_1;
    @Column(length = 128)
    private String fixo2_1;
    @Column(length = 128)
    private String fixo3_1;
    @Column(length = 128)
    private String fixo4_1;
    @Column(length = 128)
    private String fixo5_1;
    @Column(length = 128)
    private String a;
    @Column(length = 128)
    private String ppp;
    @Column(length = 128)
    private String fixo6_1;
    @Column(length = 128)
    private String tr;
    @Column(length = 128)
    private String fixo7_1;
    @Column(length = 128)
    private String ww;
    @Column(length = 128)
    private String fixo8_1;
    @Column(length = 128)
    private String fixo9_1;
    @Column(length = 128)
    private String fixo222_2;
    @Column(length = 128)
    private String fixo0_2;
    @Column(length = 128)
    private String fixo1_2;
    @Column(length = 128)
    private String fixo2_2;
    @Column(length = 128)
    private String fixo3_2;
    @Column(length = 128)
    private String dw1dw1;
    @Column(length = 128)
    private String dw2dw2;
    @Column(length = 128)
    private String fixo4_2;
    @Column(length = 128)
    private String fixo5_2;
    @Column(length = 128)
    private String fixo6_2;
    @Column(length = 128)
    private String fixo70_2;
    @Column(length = 128)
    private String fixo8_2;
    @Column(length = 128)
    private String ci;
    @Column(length = 128)
    private String bi;
    @Column(length = 128)
    private String zi;
    @Column(length = 128)
    private String fixo_333;
    @Column(length = 128)
    private String fixo1_3;
    @Column(length = 128)
    private String fixo2_3;
    @Column(length = 128)
    private String fixo5_3;
    @Column(length = 128)
    private String ind89;
    @Column(length = 128)
    private String fixo555_5;
    @Column(length = 128) @JsonProperty("ichw")
    private String iChw;
    @Column(length = 128)
    private String iCM;
    @Column(length = 128)
    private String cs;
    @Column(length = 128)
    private String iCF;
    @Column(length = 128)
    private String iCP;
    @Column(length = 128)
    private String iCQ;
    @Column(length = 128) @JsonProperty("2snTdTdTdUUU")
    private String _2snTdTdTdUUU;
    @Column(length = 128) @JsonProperty("5Pw2Pw2Hw2Hw2")
    private String _5Pw2Pw2Hw2Hw2;
    @Column(length = 128) @JsonProperty("8NhClCmCh")
    private String _8NhClCmCh;
    @Column(length = 128)
    private String dddddd;
    @Column(length = 128) @JsonProperty("2PwPwHwHw")
    private String _2PwPwHwHw;
    @Column(length = 128) @JsonProperty("00fff")
    private String _00fff;
    @Column(length = 128) @JsonProperty("3PoPoPoPo")
    private String _3PoPoPoPo;
    @Column(length = 128) @JsonProperty("2snTnTnTn")
    private String _2snTnTnTn;
    @Column(length = 128)
    private String yyggiw;
    @Column(length = 128) @JsonProperty("1snTTT")
    private String _1snTTT;
    @Column(length = 128) @JsonProperty("5appp")
    private String _5appp;
    @Column(length = 128) @JsonProperty("6RRRtr")
    private String _6RRRtr;
    @Column(length = 128) @JsonProperty("222DsVs")
    private String _222DsVs;
    @Column(length = 128) @JsonProperty("4Pw1Pw1Hw1Hw1")
    private String _4Pw1Pw1Hw1Hw1;
    @Column(length = 128)
    private String irixhVV;
    @Column(length = 128)
    private String iiiii;
    @Column(length = 128) @JsonProperty("99LaLaLa")
    private String _99LaLaLa;
    @Column(length = 128)
    private String qcLoLoLoLo;
    @Column(length = 128) @JsonProperty("3dw1dw1dw2dw2")
    private String _3dw1dw1dw2dw2;
    @Column(length = 128) @JsonProperty("6IsEsEsRs")
    private String _6IsEsEsRs;
    @Column(length = 128)
    private String nddff;
    @Column(length = 128) @JsonProperty("4PPPP")
    private String _4PPPP;
    @Column(length = 128) @JsonProperty("1PwaPwaHwaHwa")
    private String _1PwaPwaHwaHwa;
    @Column(length = 128) @JsonProperty("70HwaHwaHwa")
    private String _70HwaHwaHwa;
    @Column(length = 128) @JsonProperty("7wwW1W2")
    private String _7wwW1W2;
    @Column(length = 128)
    private String ciSibiDizi;
    @Column(length = 128)
    private String ice;
    @Column(length = 128) @JsonProperty("1snTxTxTx")
    private String _1snTxTxTx;
    @Column(length = 128) @JsonProperty("0SsTwTwTw")
    private String _0SsTwTwTw;
    @Column(length = 128) @JsonProperty("8SwTbTbTb")
    private String _8SwTbTbTb;
    @Column(length = 128)
    private String yy;
    @Column(length = 128)
    private String fixo99;
    @Column(length = 128)
    private String laLaLa;
    @Column(length = 128)
    private String qc;
    @Column(length = 128)
    private String ii;
    @Column(length = 128)
    private String loLoLoLo;
    @Column(length = 128)
    private String vv;
    @Column(length = 128)
    private String aabbxx;
    @Column(length = 128)
    private String gg;
    @Column(length = 128)
    private String poPoPoPo;
    @Column(length = 128)
    private String ch;
    @Column(length = 128)
    private String tdTdTd_UUU;
    @Column(length = 128)
    private String n;
    @Column(length = 128)
    private String sn1_1;
    @Column(length = 128)
    private String ttt;
    @Column(length = 128)
    private String rrr;
    @Column(length = 128)
    private String pppp;
    @Column(length = 128)
    private String w1W2;
    @Column(length = 128)
    private String nh;
    @Column(length = 128)
    private String sn2_1;
    @Column(length = 128)
    private String cl;
    @Column(length = 128)
    private String cm;
    @Column(length = 128)
    private String hw1Hw1;
    @Column(length = 128)
    private String pw2Pw2;
    @Column(length = 128)
    private String hwHw;
    @Column(length = 128)
    private String ss;
    @Column(length = 128)
    private String pwaPwa;
    @Column(length = 128)
    private String pw1Pw1;
    @Column(length = 128)
    private String vs;
    @Column(length = 128) @JsonProperty("is")
    private String _is;
    @Column(length = 128)
    private String gggg;
    @Column(length = 128)
    private String ds;
    @Column(length = 128)
    private String twTwTw;
    @Column(length = 128)
    private String hwaHwa;
    @Column(length = 128)
    private String pwPw;
    @Column(length = 128)
    private String hw2Hw2;
    @Column(length = 128)
    private String esEs;
    @Column(length = 128)
    private String sw;
    @Column(length = 128)
    private String sn2_3;
    @Column(length = 128)
    private String di;
    @Column(length = 128)
    private String hwa2Hwa2Hwa2;
    @Column(length = 128)
    private String p24P24P24;
    @Column(length = 128)
    private String tnTnTn;
    @Column(length = 128) @JsonProperty("9GGgg")
    private String _9GGgg;
    @Column(length = 128)
    private String sn1_3;
    @Column(length = 128)
    private String si;
    @Column(length = 128)
    private String tbTbTb;
    @Column(length = 128)
    private String txTxTx;
    @Column(length = 128)
    private String rs;
    @Column
    private boolean ship;
    @Column
    private boolean synop;
    @Column(length = 128)
    private String iChwiCMCsiCFiCpiCQ;
    @Column(length = 128) @JsonProperty("5ind89P24P24P24")
    private String _5ind89P24P24P24;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
    @JoinColumn(name = "file", nullable = true)
    private File file;

    public static DTOResponseShipSynop toDTO(ShipSynop shipSynop) {
        return new DTOResponseShipSynop(
                shipSynop.getObservador(),
                shipSynop.getDataObservacao(),
                shipSynop.getEstacao(),
                shipSynop.getIw(),
                shipSynop.getIi(),
                shipSynop.getIr(),
                shipSynop.getIx(),
                shipSynop.getH(),
                shipSynop.getDd(),
                shipSynop.getFf(),
                shipSynop.getFixo00_1(),
                shipSynop.getFff(),
                shipSynop.getFixo1_1(),
                shipSynop.getFixo2_1(),
                shipSynop.getFixo3_1(),
                shipSynop.getFixo4_1(),
                shipSynop.getFixo5_1(),
                shipSynop.getA(),
                shipSynop.getPpp(),
                shipSynop.getFixo6_1(),
                shipSynop.getTr(),
                shipSynop.getFixo7_1(),
                shipSynop.getWw(),
                shipSynop.getFixo8_1(),
                shipSynop.getFixo9_1(),
                shipSynop.getFixo222_2(),
                shipSynop.getFixo0_2(),
                shipSynop.getFixo1_2(),
                shipSynop.getFixo2_2(),
                shipSynop.getFixo3_2(),
                shipSynop.getDw1dw1(),
                shipSynop.getDw2dw2(),
                shipSynop.getFixo4_2(),
                shipSynop.getFixo5_2(),
                shipSynop.getFixo6_2(),
                shipSynop.getFixo70_2(),
                shipSynop.getFixo8_2(),
                shipSynop.getCi(),
                shipSynop.getBi(),
                shipSynop.getZi(),
                shipSynop.getFixo_333(),
                shipSynop.getFixo1_3(),
                shipSynop.getFixo2_3(),
                shipSynop.getFixo5_3(),
                shipSynop.getInd89(),
                shipSynop.getFixo555_5(),
                shipSynop.getIChw(),
                shipSynop.getICM(),
                shipSynop.getCs(),
                shipSynop.getICF(),
                shipSynop.getICP(),
                shipSynop.getICQ(),
                shipSynop.get_2snTdTdTdUUU(),
                shipSynop.get_5Pw2Pw2Hw2Hw2(),
                shipSynop.get_8NhClCmCh(),
                shipSynop.getDddddd(),
                shipSynop.get_2PwPwHwHw(),
                shipSynop.get_00fff(),
                shipSynop.get_3PoPoPoPo(),
                shipSynop.get_2snTnTnTn(),
                shipSynop.getYyggiw(),
                shipSynop.get_1snTTT(),
                shipSynop.get_5appp(),
                shipSynop.get_6RRRtr(),
                shipSynop.get_222DsVs(),
                shipSynop.get_4Pw1Pw1Hw1Hw1(),
                shipSynop.getIrixhVV(),
                shipSynop.getIiiii(),
                shipSynop.get_99LaLaLa(),
                shipSynop.getQcLoLoLoLo(),
                shipSynop.get_3dw1dw1dw2dw2(),
                shipSynop.get_6IsEsEsRs(),
                shipSynop.getNddff(),
                shipSynop.get_4PPPP(),
                shipSynop.get_1PwaPwaHwaHwa(),
                shipSynop.get_70HwaHwaHwa(),
                shipSynop.get_7wwW1W2(),
                shipSynop.getCiSibiDizi(),
                shipSynop.getIce(),
                shipSynop.get_1snTxTxTx(),
                shipSynop.get_0SsTwTwTw(),
                shipSynop.get_8SwTbTbTb(),
                shipSynop.getYy(),
                shipSynop.getFixo99(),
                shipSynop.getLaLaLa(),
                shipSynop.getQc(),
                shipSynop.getIi(),
                shipSynop.getLoLoLoLo(),
                shipSynop.getVv(),
                shipSynop.getAabbxx(),
                shipSynop.getGg(),
                shipSynop.getPoPoPoPo(),
                shipSynop.getCh(),
                shipSynop.getTdTdTd_UUU(),
                shipSynop.getN(),
                shipSynop.getSn1_1(),
                shipSynop.getTtt(),
                shipSynop.getRrr(),
                shipSynop.getPppp(),
                shipSynop.getW1W2(),
                shipSynop.getNh(),
                shipSynop.getSn2_1(),
                shipSynop.getCl(),
                shipSynop.getCm(),
                shipSynop.getHw1Hw1(),
                shipSynop.getPw2Pw2(),
                shipSynop.getHwHw(),
                shipSynop.getSs(),
                shipSynop.getPwaPwa(),
                shipSynop.getPw1Pw1(),
                shipSynop.getVs(),
                shipSynop.get_is(),
                shipSynop.getGggg(),
                shipSynop.getDs(),
                shipSynop.getTwTwTw(),
                shipSynop.getHwaHwa(),
                shipSynop.getPwPw(),
                shipSynop.getHw2Hw2(),
                shipSynop.getEsEs(),
                shipSynop.getSw(),
                shipSynop.getSn2_3(),
                shipSynop.getDi(),
                shipSynop.getHwa2Hwa2Hwa2(),
                shipSynop.getP24P24P24(),
                shipSynop.getTnTnTn(),
                shipSynop.get_9GGgg(),
                shipSynop.getSn1_3(),
                shipSynop.getSi(),
                shipSynop.getTbTbTb(),
                shipSynop.getTxTxTx(),
                shipSynop.getRs(),
                shipSynop.isShip(),
                shipSynop.isSynop(),
                shipSynop.getIChwiCMCsiCFiCpiCQ(),
                shipSynop.get_5ind89P24P24P24(),
                shipSynop.getFile()
        );
    }
}