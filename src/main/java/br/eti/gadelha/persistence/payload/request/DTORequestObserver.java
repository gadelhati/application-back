package br.eti.gadelha.persistence.payload.request;

import br.eti.gadelha.exception.annotation.UniqueObserver;
import br.eti.gadelha.persistence.model.synopticObservation.Observer;
import lombok.Getter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
public class DTORequestObserver {

    @NotNull(message = "{name.not.null}") @NotBlank(message = "{name.not.blank}") @UniqueObserver
    private String name;

    public Observer toObject(){
        return new Observer(name);
    }
}