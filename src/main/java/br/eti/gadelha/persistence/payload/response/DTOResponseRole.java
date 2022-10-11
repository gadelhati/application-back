package br.eti.gadelha.persistence.payload.response;

import br.eti.gadelha.persistence.model.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter @AllArgsConstructor
public class DTOResponseRole {

    private String name;

    public static DTOResponseRole toDTO(Role value) {
        return new DTOResponseRole(value.getName());
    }
}