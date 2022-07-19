package br.eti.gadelha.persistence.dto.request;

import br.eti.gadelha.exception.enumeration.EnumTypePlatform;
import br.eti.gadelha.persistence.model.Country;
import br.eti.gadelha.persistence.model.observation.Plataform;
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

    private String /*EnumTypePlatform*/ typePlatform;
    private String telegraphicCallsign;
    private String internationalCallsign;
    @NotNull(message = "{name.not.null}") @NotBlank(message = "{name.not.blank}")
    @Enumerated(EnumType.STRING)
    private String name;
    private String internationalName;
    private String visualCallsign;
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
    @JoinColumn(name = "country")
    private Country country;

    public Plataform toObject(){
        return new Plataform(typePlatform, telegraphicCallsign, internationalCallsign, name, internationalName, visualCallsign, country);
    }
}