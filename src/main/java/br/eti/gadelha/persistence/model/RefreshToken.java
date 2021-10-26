package br.eti.gadelha.persistence.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

import javax.persistence.*;

/**
 * @author	Marcelo Ribeiro Gadelha
 * @mail	gadelha.ti@gmail.com
 * @since	03/10/2021
 * @version 1.0
 * @link	www.gadelha.eti.br
 **/

@Entity(name = "refreshtoken") @Data @NoArgsConstructor
public class RefreshToken extends GenericEntity {
  @OneToOne
  @JoinColumn(name = "user_id", referencedColumnName = "id")
  private User user;

  @Column(nullable = false, unique = true)
  private String token;

  @Column(nullable = false)
  private Instant expiryDate;
}