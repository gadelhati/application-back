package br.eti.gadelha.persistence.payload.request;

import br.eti.gadelha.persistence.model.*;
import br.eti.gadelha.persistence.model.sailingDirection.Commission;
import br.eti.gadelha.persistence.model.synopticObservation.Station;
import br.eti.gadelha.persistence.model.synopticObservation.StationCategory;
import lombok.Getter;

@Getter
public class DTORequestStation {

    private float localDepth;
    private StationCategory stationCategory;
    private Equipment equipment;
    private Surveying surveying;
    private Institution responsible;
    private Country country;

    public Station toObject(){
        return new Station(localDepth, stationCategory, equipment, surveying, responsible, country);
    }
}