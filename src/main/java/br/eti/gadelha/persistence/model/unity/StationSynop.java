package br.eti.gadelha.persistence.model.unity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.envers.Audited;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Audited @Entity @Table @Data @AllArgsConstructor @NoArgsConstructor @EqualsAndHashCode(callSuper = false)
public class StationSynop extends Station {

    private LocalDateTime dateTime;
    private double latitude;
    private double longitude;
    private String telegraphicCallsign;
    private int marsdenSquare_10;
    private int marsdenSubSquare_1;
    private int wmoSquare;
    private int marsdenSubSquare_5;
    private float collectionDepth;
}