package br.eti.gadelha.persistence.model.sailingDirection;

import br.eti.gadelha.persistence.model.GenericEntity;
import br.eti.gadelha.persistence.model.unity.Institution;
import br.eti.gadelha.persistence.model.unity.Station;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.envers.Audited;

import javax.persistence.*;

@Audited @Entity @Table @Data @AllArgsConstructor @NoArgsConstructor @EqualsAndHashCode(callSuper = false)
public class Harbor extends GenericEntity {
    private String name;
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
    @JoinColumn(name = "institution", nullable = false)
    private Institution institution;
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
    @JoinColumn(name = "station", nullable = false)
    private Station station;
}