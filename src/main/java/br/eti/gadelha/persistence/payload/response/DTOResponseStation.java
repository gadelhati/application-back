package br.eti.gadelha.persistence.payload.response;

import br.eti.gadelha.persistence.model.Country;
import br.eti.gadelha.persistence.model.Equipment;
import br.eti.gadelha.persistence.model.Institution;
import br.eti.gadelha.persistence.model.synopticObservation.StationCategory;
import br.eti.gadelha.persistence.model.Surveying;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.UUID;

@Getter @AllArgsConstructor
public class DTOResponseStation {

    private UUID id;
    private float localDepth;
    private StationCategory stationCategory;
    private Equipment equipment;
    private Surveying surveying;
    private Institution responsible;
    private Country country;
}