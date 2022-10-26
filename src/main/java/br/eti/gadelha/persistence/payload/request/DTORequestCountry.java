package br.eti.gadelha.persistence.payload.request;

import br.eti.gadelha.exception.annotation.UniqueCountry;
import br.eti.gadelha.persistence.model.Country;
import lombok.Getter;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
public class DTORequestCountry {

    @NotNull(message = "{name.not.null}") @NotBlank(message = "{name.not.blank}") @UniqueCountry
    @Enumerated(EnumType.STRING)
    private String name;

    public Country toObject(){
        return new Country(name);
    }
}