package br.eti.gadelha.persistence.payload.request;

import br.eti.gadelha.exception.annotation.UniqueSurveying;
import lombok.Getter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
public class DTORequestSurveying {

    @NotNull(message = "{name.not.null}") @NotBlank(message = "{name.not.blank}")  @UniqueSurveying
    private String name;
}