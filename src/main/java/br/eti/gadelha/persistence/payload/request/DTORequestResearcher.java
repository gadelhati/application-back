package br.eti.gadelha.persistence.payload.request;

import br.eti.gadelha.exception.annotation.UniqueResearcher;
import lombok.Getter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
public class DTORequestResearcher {

    @NotNull(message = "{name.not.null}") @NotBlank(message = "{name.not.blank}") @UniqueResearcher
    private String name;
    @NotNull(message = "{email.not.null}") @NotBlank(message = "{email.not.blank}") @Email
    private String email;
    private String address;
}