package br.eti.gadelha.persistence.model.sailingDirection;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author	Marcelo Ribeiro Gadelha
 * @mail	gadelha.ti@gmail.com
 * @link	www.gadelha.eti.br
 **/

@Getter @AllArgsConstructor
public enum EnumFormat {
    ESFERICO("esférico"),
    PILAR("pilar"),
    CHARUTO("charuto");

    private final String nome;
}