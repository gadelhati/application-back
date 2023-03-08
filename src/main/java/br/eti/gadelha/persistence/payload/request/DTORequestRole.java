package br.eti.gadelha.persistence.payload.request;

import br.eti.gadelha.exception.annotation.auth.UniqueNameRole;
import lombok.Getter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
public class DTORequestRole {

    @NotNull(message = "{name.not.null}") @NotBlank(message = "{name.not.blank}") @UniqueNameRole
    private String name;
}