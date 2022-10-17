package br.eti.gadelha.persistence.model.synopticObservation;

import br.eti.gadelha.persistence.model.GenericEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import java.util.Date;

@Audited @Entity @Data @AllArgsConstructor @NoArgsConstructor
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