package br.eti.gadelha.persistence.dto.response;

import br.eti.gadelha.exception.annotation.UniqueEmailAddress;
import br.eti.gadelha.exception.annotation.UniqueNameRole;
import br.eti.gadelha.persistence.model.OM;
import br.eti.gadelha.persistence.model.Role;
import br.eti.gadelha.persistence.model.User;
import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Set;
import java.util.UUID;

/**
 * @author	Marcelo Ribeiro Gadelha
 * @mail	gadelha.ti@gmail.com
 * @link	www.gadelha.eti.br
 **/

@Getter @AllArgsConstructor
public class DTOResponseUser {

    private UUID id;
    @NotBlank @Size(min = 3, max = 20) @UniqueNameRole
    private String username;
    @NotBlank @Size(max = 50) @Email @UniqueEmailAddress
    private String email;
    private String password;
    private Boolean active;
    private OM om;
    private Set<Role> roles;

    public static DTOResponseUser toDTO(User value) {
        return new DTOResponseUser(value.getId(), value.getUsername(), value.getEmail(), value.getPassword(), value.getActive(), value.getOm(), value.getRoles());
    }
}