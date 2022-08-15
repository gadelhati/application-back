package br.eti.gadelha.persistence.dto.response;

import br.eti.gadelha.persistence.model.Researcher;
import br.eti.gadelha.persistence.model.unity.Manufacturer;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.UUID;

@Getter @AllArgsConstructor
public class DTOResponseManufacturer {
    private UUID id;
    private String name;

    public static DTOResponseManufacturer toDTO(Manufacturer value) {
        return new DTOResponseManufacturer(value.getId(), value.getName());
    }
}