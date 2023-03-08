package br.eti.gadelha.persistence.payload.request;

import br.eti.gadelha.exception.annotation.UniqueManufacturer;
import br.eti.gadelha.persistence.model.Country;
import lombok.Getter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
public class DTORequestFederativeUnit {

    @NotNull(message = "{name.not.null}") @NotBlank(message = "{name.not.blank}") @UniqueManufacturer
    private String name;
    @NotNull
    private String initials;
    private Country country;
}