package br.eti.gadelha.persistence.payload.request;

import br.eti.gadelha.persistence.model.Country;
import br.eti.gadelha.persistence.model.unity.Platform;
import br.eti.gadelha.persistence.model.unity.PlatformCategory;
import lombok.Getter;

@Getter
public class DTORequestPlatform {

    private String visualCallsign;
    private String telegraphicCallsign;
    private String internationalCallsign;
    private String name;
    private String internationalName;
    private Country country;
    private PlatformCategory platformCategory;

    public Platform toObject(){
        return new Platform(visualCallsign, telegraphicCallsign, internationalCallsign, name, internationalName, country, platformCategory);
    }
}