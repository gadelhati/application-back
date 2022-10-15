package br.eti.gadelha.persistence.model.sailingDirection;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.envers.Audited;

import javax.persistence.Entity;

@Audited @Entity @Data @AllArgsConstructor @NoArgsConstructor @EqualsAndHashCode(callSuper = false)
public class Lighthouse extends Instalation {
    private float intenationalNumber;
    private boolean garnished;
    private String description;
}