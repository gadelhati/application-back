package br.eti.gadelha.exception.enumeration;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author	Marcelo Ribeiro Gadelha
 * @mail	gadelha.ti@gmail.com
 * @link	www.gadelha.eti.br
 **/

@Getter @AllArgsConstructor
public enum EnumTypeStation {
    SHIP("Ship"),
    SYNOP("Synop");

    private final String type;
}