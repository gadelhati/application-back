package br.eti.gadelha.persistence.model.support;

import br.eti.gadelha.persistence.model.GenericEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.envers.AuditTable;
import org.hibernate.envers.Audited;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author	Marcelo Ribeiro Gadelha
 * @mail	gadelha.ti@gmail.com
 * @link	www.gadelha.eti.br
 **/

@Audited @AuditTable(value = "seal_auditoria")
@Entity @Table @AllArgsConstructor @NoArgsConstructor @EqualsAndHashCode(callSuper = false) @Data
public class Seal extends GenericEntity {

    @Column
    private String number;
    @Column
    private String color;
    @Column
    private boolean broken;
}