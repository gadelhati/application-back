package br.eti.gadelha.persistence.payload.response;

import br.eti.gadelha.persistence.model.unity.PlatformCategory;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.UUID;

@Getter @AllArgsConstructor
public class DTOResponsePlatformCategory {
    private UUID id;
    private String name;

    public static DTOResponsePlatformCategory toDTO(PlatformCategory value) {
        return new DTOResponsePlatformCategory(value.getId(), value.getName());
    }
}