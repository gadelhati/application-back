package br.eti.gadelha.persistence.model.observation;

import br.eti.gadelha.exception.annotation.ValidGG;
import br.eti.gadelha.exception.annotation.ValidIw;
import br.eti.gadelha.exception.annotation.ValidYY;
import br.eti.gadelha.exception.enumeration.EnumMiMiMjMj;
import br.eti.gadelha.persistence.model.GenericEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.envers.AuditTable;
import org.hibernate.envers.Audited;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDateTime;

//@Audited @AuditTable(value = "audit_synoptic_observation")
@Entity @Table(name="synoptic_observation")//, schema="shipsynopweb")
@AllArgsConstructor @NoArgsConstructor @EqualsAndHashCode(callSuper = false) @Data
public class SynopticObservation extends GenericEntity {
    private String observer;
    private LocalDateTime dateTime;
    private String station;

    private EnumMiMiMjMj MiMiMjMj;//station identification group
    private String DDDDDD;//ship’s call sign
    private String A1;
    private String bw;
    private String nbnbnb;
    @ValidYY
    private String YY;
    @ValidGG
    private String GG;
    @ValidIw
    private String iw;

    private String II;
    private String iii;//WMO número 9
    private String LaLaLa;
    private String Qc;
    private String LoLOLOLO;

    private String iR;
    private String iX;
    private String h;
    private String VV;
    private String N;
    private String dd;
    private String ff;
    private String fff;
    private String sn1;
    private String TTT;
    private String sn2;
    private String TdTdTd;
    private String UUU;
    private String P0P0P0P0;
    private String PPPP;
    private String a;
    private String ppp;
    private String RRR;
    private String iR6;
    private String ww;
    private String W1W2;
    private String Nh;
    private String CL;
    private String CM;
    private String CH;
    private String GGgg;

    private String Ds;
    private String Vs;
    private String Ss;
    private String TwTwTw;
    private String PwaPwa;
    private String HwaHwa;
    private String PwPw;
    private String HwHw;
    private String dw1dw1;
    private String dw2dw2;
    private String Pw1Pw1;
    private String Hw1Hw1;
    private String Pw2Pw2;
    private String Hw2Hw2;
    private String Iese;
    private String EsEs;
    private String Rs;
    private String HwaHwaHwa;
    private String sw;
    private String TbTbTb;
    private String ci;
    private String Si;
    private String bi;
    private String Di;
    private String zi;

//    private String sn1;
    private String TxTxTx;
//    private String sn2;
    private String TnTnTn;
    private String _89;
    private String P24P24P24;

    private String ichw;
    private String icM;
    private String cs;
    private String icF;
    private String icp;
    private String icQ;
}