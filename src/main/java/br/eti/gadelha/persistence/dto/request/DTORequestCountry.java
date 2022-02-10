package br.eti.gadelha.persistence.dto.request;

import br.eti.gadelha.persistence.model.Country;
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
public class DTORequestCountry {

    @NotNull(message = "{name.not.null}") @NotBlank(message = "{name.not.blank}")
    @Enumerated(EnumType.STRING)
    private String name;

    public Country toObject(){
        return new Country(name);
    }
}