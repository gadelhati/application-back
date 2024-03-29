package br.eti.gadelha.persistence.payload.request;

import br.eti.gadelha.exception.annotation.UniqueManufacturer;
import lombok.Getter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
public class DTORequestManufacturer {

    @NotNull(message = "{name.not.null}") @NotBlank(message = "{name.not.blank}") @UniqueManufacturer
    private String name;
}