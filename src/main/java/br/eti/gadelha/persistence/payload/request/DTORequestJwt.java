package br.eti.gadelha.persistence.payload.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter @Setter
public class DTORequestJwt {

    @NotNull(message = "{name.not.null}") @NotBlank(message = "{name.not.blank}")
    private String username;
    @NotNull(message = "{password.not.null}") @NotBlank(message = "{password.not.blank}")
    private String password;
}