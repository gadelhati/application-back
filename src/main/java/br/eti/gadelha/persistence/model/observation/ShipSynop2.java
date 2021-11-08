package br.eti.gadelha.persistence.model.observation;

import br.eti.gadelha.persistence.model.File;
import br.eti.gadelha.persistence.model.GenericEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.envers.AuditTable;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import java.util.Date;

@Audited @AuditTable(value = "shipsynop2_auditoria")
@Entity @Table(name="shipsynop2")//, schema="shipsynopweb")
@AllArgsConstructor @NoArgsConstructor @EqualsAndHashCode(callSuper = false) @Data
public class ShipSynop2 extends GenericEntity {

    //SECTION 0

    //AABB
    @Pattern(regexp = "AA||BB")
    private String MiMi;
    @Pattern(regexp = "XX")
    private String MjMj;
    //DDDDDDD
    private String DDDDDDD;
    //A1bwnbnbnb

    private String A1;

    private String bw;

    private String nbnbnb;
    //YYGGiw
    @Pattern(regexp = "[0-2][0-9]||3[0-1]")
    private String YY;
    @Pattern(regexp = "00||03||06||09||12||15||18||21")
    private String GG;
    @Pattern(regexp = "0||1||2||3||4")
    private String iW;
    //IIiii
    @Pattern(regexp = "82||83")
    private String II;
    @Pattern(regexp = "[0-9][0-9][0-9]")
    private String iii;
    //99LaLaLa
    @Pattern(regexp = "[0-8][0-9][0-9]||900")
    private String LaLaLa;
    //QcLoLOLOLO
    @Pattern(regexp = "1||3||5||7")
    private String Qc;
    @Pattern(regexp = "[0-1][0-7][0-9][0-9]||1800")
    private String LoLOLOLO;

    //SECTION 1

    //iRiXhVV
    @Pattern(regexp = "1||3||4")
    private String iR;
    @Pattern(regexp = "[1-7]")
    private String iX;
    @Pattern(regexp = "[0-9]||\\/")
    private String h;
    @Pattern(regexp = "9[0-9]")
    private String VV;
    //Nddff
    @Pattern(regexp = "[0-9]||\\/")
    private String N;
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
    private String TTT;
    //2snTdTdTd (ou 29UUU)
    @Pattern(regexp = "0||1||9]")
    private String sn2_1;
    @Pattern(regexp = "[0-4][0-9][0-9]||500")
    private String TdTdTd;
    //3P0P0P0P0
    @Pattern(regexp = "[0-9][0-9][0-9]||1000||8[7-9][0-9][0-9]||9[0-9][0-9][0-9]")
    private String P0P0P0P0;
    //4PPPP
    @Pattern(regexp = "[0-9][0-9][0-9][0-9]")
    private String PPPP;
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
    private String RRR;
    @Pattern(regexp = "[0-9]")
    private String tR;
    //7wwW1W2
    @Pattern(regexp = "[0-9][0-9]")
    private String ww;
    @Pattern(regexp = "[0-9]||\\/")
    private String W1;
    @Pattern(regexp = "[0-9]||\\/")
    private String W2;
    //7wawaWa1Wa2
    @Pattern(regexp = "[0-9][0-9]")
    private String wawa;
    @Pattern(regexp = "[0-9]||\\/")
    private String Wa1;
    @Pattern(regexp = "[0-9]||\\/")
    private String Wa2;
    //8NhCLCMCH
    @Pattern(regexp = "[0-8]||\\/")
    private String Nh;
    @Pattern(regexp = "[0-9]||\\/")
    private String CL;
    @Pattern(regexp = "[0-9]||\\/")
    private String CM;
    @Pattern(regexp = "[0-9]||\\/")
    private String CH;
    //9GGgg
    @Pattern(regexp = "[0-9][0-9][0-9][0-9]")//HHmm
    private String GGgg;

    //SECTION 2

