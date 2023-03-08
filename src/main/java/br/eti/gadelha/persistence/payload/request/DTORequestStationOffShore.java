package br.eti.gadelha.persistence.payload.request;

import br.eti.gadelha.persistence.model.sailingDirection.Commission;
import lombok.Builder;
import lombok.Getter;

@Getter @Builder
public class DTORequestStationOffShore extends DTORequestStation {

    private String telegraphicCallsign;

    private Commission commission;
}