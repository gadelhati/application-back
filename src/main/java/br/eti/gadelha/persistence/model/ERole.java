package br.eti.gadelha.persistence.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author	Marcelo Ribeiro Gadelha
 * @mail	gadelha.ti@gmail.com
 * @since	03/10/2021
 * @version 1.0
 * @link	www.gadelha.eti.br
 **/

@Getter @AllArgsConstructor
public enum ERole {
  ROLE_USER("user"),
  ROLE_MODERATOR("moderator"),
  ROLE_ADMIN("admin"),
  ROLE_RECTIFIER("rectifier"),
  ROLE_OPERATOR("operator");

  private final String name;
}