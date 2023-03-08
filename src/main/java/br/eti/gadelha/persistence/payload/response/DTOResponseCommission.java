package br.eti.gadelha.persistence.payload.response;

import br.eti.gadelha.persistence.model.Institution;
import br.eti.gadelha.persistence.model.Surveying;
import br.eti.gadelha.persistence.model.sailingDirection.Harbor;
import br.eti.gadelha.persistence.model.synopticObservation.Platform;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Date;
import java.util.UUID;

@Getter @AllArgsConstructor
public class DTOResponseCommission {

    private String name;
    private Date departure;
    private Date arrival;
    private float latitudeMostBottom;
    private float latitudeMostTop;
    private float longitudeMostRight;
    private float longitudeMostLeft;
    private Harbor origin;
    private Harbor destination;
    private Institution responsible;
    private Institution coordinator;
    private Surveying surveying;
    private Platform platform;
}