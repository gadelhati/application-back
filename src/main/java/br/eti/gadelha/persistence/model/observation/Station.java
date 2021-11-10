package br.eti.gadelha.persistence.model.observation;

import br.eti.gadelha.persistence.model.GenericEntity;

import java.time.LocalDate;

public class Station extends GenericEntity {
	public LocalDate DATA_HORA;// DATE,
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
	private String OBS;// VARCHAR2(255 BYTE),
    private float PROFUNDIDADE_COLETA;// NUMBER(8,2),
//	"CARREGADO_ALPHA" NUMBER(1,0)
}