    //222DsVs
    @Pattern(regexp = "[0-9]||\\/")
    private String Ds;
    @Pattern(regexp = "[0-9]||\\/")
    private String Vs;
    //0SsTwTwTw
    @Pattern(regexp = "[0-7]")
    private String Ss;
    @Pattern(regexp = "[0-3][0-9][0-9]||400")
    private String TwTwTw;
    //1PwaPwaHwaHwa
    @Pattern(regexp = "[0-2][0-9]||30")
    private String PwaPwa;
//    @Pattern(regexp = "0[0-9]||10||\\//")
    private String HwaHwa;
    //2PwPwHwHw
    @Pattern(regexp = "[0-1][0-9]||20||99")
    private String PwPw;
//    @Pattern(regexp = "[0-2][0-9]||30||\\//")
    private String HwHw;
    //3dw1dw1dw2dw2
    @Pattern(regexp = "[0-2][0-9]||3[0-6]")
    private String dw1dw1;
    @Pattern(regexp = "[0-2][0-9]||3[0-6]")
    private String dw2dw2;
    //4Pw1Pw1Hw1Hw1
    @Pattern(regexp = "[0-2][0-9]||30")
    private String Pw1Pw1;
    @Pattern(regexp = "[0-2][0-9]||30")
    private String Hw1Hw1;
    //5Pw2Pw2Hw2Hw2
    @Pattern(regexp = "[0-2][0-9]||30")
    private String Pw2Pw2;
    @Pattern(regexp = "[0-2][0-9]||30")
    private String Hw2Hw2;
    //6IsEsEsRs (ou ICING + lig. clara)
    @Pattern(regexp = "[1-5]")
    private String Is;
    @Pattern(regexp = "[0-2][0-9]||30")
    private String EsEs;
    @Pattern(regexp = "[0-4]")
    private String Rs;
    //70HwaHwaHwa
    @Pattern(regexp = "[0-1][0-9][0-9]||200")
    private String HwaHwaHwa;
    //8swTbTbTb
    @Pattern(regexp = "[0-7]")
    private String sw;
    @Pattern(regexp = "[0-3][0-9][0-9]||400")
    private String TbTbTb;
    //ICE ciSibiDizi (ou ling. clara)
    @Pattern(regexp = "[0-9]||\\/")
    private String ci;
    @Pattern(regexp = "[0-9]||\\/")
    private String Si;
    @Pattern(regexp = "[0-9]||\\/")
    private String bi;
    @Pattern(regexp = "[0-9]||\\/")
    private String Di;
    @Pattern(regexp = "[0-9]||\\/")
    private String zi;

    //SECTION 3

    //333
    //1snTxTxTx
    @Pattern(regexp = "[0-1]")
    private String sn1_3;
    @Pattern(regexp = "[0-3][0-9][0-9]||4[0-4][0-9]||450")
    private String TxTxTx;
    //2snTnTnTn
    @Pattern(regexp = "[0-1]")
    private String sn2_3;
    @Pattern(regexp = "[0-2][0-9][0-9]||3[0-4][0-9]||350")
    private String TnTnTn;
    //58/9P24P24P24
    @Pattern(regexp = "8||9")
    private String _89;
    @Pattern(regexp = "1[0-9][0-9]||200")
    private String P24P24P24;

    //SECTION 5

    //555
    //chwicMcsicFicpicQ
    @Pattern(regexp = "[0-3]")
    private String ichw;
    @Pattern(regexp = "[0-7]")
    private String icM;
    @Pattern(regexp = "[0-9]")
    private String cs;
    @Pattern(regexp = "[0-6]")
    private String icF;
    @Pattern(regexp = "[0-9]")
    private String icp;
    @Pattern(regexp = "[0-9]")
    private String icQ;

    private String observador;
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataObservacao;
    private String estacao;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
    @JoinColumn(name = "file", nullable = true)
    private File file;
}