package br.eti.gadelha.persistence.model.observation;

import br.eti.gadelha.persistence.model.Country;
import br.eti.gadelha.persistence.model.GenericEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.envers.AuditTable;
import org.hibernate.envers.Audited;

import javax.persistence.*;

@Audited @AuditTable(value = "audit_plataform")
@Entity @Table @AllArgsConstructor @NoArgsConstructor @EqualsAndHashCode(callSuper = false) @Data
public class Platform extends GenericEntity {
	private String visualCallsign;
	private String telegraphicCallsign;
	private String internationalCallsign;
	private String name;
	private String internationalName;
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
	@JoinColumn(name = "country")
	private Country country;
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
	@JoinColumn(name = "platformCategory", nullable = false)
	private PlatformCategory platformCategory;
}