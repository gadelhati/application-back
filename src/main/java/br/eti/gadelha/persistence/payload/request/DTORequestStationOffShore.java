package br.eti.gadelha.persistence.payload.request;

import br.eti.gadelha.persistence.model.sailingDirection.Commission;
import br.eti.gadelha.persistence.model.synopticObservation.StationOffShore;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter @Builder
public class DTORequestStationOffShore extends DTORequestStation {

    private LocalDateTime dateTime;
    private double latitude;
    private double longitude;
    private String telegraphicCallsign;
    private int marsdenSquare_10;
    private int marsdenSubSquare_1;
    private int wmoSquare;
    private int marsdenSubSquare_5;

    private Commission commission;

    public StationOffShore toObject(){
        return new StationOffShore(dateTime, latitude, longitude, telegraphicCallsign, marsdenSquare_10, marsdenSubSquare_1, wmoSquare, marsdenSubSquare_5, commission);
    }
}