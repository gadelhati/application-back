package br.eti.gadelha.persistence.payload.response;

import br.eti.gadelha.persistence.model.FederativeUnit;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.UUID;

@Getter @AllArgsConstructor
public class DTOResponseFederativeUnit {

    private UUID id;
    private String name;

    public static DTOResponseFederativeUnit toDTO(FederativeUnit value) {
        return new DTOResponseFederativeUnit(value.getId(), value.getName());
    }
}