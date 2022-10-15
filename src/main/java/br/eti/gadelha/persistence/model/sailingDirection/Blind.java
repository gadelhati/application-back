package br.eti.gadelha.persistence.model.sailingDirection;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.envers.Audited;

import javax.persistence.Entity;

@Audited @Entity @Data @AllArgsConstructor @NoArgsConstructor @EqualsAndHashCode(callSuper = false)
public class Blind extends Instalation {
    private String category;
}