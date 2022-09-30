package br.eti.gadelha.persistence.dto.request;

import br.eti.gadelha.persistence.model.Country;
import br.eti.gadelha.persistence.model.sailingDirection.Commission;
import br.eti.gadelha.persistence.model.unity.*;
import lombok.Getter;

@Getter
public class DTORequestStation {

    private float localDepth;
    private String com;
    private Boolean active;
    private Commission commission;
    private StationCategory stationCategory;
    private Equipment equipment;
    private Surveying surveying;
    private Institution responsible;
    private Country country;

    public Station toObject(){
        return new Station(localDepth, com, active, commission, stationCategory, equipment, surveying, responsible, country);
    }
}