package br.eti.gadelha.persistence.model.observation;

import br.eti.gadelha.persistence.model.GenericEntity;
import br.eti.gadelha.persistence.model.observation.Component;
import br.eti.gadelha.persistence.model.observation.Institution;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.envers.AuditTable;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import java.util.Date;

/**
 * @author	Marcelo Ribeiro Gadelha
 * @link	www.gadelha.eti.br
 **/

@Audited @AuditTable(value = "audit_harmonic_constant")
@Entity @Table @AllArgsConstructor @NoArgsConstructor @EqualsAndHashCode(callSuper = false) @Data
public class HarmonicConstant extends GenericEntity {
    private Date starts;
    private Date ending;
    private String g;
    private String h;
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
    @JoinColumn(name = "component"/*, nullable = true*/)
    private Component component;
//    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
//    @JoinColumn(name = "component"/*, nullable = true*/)
//    private Station station;
}