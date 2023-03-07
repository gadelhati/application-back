package br.eti.gadelha.persistence.model.synopticObservation;

import br.eti.gadelha.persistence.model.sailingDirection.Commission;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import java.time.LocalDateTime;

@Audited @Entity @Data @AllArgsConstructor @NoArgsConstructor @EqualsAndHashCode(callSuper = false)
public class StationShip extends Station {

    private LocalDateTime dateTime;
    private double latitude;
    private double longitude;
    private String telegraphicCallsign;
    private int marsdenSquare;
    private int marsdenSubSquare_1;
    private int wmoSquare;
    private int marsdenSubSquare_5;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
    @JoinColumn(name = "commission")
    private Commission commission;
}