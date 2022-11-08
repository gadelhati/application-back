package br.eti.gadelha.persistence.payload.response;

import br.eti.gadelha.persistence.model.synopticObservation.Observer;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.UUID;

@Getter @AllArgsConstructor
public class DTOResponseObserver {
    private UUID id;
    private String name;
    private String nip;

    public static DTOResponseObserver toDTO(Observer value) {
        return new DTOResponseObserver(value.getId(), value.getName(), value.getNip());
    }
}