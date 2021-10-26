package br.eti.gadelha.persistence.model.organization;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author	Marcelo Ribeiro Gadelha
 * @mail	gadelha.ti@gmail.com
 * @link	www.gadelha.eti.br
 **/

@Getter @AllArgsConstructor
public enum EnumODG {
    ESTADO_MAIOR_DA_ARMADA ("EMA");

    private final String ODG;
}