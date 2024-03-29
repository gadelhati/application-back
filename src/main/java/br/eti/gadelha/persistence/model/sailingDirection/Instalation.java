package br.eti.gadelha.persistence.model.sailingDirection;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.envers.Audited;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Audited @Entity @Data @AllArgsConstructor @NoArgsConstructor @EqualsAndHashCode(callSuper = false)
@PrimaryKeyJoinColumn(name="id")
public class Instalation extends Structure {
    private String orderNumber;
    private Maintainer maintainer;
}