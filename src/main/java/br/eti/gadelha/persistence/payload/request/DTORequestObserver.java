package br.eti.gadelha.persistence.payload.request;

import br.eti.gadelha.exception.annotation.UniqueObserverName;
import br.eti.gadelha.exception.annotation.UniqueObserverNip;
import lombok.Getter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.UUID;

@Getter @UniqueObserverName @UniqueObserverNip
public class DTORequestObserver {

    private UUID id;
    @NotNull(message = "{name.not.null}") @NotBlank(message = "{name.not.blank}")
    private String name;
    @Pattern(regexp = "[0-9]{8}", message = "{nip.valid}") @NotNull(message = "{nip.not.null}") @NotBlank(message = "{nip.not.blank}")
    private String nip;
}