package br.eti.gadelha.persistence.model.observation;

import br.eti.gadelha.exception.enumeration.EnumEquipment;
import br.eti.gadelha.exception.enumeration.EnumMidia;
import br.eti.gadelha.exception.enumeration.EnumTypeComission;
import br.eti.gadelha.exception.enumeration.EnumTypeStation;
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
import java.util.Date;

@Audited @AuditTable(value = "audit_station_synop")
@Entity @Table(name="station_synop")//, schema="shipsynopweb")
@AllArgsConstructor @NoArgsConstructor @EqualsAndHashCode(callSuper = false) @Data
public class StationSynop extends GenericEntity {
    private EnumTypeStation typeStation;
    private EnumTypeComission typeComission;
    private Plataform plataform;
    private EnumEquipment equipment;
    private LocalDateTime first;
    private LocalDateTime last;
    private Date latitudeMostBottom;
    private Date latitudeMostTop;
    private Date longitudeMostRight;
    private Date longitudeMostLeft;
    private EnumMidia midia;
    private String fb;
//    private Plataform plataform;

//    "COD_TIPO_ESTACAO" NUMBER(3,0),
//	"COD_COMISSAO" NUMBER(10,0),
//	"NOME_PLATAFORMA" VARCHAR2(40 BYTE),
//	"COD_EQUIPAMENTO" NUMBER(10,0),
//	"DATA_HORA_INICIO" DATE,
//            "DATA_HORA_FIM" DATE,
//            "LAT_BOTTOMMOST" NUMBER(9,0),
//	"LAT_TOPMOST" NUMBER,
//            "LONG_RIGHTMOST" NUMBER(20,0),
//	"LONG_LEFTMOST" NUMBER,
//            "COD_MIDIA" NUMBER(10,0),
//	"FB" VARCHAR2(50 BYTE),
//	"PLATAFORMA_BATIMETRICA" VARCHAR2(50 BYTE)
}