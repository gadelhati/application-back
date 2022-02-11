package br.eti.gadelha.persistence.dto.request;

import br.eti.gadelha.exception.annotation.UniqueNameOM;
import br.eti.gadelha.persistence.model.OM;
import lombok.Getter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
public class DTORequestOM {

    @NotNull(message = "{name.not.null}") @NotBlank(message = "{name.not.blank}") @UniqueNameOM
    private String name;

    public OM toObject(){
        return new OM(name);
    }
}