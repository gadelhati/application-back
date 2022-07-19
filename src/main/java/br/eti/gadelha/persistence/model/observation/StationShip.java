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

import javax.persistence.*;
import java.time.LocalDateTime;

@Audited @AuditTable(value = "audit_station_ship")
@Entity @Table @AllArgsConstructor @NoArgsConstructor @EqualsAndHashCode(callSuper = false) @Data
public class StationShip extends GenericEntity {
	private LocalDateTime dataHora;
	private int latitude;
	private int longitude;
	private String telegraphicCallsign;
//	private EnumEquipment equipment;
	private EnumTypeComission commission;
	private EnumTypeStation typeStation;
	private EnumMidia midia;
	private String name;
	private int day;
	private int month;
	private int year;
	private int marsdenSquare;
	private int marsdenSubSquare_1;
	private int marsdenSubSquare_5;
	private int wmoSquare;
	private String obs;
	private float collectionDepth;
	private float loadedInAlpha;
//	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
//	@JoinColumn(name = "manufacturer")
//	private Manufacturer manufacturer;
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
	@JoinColumn(name = "plataform")
	private Plataform plataform;
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
	@JoinColumn(name = "equipment")
	private Equipment equipment;

//	public LocalDate DATA_HORA;// DATE,
//            "LATITUDE" NUMBER(9,0),
//	"LONGITUDE" NUMBER(9,0),
//	"INDICATIVO_TELEGRAFICO" VARCHAR2(8 BYTE),
//	"COD_EQUIPAMENTO" NUMBER(10,0),
//	"COD_COMISSAO" NUMBER(10,0),
//	"COD_TIPO_ESTACAO" NUMBER(3,0),
//	"COD_MIDIA" NUMBER(10,0),
//	"NOME_ESTACAO" VARCHAR2(50 BYTE),
//	"DIA" NUMBER(4,0),
//	"MES" NUMBER(4,0),
//	"ANO" NUMBER(5,0),
//	"QUADRADO_MARSDEN" NUMBER(5,0),
//	"SUB_QUADRADO_MARSDEN_1" NUMBER(5,0),
//	"QUADRADO_WMO" NUMBER(5,0),
//	"SUB_QUADRADO_MARSDEN_5" NUMBER(5,0),
//	private String OBS;// VARCHAR2(255 BYTE),
//    private float PROFUNDIDADE_COLETA;// NUMBER(8,2),
//	"CARREGADO_ALPHA" NUMBER(1,0)
}