package br.eti.gadelha.persistence.payload.request;

import br.eti.gadelha.exception.annotation.UniquePlatformCategory;
import br.eti.gadelha.persistence.model.synopticObservation.PlatformCategory;
import lombok.Getter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
public class DTORequestPlatformCategory {

    @NotNull(message = "{name.not.null}") @NotBlank(message = "{name.not.blank}") @UniquePlatformCategory
    private String name;

    public PlatformCategory toObject(){
        return new PlatformCategory(name);
    }
}