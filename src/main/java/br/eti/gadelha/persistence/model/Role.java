package br.eti.gadelha.persistence.model;

import br.eti.gadelha.exception.enumeration.ERole;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.envers.Audited;

import javax.persistence.*;

@Audited @Entity @Table @Data @AllArgsConstructor @NoArgsConstructor @EqualsAndHashCode(callSuper = false)
public class Role extends GenericEntity {
//	@Enumerated(EnumType.STRING)
	private String name;
}