package br.eti.gadelha.persistence.model;

import br.eti.gadelha.exception.enumeration.ERole;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.envers.AuditTable;
import org.hibernate.envers.Audited;

import javax.persistence.*;

/**
 * @author	Marcelo Ribeiro Gadelha
 * @mail	gadelha.ti@gmail.com
 * @since	03/10/2021
 * @version 1.0
 * @link	www.gadelha.eti.br
 **/

@Audited @AuditTable(value = "audit_role")
@Entity @Data @NoArgsConstructor @AllArgsConstructor @EqualsAndHashCode(callSuper = false)
@Table(name = "role")
public class Role extends GenericEntity {
	@Enumerated(EnumType.STRING)
	private ERole name;
}