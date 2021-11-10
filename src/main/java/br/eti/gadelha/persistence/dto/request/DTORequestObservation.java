package br.eti.gadelha.persistence.dto.request;

import br.eti.gadelha.persistence.model.File;
import br.eti.gadelha.persistence.model.observation.Observation;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import java.util.Date;

/**
 * @author	Marcelo Ribeiro Gadelha
 * @mail	gadelha.ti@gmail.com
 * @link	www.gadelha.eti.br
 **/

@Getter @AllArgsConstructor @NoArgsConstructor
public class DTORequestObservation {

    //SECTION 0

    //AABB
    @Pattern(regexp = "AA||BB")
    private String mimi;
    @Pattern(regexp = "XX")
    private String mjmj;
    //DDDDDDD
    private String ddddddd;
    //A1bwnbnbnb

    private String a1;

    private String bw;

    private String nbnbnb;
    //YYGGiw
    @Pattern(regexp = "[0-2][0-9]||3[0-1]")
    private String yy;
    @Pattern(regexp = "00||03||06||09||12||15||18||21")
    private String gg;
    @Pattern(regexp = "0||1||2||3||4")
    private String iw;
    //IIiii
    @Pattern(regexp = "82||83")
    private String ii;
    @Pattern(regexp = "[0-9][0-9][0-9]")
    private String iii;
    //99LaLaLa
    @Pattern(regexp = "[0-8][0-9][0-9]||900")
    private String lalala;
    //QcLoLOLOLO
    @Pattern(regexp = "1||3||5||7")
    private String qc;
    @Pattern(regexp = "[0-1][0-7][0-9][0-9]||1800")
    private String lolololo;

    //SECTION 1

    //iRiXhVV
    @Pattern(regexp = "1||3||4")
    private String ir;
    @Pattern(regexp = "[1-7]")
    private String ix;
    @Pattern(regexp = "[0-9]||\\/")
    private String h;
    @Pattern(regexp = "9[0-9]")
    private String vv;
    //Nddff
    @Pattern(regexp = "[0-9]||\\/")
    private String n;
    @Pattern(regexp = "[0-2][0-9]||3[0-6]||99")
    private String dd;
    @Pattern(regexp = "[0-9][0-9]")
    private String ff;
    @Pattern(regexp = "[1-9][0-9][0-9]")
    private String fff;
    //1snTTT
    @Pattern(regexp = "[0-1]")
    private String sn1_1;
    @Pattern(regexp = "[0-4][0-9][0-9]||500")
    private String ttt;
    //2snTdTdTd (ou 29UUU)
    @Pattern(regexp = "0||1||9]")
    private String sn2_1;
    @Pattern(regexp = "[0-4][0-9][0-9]||500")
    private String tdtdtd;
    //3P0P0P0P0
    @Pattern(regexp = "[0-9][0-9][0-9]||1000||8[7-9][0-9][0-9]||9[0-9][0-9][0-9]")
    private String p0p0p0p0;
    //4PPPP
    @Pattern(regexp = "[0-9][0-9][0-9][0-9]")
    private String pppp;
    @Pattern(regexp = "1||2||5||7||8")
    //4a3hhh

    private String a3;

    private String hhh;
    //5appp
    @Pattern(regexp = "[1-8]||\\/")
    private String a;
    @Pattern(regexp = "[0-1][0-9][0-9]||200")
    private String ppp;
    //6RRRtR
//    @Pattern(regexp = "001||[0-9][0-9][0-9]")
    private String rrr;
    @Pattern(regexp = "[0-9]")
    private String tr;
    //7wwW1W2
    @Pattern(regexp = "[0-9][0-9]")
    private String ww;
    @Pattern(regexp = "[0-9]||\\/")
    private String w1;
    @Pattern(regexp = "[0-9]||\\/")
    private String w2;
    //7wawaWa1Wa2
    @Pattern(regexp = "[0-9][0-9]")
    private String wawa;
    @Pattern(regexp = "[0-9]||\\/")
    private String wa1;
    @Pattern(regexp = "[0-9]||\\/")
    private String wa2;
    //8NhCLCMCH
    @Pattern(regexp = "[0-8]||\\/")
    private String nh;
    @Pattern(regexp = "[0-9]||\\/")
    private String cl;
    @Pattern(regexp = "[0-9]||\\/")
    private String cm;
    @Pattern(regexp = "[0-9]||\\/")
    private String ch;
    //9GGgg
    @Pattern(regexp = "[0-9][0-9][0-9][0-9]")//HHmm
    private String gggg;

    //SECTION 2

