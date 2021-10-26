package br.eti.gadelha.persistence.model;

import br.eti.gadelha.exception.annotation.UniqueRoleName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.envers.AuditTable;
import org.hibernate.envers.Audited;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author	Marcelo Ribeiro Gadelha
 * @mail	marcelo.gadelha@marinha.mil.br
 * @link	www.gadelha.eti.br
 **/

@Audited @AuditTable(value = "abiliity_auditoria")
@Entity @Table
@AllArgsConstructor @NoArgsConstructor @EqualsAndHashCode(callSuper = false) @Data
public class Abiliity extends GenericEntity {

    @NotNull(message = "{name.not.null}") @NotBlank(message = "{name.not.blank}") @UniqueRoleName
    private String name;
    @NotNull(message = "{name.not.null}") @NotBlank(message = "{name.not.blank}")
    private String description;
}