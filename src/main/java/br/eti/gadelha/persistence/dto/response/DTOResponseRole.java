package br.eti.gadelha.persistence.dto.response;

import br.eti.gadelha.exception.enumeration.ERole;
import br.eti.gadelha.persistence.model.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author	Marcelo Ribeiro Gadelha
 * @mail	gadelha.ti@gmail.com
 * @link	www.gadelha.eti.br
 **/

@Getter @AllArgsConstructor
public class DTOResponseRole {

    private ERole name;

    public static DTOResponseRole toDTO(Role role) {
        return new DTOResponseRole(role.getName());
    }
}