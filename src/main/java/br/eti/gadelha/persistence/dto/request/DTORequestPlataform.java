package br.eti.gadelha.persistence.dto.request;

import br.eti.gadelha.persistence.model.Country;
import br.eti.gadelha.persistence.model.observation.Platform;
import br.eti.gadelha.persistence.model.observation.PlatformCategory;
import lombok.Getter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author	Marcelo Ribeiro Gadelha
 * @mail	gadelha.ti@gmail.com
 * @link	www.gadelha.eti.br
 **/

@Getter
public class DTORequestPlataform {

    private String visualCallsign;
    private String telegraphicCallsign;
    private String internationalCallsign;
    @NotNull(message = "{name.not.null}") @NotBlank(message = "{name.not.blank}")
    @Enumerated(EnumType.STRING)
    private String name;
    private String internationalName;
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
    @JoinColumn(name = "country")
    private Country country;
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
    @JoinColumn(name = "platformCategory", nullable = false)
    private PlatformCategory platformCategory;

    public Platform toObject(){
        return new Platform(visualCallsign, telegraphicCallsign, internationalCallsign, name, internationalName, country, platformCategory);
    }
}