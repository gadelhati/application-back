package br.eti.gadelha.persistence.model.synopticObservation;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import java.time.LocalDateTime;

@Audited @Entity @Data @AllArgsConstructor @NoArgsConstructor @EqualsAndHashCode(callSuper = false)
public class StationOnShore extends Station {

    private long number;
    private String name;
    private double latitude;
    private double longitude;
    private long altitude;
    private boolean status;
    private LocalDateTime activation;
    private LocalDateTime deactivation;
}