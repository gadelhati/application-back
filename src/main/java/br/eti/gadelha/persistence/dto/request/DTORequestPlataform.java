package br.eti.gadelha.persistence.dto.request;

import br.eti.gadelha.exception.enumeration.EnumTypePlatform;
import br.eti.gadelha.persistence.model.Country;
import br.eti.gadelha.persistence.model.observation.Plataform;
import lombok.Getter;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author	Marcelo Ribeiro Gadelha
 * @mail	gadelha.ti@gmail.com
 * @link	www.gadelha.eti.br
 **/

@Getter
public class DTORequestPlataform {

    private Country country;
    private EnumTypePlatform typePlatform;
    private String telegraphicCallsign;
    private String internationalCallsign;
    @NotNull(message = "{name.not.null}") @NotBlank(message = "{name.not.blank}")
    @Enumerated(EnumType.STRING)
    private String name;
    private String internationalName;
    private String visualCallsign;

    public Plataform toObject(){
        return new Plataform(country, typePlatform, telegraphicCallsign, internationalCallsign, name, internationalName, visualCallsign);
    }
}