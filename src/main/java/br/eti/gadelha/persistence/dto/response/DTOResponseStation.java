package br.eti.gadelha.persistence.dto.response;

import br.eti.gadelha.persistence.model.Country;
import br.eti.gadelha.persistence.model.unity.Station;
import br.eti.gadelha.persistence.model.sailingDirection.Commission;
import br.eti.gadelha.persistence.model.unity.Equipment;
import br.eti.gadelha.persistence.model.unity.Institution;
import br.eti.gadelha.persistence.model.unity.StationCategory;
import br.eti.gadelha.persistence.model.unity.Surveying;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.UUID;

@Getter @AllArgsConstructor
public class DTOResponseStation {

    private UUID id;
    private float localDepth;
    private String com;
    private Boolean active;
    private Commission commission;
    private StationCategory stationCategory;
    private Equipment equipment;
    private Surveying surveying;
    private Institution responsible;
    private Country country;

    public static DTOResponseStation toDTO(Station value) {
        return new DTOResponseStation(value.getId(), value.getLocalDepth(), value.getCom(), value.getActive(), value.getCommission(), value.getStationCategory(), value.getEquipment(), value.getSurveying(), value.getResponsible(), value.getCountry());
    }
}