    //222DsVs
    @Pattern(regexp = "[0-9]||\\/")
    private String ds;
    @Pattern(regexp = "[0-9]||\\/")
    private String vs;
    //0SsTwTwTw
    @Pattern(regexp = "[0-7]")
    private String ss;
    @Pattern(regexp = "[0-3][0-9][0-9]||400")
    private String twtwtw;
    //1PwaPwaHwaHwa
    @Pattern(regexp = "[0-2][0-9]||30")
    private String pwapwa;
    //    @Pattern(regexp = "0[0-9]||10||\\//")
    private String hwahwa;
    //2PwPwHwHw
    @Pattern(regexp = "[0-1][0-9]||20||99")
    private String pwpw;
    //    @Pattern(regexp = "[0-2][0-9]||30||\\//")
    private String hwhw;
    //3dw1dw1dw2dw2
    @Pattern(regexp = "[0-2][0-9]||3[0-6]")
    private String dw1dw1;
    @Pattern(regexp = "[0-2][0-9]||3[0-6]")
    private String dw2dw2;
    //4Pw1Pw1Hw1Hw1
    @Pattern(regexp = "[0-2][0-9]||30")
    private String pw1pw1;
    @Pattern(regexp = "[0-2][0-9]||30")
    private String hw1hw1;
    //5Pw2Pw2Hw2Hw2
    @Pattern(regexp = "[0-2][0-9]||30")
    private String pw2pw2;
    @Pattern(regexp = "[0-2][0-9]||30")
    private String hw2hw2;
    //6IsEsEsRs (ou ICING + lig. clara)
    @Pattern(regexp = "[1-5]")  @JsonProperty("is")
    private String is_ice;
    @Pattern(regexp = "[0-2][0-9]||30")
    private String eses;
    @Pattern(regexp = "[0-4]")
    private String rs;
    //70HwaHwaHwa
    @Pattern(regexp = "[0-1][0-9][0-9]||200")
    private String hwahwahwa;
    //8swTbTbTb
    @Pattern(regexp = "[0-7]")
    private String sw;
    @Pattern(regexp = "[0-3][0-9][0-9]||400")
    private String tbtbtb;
    //ICE ciSibiDizi (ou ling. clara)
    @Pattern(regexp = "[0-9]||\\/")
    private String ci;
    @Pattern(regexp = "[0-9]||\\/")
    private String si;
    @Pattern(regexp = "[0-9]||\\/")
    private String bi;
    @Pattern(regexp = "[0-9]||\\/")
    private String di;
    @Pattern(regexp = "[0-9]||\\/")
    private String zi;

    //SECTION 3

    //333
    //1snTxTxTx
    @Pattern(regexp = "[0-1]")
    private String sn1_3;
    @Pattern(regexp = "[0-3][0-9][0-9]||4[0-4][0-9]||450")
    private String txtxtx;
    //2snTnTnTn
    @Pattern(regexp = "[0-1]")
    private String sn2_3;
    @Pattern(regexp = "[0-2][0-9][0-9]||3[0-4][0-9]||350")
    private String tntntn;
    //58/9P24P24P24
    @Pattern(regexp = "8||9")
    private String _89;
    @Pattern(regexp = "1[0-9][0-9]||200")
    private String p24p24p24;

    //SECTION 5

    //555
    //chwicMcsicFicpicQ
    @Pattern(regexp = "[0-3]")
    private String ichw;
    @Pattern(regexp = "[0-7]")
    private String icm;
    @Pattern(regexp = "[0-9]")
    private String cs;
    @Pattern(regexp = "[0-6]")
    private String icf;
    @Pattern(regexp = "[0-9]")
    private String icp;
    @Pattern(regexp = "[0-9]")
    private String icq;

    private String observador;
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataObservacao;
    private String estacao;

    @Setter
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
    @JoinColumn(name = "file", nullable = true)
    private File file;

    public Observation toObject(){
        return new Observation(mimi, mjmj, ddddddd, a1, bw, nbnbnb, yy, gg, iw, ii, iii, lalala, qc, lolololo, ir, ix, h, vv, n, dd, ff, fff, sn1_1, ttt, sn2_1, tdtdtd, p0p0p0p0, pppp, a3, hhh, a, ppp, rrr, tr, ww, w1, w2, wawa, wa1, wa2, nh, cl, cm, ch, gggg, ds, vs, ss, twtwtw, pwapwa, hwahwa, pwpw, hwhw, dw1dw1, dw2dw2, pw1pw1, hw1hw1, pw2pw2, hw2hw2, is_ice, eses, rs, hwahwahwa, sw, tbtbtb, ci, si, bi, di, zi, sn1_3, txtxtx, sn2_3, tntntn, _89, p24p24p24, ichw, icm, cs, icf, icp, icq, observador, dataObservacao, estacao, file);
    }
}