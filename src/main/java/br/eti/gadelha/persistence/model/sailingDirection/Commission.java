package br.eti.gadelha.persistence.model.sailingDirection;

import br.eti.gadelha.persistence.model.GenericEntity;
import br.eti.gadelha.persistence.model.Institution;
import br.eti.gadelha.persistence.model.Surveying;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import java.util.Date;

@Audited @Entity @Data @AllArgsConstructor @NoArgsConstructor @EqualsAndHashCode(callSuper = false)
public class Commission extends GenericEntity {
    private String name;
    private Date departure;
    private Date arrival;
    private float latitudeMostBottom;
    private float latitudeMostTop;
    private float longitudeMostRight;
    private float longitudeMostLeft;
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
    @JoinColumn(name = "origin"/*, nullable = true*/)
    private Harbor origin;
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
    @JoinColumn(name = "destination"/*, nullable = true*/)
    private Harbor destination;
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
    @JoinColumn(name = "responsible"/*, nullable = true*/)
    private Institution responsible;
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
    @JoinColumn(name = "coordinator"/*, nullable = true*/)
    private Institution coordinator;
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
    @JoinColumn(name = "surveying")
    private Surveying surveying;
}