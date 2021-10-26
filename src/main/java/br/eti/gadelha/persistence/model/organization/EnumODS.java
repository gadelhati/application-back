package br.eti.gadelha.persistence.model.organization;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author	Marcelo Ribeiro Gadelha
 * @mail	gadelha.ti@gmail.com
 * @link	www.gadelha.eti.br
 **/

@Getter @AllArgsConstructor
public enum EnumODS {
    COMANDO_DE_OPERAÇÕES_NAVAIS ("ComOpNav"),
    SECRETARIA_GERAL_DA_MARINHA ("SGM"),
    DIRETORIA_GERAL_DO_MATERIAL_DA_MARINHA ("DGMM"),
    DIRETORIA_GERAL_DO_PESSOAL_DA_MARINHA ("DGPM"),
    DIRETORIA_GERAL_DE_DESENVOLVIMENTO_NUCLEAR_E_TECNOLOGICO_DA_MARINHA ("DGDNTM"),
    DIRETORIA_GERAL_DE_NAVEGACAO ("DGN"),
    COMANDO_GERAL_DO_CORPO_DE_FUZILEIROS_NAVIAS ("CGCFN");

    private final String ODS;
}