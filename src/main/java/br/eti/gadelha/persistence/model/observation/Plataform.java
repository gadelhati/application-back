package br.eti.gadelha.persistence.model.observation;

import br.eti.gadelha.persistence.model.GenericEntity;

public class Plataform extends GenericEntity {
	private int COD_PAIS;// NUMBER(5,0),
	private int COD_TIPO_PLATAFORMA;// NUMBER(3,0),
	private String INDICATIVO_TELEGRAFICO;// VARCHAR2(8 BYTE),
	private String INDICATIVO_INTERNACIONAL;// VARCHAR2(20 BYTE),
	private String NOME_PLATAFORMA;// VARCHAR2(40 BYTE),
	private String NOME_PLATAFORMA_INTERNACIONAL;// VARCHAR2(40 BYTE),
	private String INDICATIVO_VISUAL;// VARCHAR2(6 BYTE)
}