package br.eti.gadelha.persistence.payload.response;

import br.eti.gadelha.persistence.model.Country;
import br.eti.gadelha.persistence.model.synopticObservation.Platform;
import br.eti.gadelha.persistence.model.synopticObservation.PlatformCategory;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.UUID;

@Getter @AllArgsConstructor
public class DTOResponsePlatform {

    private UUID id;
    private String visualCallsign;
    private String telegraphicCallsign;
    private String internationalCallsign;
    private String name;
    private String internationalName;
    private Country country;
    private PlatformCategory platformCategory;
}