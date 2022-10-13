package br.eti.gadelha.persistence.payload.response;

import br.eti.gadelha.persistence.model.unity.Observer;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.UUID;

@Getter @AllArgsConstructor
public class DTOResponseObserver {
    private UUID id;
    private String name;

    public static DTOResponseObserver toDTO(Observer value) {
        return new DTOResponseObserver(value.getId(), value.getName());
    }
}