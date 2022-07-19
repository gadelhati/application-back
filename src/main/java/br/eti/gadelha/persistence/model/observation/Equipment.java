package br.eti.gadelha.persistence.model.observation;

import br.eti.gadelha.persistence.model.observation.Manufacturer;
import br.eti.gadelha.persistence.model.GenericEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.envers.AuditTable;
import org.hibernate.envers.Audited;

import javax.persistence.*;

/**
 * @author	Marcelo Ribeiro Gadelha
 * @mail	marcelo.gadelha@marinha.mil.br
 * @link	www.gadelha.eti.br
 **/

@Audited @AuditTable(value = "audit_equipment")
@Entity @Table
@AllArgsConstructor @NoArgsConstructor @Data @EqualsAndHashCode(callSuper = false)
public class Equipment extends GenericEntity {

    private String name;
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
    @JoinColumn(name = "manufacturer")
    private Manufacturer manufacturer;
}