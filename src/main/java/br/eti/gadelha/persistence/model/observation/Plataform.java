package br.eti.gadelha.persistence.model.observation;

import br.eti.gadelha.exception.enumeration.EnumTypePlatform;
import br.eti.gadelha.persistence.model.Country;
import br.eti.gadelha.persistence.model.GenericEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.envers.AuditTable;
import org.hibernate.envers.Audited;

import javax.persistence.Entity;
import javax.persistence.Table;

@Audited @AuditTable(value = "audit_plataform")
@Entity @Table @AllArgsConstructor @NoArgsConstructor @EqualsAndHashCode(callSuper = false) @Data
public class Plataform extends GenericEntity {
	private Country country;
	private EnumTypePlatform typePlatform;
	private String telegraphicCallsign;
	private String internationalCallsign;
	private String name;
	private String internationalName;
	private String visualCallsign;

//	private int COD_PAIS;// NUMBER(5,0),
//	private int COD_TIPO_PLATAFORMA;// NUMBER(3,0),
//	private String INDICATIVO_TELEGRAFICO;// VARCHAR2(8 BYTE),
//	private String INDICATIVO_INTERNACIONAL;// VARCHAR2(20 BYTE),
//	private String NOME_PLATAFORMA;// VARCHAR2(40 BYTE),
//	private String NOME_PLATAFORMA_INTERNACIONAL;// VARCHAR2(40 BYTE),
//	private String INDICATIVO_VISUAL;// VARCHAR2(6 BYTE)
}