package br.eti.gadelha.persistence.model.sailingDirection;

import br.eti.gadelha.persistence.model.GenericEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.envers.Audited;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Audited @Entity @Data @AllArgsConstructor @NoArgsConstructor @EqualsAndHashCode(callSuper = false)
@Inheritance(strategy = InheritanceType.JOINED)
public class Structure extends GenericEntity {
    private float altitude;
    private float height;
    private float calado;//sem tradução conhecida
    private float circuloDeGiro;//sem tradução conhecida
    private String color;
    private String buildingMaterial;
    private String name;
    private String number;
    private boolean placaDeVisibilidade;//sem tradução conhecida
    private boolean refletorRadar;//sem tradução conhecida
    private boolean visivelmenteConspicuo;//sem tradução conhecida
    private EnumFormat format;
    private Radar radar;
}