package br.eti.gadelha.persistence.dto.response;

import br.eti.gadelha.persistence.model.Country;
import br.eti.gadelha.persistence.model.unity.Platform;
import br.eti.gadelha.persistence.model.unity.PlatformCategory;
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

    public static DTOResponsePlatform toDTO(Platform value) {
        return new DTOResponsePlatform(value.getId(), value.getVisualCallsign(), value.getTelegraphicCallsign(), value.getInternationalCallsign(), value.getName(), value.getInternationalName(), value.getCountry(), value.getPlatformCategory());
    }
}