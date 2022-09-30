package br.eti.gadelha.persistence.dto.response;

import br.eti.gadelha.persistence.model.unity.*;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class DTOResponseStationOffShore extends DTOResponseStation {

    private LocalDateTime first;
    private LocalDateTime last;
    private double latitudeMostBottom;
    private double latitudeMostTop;
    private double longitudeMostRight;
    private double longitudeMostLeft;
    private Platform platform;

    public DTOResponseStationOffShore(StationOffShore value) {
        super(value.getId(), value.getLocalDepth(), value.getCom(), value.getActive(), value.getCommission(), value.getStationCategory(), value.getEquipment(), value.getSurveying(), value.getResponsible(), value.getCountry());
        this.first = value.getFirst();
        this.last = value.getLast();
        this.latitudeMostBottom = value.getLatitudeMostBottom();
        this.latitudeMostTop = value.getLatitudeMostTop();
        this.longitudeMostRight = value.getLongitudeMostRight();
        this.longitudeMostLeft = value.getLongitudeMostLeft();;
        this.platform = value.getPlatform();
    }

    public static DTOResponseStationOffShore toDTO(StationOffShore value) {
        return new DTOResponseStationOffShore(value);
    }
}