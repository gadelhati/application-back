package br.eti.gadelha.persistence.payload.request;

import br.eti.gadelha.exception.annotation.UniqueObserver;
import br.eti.gadelha.exception.annotation.UniqueObserverNip;
import br.eti.gadelha.persistence.model.synopticObservation.Observer;
import lombok.Getter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Getter
public class DTORequestObserver {

    @NotNull(message = "{name.not.null}") @NotBlank(message = "{name.not.blank}") @UniqueObserver
    private String name;
    @Pattern(regexp = "[0-9]{8}", message = "{nip.valid}") @NotNull(message = "{nip.not.null}") @NotBlank(message = "{nip.not.blank}") @UniqueObserverNip
    private String nip;

    public Observer toObject(){
        return new Observer(name, nip);
    }
}