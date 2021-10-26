package br.eti.gadelha.persistence.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author	Marcelo Ribeiro Gadelha
 * @mail	gadelha.ti@gmail.com
 * @link	www.gadelha.eti.br
 **/

@Getter @AllArgsConstructor
public enum Gender {
    MALE("Male"),
    FEMALE("Female");

    String gender;
}