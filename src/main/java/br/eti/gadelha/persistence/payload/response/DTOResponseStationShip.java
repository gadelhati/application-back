package br.eti.gadelha.persistence.payload.response;

import br.eti.gadelha.persistence.model.sailingDirection.Commission;
import br.eti.gadelha.persistence.model.synopticObservation.StationShip;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class DTOResponseStationShip extends DTOResponseStation {

//    private String name;
    private LocalDateTime dateTime;
    private double latitude;
    private double longitude;
    private String telegraphicCallsign;
    private int marsdenSquare_10;
    private int marsdenSubSquare_1;
    private int wmoSquare;
    private int marsdenSubSquare_5;
//    private float collectionDepth;
    private Commission commission;//ship

    public DTOResponseStationShip(StationShip value) {
        super(value.getId(), value.getLocalDepth(), value.getCom(), value.getActive(), value.getCommission(), value.getStationCategory(), value.getEquipment(), value.getSurveying(), value.getResponsible(), value.getCountry());
//        this.name = value.getName();
        this.dateTime = value.getDateTime();
        this.latitude = value.getLatitude();
        this.longitude = value.getLongitude();
        this.telegraphicCallsign = value.getTelegraphicCallsign();
        this.marsdenSquare_10 = value.getMarsdenSquare();
        this.marsdenSubSquare_1 = value.getMarsdenSubSquare_1();;
        this.wmoSquare = value.getWmoSquare();
        this.marsdenSubSquare_5 = value.getMarsdenSubSquare_5();
//        this.collectionDepth = value.getCollectionDepth();
        this.commission = value.getCommission();
    }

    public static DTOResponseStationShip toDTO(StationShip value) {
        return new DTOResponseStationShip(value);
    }
}