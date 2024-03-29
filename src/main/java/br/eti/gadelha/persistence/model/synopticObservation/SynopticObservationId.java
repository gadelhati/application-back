package br.eti.gadelha.persistence.model.synopticObservation;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

@AllArgsConstructor @NoArgsConstructor @EqualsAndHashCode
public class SynopticObservationId implements Serializable {

    private LocalDateTime dateObservation;
    private String ddddddd;
}
