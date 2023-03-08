package br.eti.gadelha.persistence.payload.response;

import br.eti.gadelha.persistence.model.Country;
import br.eti.gadelha.persistence.model.Equipment;
import br.eti.gadelha.persistence.model.Institution;
import br.eti.gadelha.persistence.model.Surveying;
import br.eti.gadelha.persistence.model.sailingDirection.Commission;
import br.eti.gadelha.persistence.model.synopticObservation.Platform;
import br.eti.gadelha.persistence.model.synopticObservation.StationCategory;
import br.eti.gadelha.persistence.model.synopticObservation.StationOnShore;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
public class DTOResponseStationOnShore extends DTOResponseStation {

    private long number;
    private String name;
    private double latitude;
    private double longitude;
    private long altitude;
    private boolean status;
    private LocalDateTime activation;
    private LocalDateTime deactivation;

    public DTOResponseStationOnShore(StationOnShore value) {
        super(value.getId(), value.getLocalDepth(), value.getStationCategory(), value.getEquipment(), value.getSurveying(), value.getResponsible(), value.getCountry());
        this.number = value.getNumber();
        this.name = value.getName();
        this.latitude = value.getLatitude();
        this.longitude = value.getLongitude();
        this.altitude = value.getAltitude();
        this.status = value.isStatus();
        this.activation = value.getActivation();
        this.deactivation = value.getDeactivation();
    }
}