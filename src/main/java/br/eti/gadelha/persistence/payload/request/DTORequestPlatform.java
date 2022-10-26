package br.eti.gadelha.persistence.payload.request;

import br.eti.gadelha.exception.annotation.UniquePlatform;
import br.eti.gadelha.persistence.model.Country;
import br.eti.gadelha.persistence.model.synopticObservation.Platform;
import br.eti.gadelha.persistence.model.synopticObservation.PlatformCategory;
import lombok.Getter;

@Getter
public class DTORequestPlatform {

    @UniquePlatform
    private String visualCallsign;
    @UniquePlatform
    private String telegraphicCallsign;
    @UniquePlatform
    private String internationalCallsign;
    @UniquePlatform
    private String name;
    @UniquePlatform
    private String internationalName;
    private Country country;
    private PlatformCategory platformCategory;

    public Platform toObject(){
        return new Platform(visualCallsign, telegraphicCallsign, internationalCallsign, name, internationalName, country, platformCategory);
    }
}