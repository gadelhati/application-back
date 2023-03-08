package br.eti.gadelha.persistence.payload.request;

import br.eti.gadelha.exception.annotation.UniqueOM;
import lombok.Getter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
public class DTORequestOM {

    @NotNull(message = "{name.not.null}") @NotBlank(message = "{name.not.blank}")  @UniqueOM
    private String name;
}