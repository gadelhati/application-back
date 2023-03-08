package br.eti.gadelha.persistence.payload.request;

import lombok.Getter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
public class DTORequestStationCategory {

    @NotNull(message = "{name.not.null}") @NotBlank(message = "{name.not.blank}")
    private String name;
}