package br.eti.gadelha.persistence.payload.response;

import br.eti.gadelha.persistence.model.Institution;
import br.eti.gadelha.persistence.model.synopticObservation.Station;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.UUID;

@Getter @AllArgsConstructor
public class DTOResponseHarbor {
    private UUID id;
    private String name;
    private Institution institution;

    private Station station;
}