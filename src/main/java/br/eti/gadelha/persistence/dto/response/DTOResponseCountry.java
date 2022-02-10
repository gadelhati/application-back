package br.eti.gadelha.persistence.dto.response;

import br.eti.gadelha.persistence.model.Country;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.UUID;

/**
 * @author	Marcelo Ribeiro Gadelha
 * @mail	gadelha.ti@gmail.com
 * @link	www.gadelha.eti.br
 **/

@Getter @AllArgsConstructor
public class DTOResponseCountry {

    private UUID id;
    private String name;

    public static DTOResponseCountry toDTO(Country value) {
        return new DTOResponseCountry(value.getId(), value.getName());
    }
}