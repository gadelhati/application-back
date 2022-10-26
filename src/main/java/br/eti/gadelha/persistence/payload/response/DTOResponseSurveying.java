package br.eti.gadelha.persistence.payload.response;

import br.eti.gadelha.persistence.model.Surveying;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.UUID;

@Getter @AllArgsConstructor
public class DTOResponseSurveying {

    private UUID id;
    private String name;

    public static DTOResponseSurveying toDTO(Surveying value) {
        return new DTOResponseSurveying(value.getId(), value.getName());
    }
}