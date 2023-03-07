package br.eti.gadelha.persistence.payload.request;

import br.eti.gadelha.persistence.model.synopticObservation.Platform;
import br.eti.gadelha.persistence.model.synopticObservation.StationOnShore;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter @Builder
public class DTORequestStationOnShore extends DTORequestStation {

    private long number;
    private String name;
    private double latitude;
    private double longitude;
    private long altitude;
    private boolean status;
    private LocalDateTime activation;
    private LocalDateTime deactivation;

    public StationOnShore toObject(){
        return new StationOnShore(number, name, latitude, longitude, altitude, status, activation, deactivation);
    }
}