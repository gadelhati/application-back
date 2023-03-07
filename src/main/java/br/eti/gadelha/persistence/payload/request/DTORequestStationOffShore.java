package br.eti.gadelha.persistence.payload.request;

import br.eti.gadelha.persistence.model.sailingDirection.Commission;
import br.eti.gadelha.persistence.model.synopticObservation.StationOffShore;
import lombok.Builder;
import lombok.Getter;

@Getter @Builder
public class DTORequestStationOffShore extends DTORequestStation {

    private String telegraphicCallsign;

    private Commission commission;

    public StationOffShore toObject(){
        return new StationOffShore(telegraphicCallsign, commission);
    }
}