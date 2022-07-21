package br.eti.gadelha.persistence.dto.response;

import br.eti.gadelha.persistence.model.Country;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.UUID;

@Getter @AllArgsConstructor
public class DTOResponseCountry {

    private UUID id;
    private String name;

    public static DTOResponseCountry toDTO(Country value) {
        return new DTOResponseCountry(value.getId(), value.getName());
    }
}