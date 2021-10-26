package br.eti.gadelha.persistence.model.sailingDirection;

import br.eti.gadelha.persistence.model.GenericEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.envers.AuditTable;
import org.hibernate.envers.Audited;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

/**
 * @author	Marcelo Ribeiro Gadelha
 * @mail	gadelha.ti@gmail.com
 * @link	www.gadelha.eti.br
 **/

@Audited @AuditTable(value = "audit_structure")
@Entity @Inheritance(strategy = InheritanceType.JOINED) @AllArgsConstructor @NoArgsConstructor @EqualsAndHashCode(callSuper = false) @Data
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