package br.eti.gadelha.persistence.model.sailingDirection;

import br.eti.gadelha.persistence.model.GenericEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.envers.AuditTable;
import org.hibernate.envers.Audited;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author	Marcelo Ribeiro Gadelha
 * @mail	gadelha.ti@gmail.com
 * @link	www.gadelha.eti.br
 **/

@Audited @AuditTable(value = "audit_radar")
@Entity @Table @AllArgsConstructor @NoArgsConstructor @EqualsAndHashCode(callSuper = false) @Data
public class Radar extends GenericEntity {
    private String morse;
    private Structure structure;
}