package br.eti.gadelha.persistence.payload.request;

import br.eti.gadelha.persistence.model.*;
import br.eti.gadelha.persistence.model.synopticObservation.StationCategory;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class DTORequestStation {

    private float localDepth;
    private LocalDateTime activation;
    private double latitude;
    private double longitude;
    private int marsdenSquare;
    private int marsdenSubSquare_1;
    private int wmoSquare;
    private int marsdenSubSquare_5;

    private StationCategory stationCategory;
    private Equipment equipment;
    private Surveying surveying;
    private Institution responsible;
    private Country country;
}