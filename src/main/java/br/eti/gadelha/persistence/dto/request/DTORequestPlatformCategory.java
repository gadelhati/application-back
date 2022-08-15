package br.eti.gadelha.persistence.dto.request;

import br.eti.gadelha.persistence.model.unity.PlatformCategory;
import lombok.Getter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
public class DTORequestPlatformCategory {

    @NotNull(message = "{name.not.null}") @NotBlank(message = "{name.not.blank}")
    private String name;

    public PlatformCategory toObject(){
        return new PlatformCategory(name);
    }
}