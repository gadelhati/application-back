package br.eti.gadelha.persistence.dto.request;

import br.eti.gadelha.exception.annotation.UniqueUserName;
import br.eti.gadelha.exception.enumeration.ERole;
import br.eti.gadelha.persistence.model.Role;
import lombok.Getter;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
public class DTORequestRole {

    @NotNull(message = "{name.not.null}") @NotBlank(message = "{name.not.blank}") @UniqueUserName
    @Enumerated(EnumType.STRING)
    private ERole name;

    public Role toObject(){
        return new Role(name);
    }
}