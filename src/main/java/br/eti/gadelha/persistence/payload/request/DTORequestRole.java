package br.eti.gadelha.persistence.payload.request;

import br.eti.gadelha.exception.annotation.auth.UniqueNameRole;
import br.eti.gadelha.persistence.model.Role;
import lombok.Getter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
public class DTORequestRole {

    @NotNull(message = "{name.not.null}") @NotBlank(message = "{name.not.blank}") @UniqueNameRole
//    @Enumerated(EnumType.STRING)
    private String name;

    public Role toObject(){
        return new Role(name);
    }
}