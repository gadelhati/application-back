package br.eti.gadelha.persistence.payload.response;

import br.eti.gadelha.persistence.model.sailingDirection.Commission;
import br.eti.gadelha.persistence.model.synopticObservation.StationOffShore;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class DTOResponseStationShip extends DTOResponseStation {

    private double latitude;
    private double longitude;
    private String telegraphicCallsign;
    private int marsdenSquare_10;
    private int marsdenSubSquare_1;
    private int wmoSquare;
    private int marsdenSubSquare_5;

    private Commission commission;

    public DTOResponseStationShip(StationOffShore value) {
        super(value.getId(), value.getLocalDepth(), value.getStationCategory(), value.getEquipment(), value.getSurveying(), value.getResponsible(), value.getCountry());
        this.latitude = value.getLatitude();
        this.longitude = value.getLongitude();
        this.telegraphicCallsign = value.getTelegraphicCallsign();
        this.marsdenSquare_10 = value.getMarsdenSquare();
        this.marsdenSubSquare_1 = value.getMarsdenSubSquare_1();;
        this.wmoSquare = value.getWmoSquare();
        this.marsdenSubSquare_5 = value.getMarsdenSubSquare_5();
        this.commission = value.getCommission();
    }

    public static DTOResponseStationShip toDTO(StationOffShore value) {
        return new DTOResponseStationShip(value);
    }
}