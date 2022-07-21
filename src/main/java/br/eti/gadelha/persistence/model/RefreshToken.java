package br.eti.gadelha.persistence.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.Instant;

import javax.persistence.*;

@Entity @Data @NoArgsConstructor @EqualsAndHashCode(callSuper=false)
public class RefreshToken extends GenericEntity {
  @OneToOne
  @JoinColumn(name = "user_id", referencedColumnName = "id")
  private User user;

  @Column(nullable = false, unique = true)
  private String token;

  @Column(nullable = false)
  private Instant expiryDate;
}