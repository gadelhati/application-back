package br.eti.gadelha.persistence.model.synoptic;

import br.eti.gadelha.persistence.model.FederativeUnit;
import br.eti.gadelha.persistence.model.GenericEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.envers.Audited;

import javax.persistence.*;

@Audited @Entity @Table @Data @AllArgsConstructor @NoArgsConstructor @EqualsAndHashCode(callSuper = false)
public class SurfaceWeatherStation extends GenericEntity {

    private int number;
    private String name;
    private String latitude;
    private String longitude;
    private double altitude;
    private boolean active;
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
    @JoinColumn(name = "federativeUnit")
    private FederativeUnit federativeUnit;
}