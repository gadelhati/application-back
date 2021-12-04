package br.eti.gadelha.persistence.dto.response;

import br.eti.gadelha.exception.annotation.UniqueEmailAddress;
import br.eti.gadelha.exception.annotation.UniqueNameRole;
import br.eti.gadelha.persistence.model.Role;
import br.eti.gadelha.persistence.model.User;
import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Set;

/**
 * @author	Marcelo Ribeiro Gadelha
 * @mail	gadelha.ti@gmail.com
 * @link	www.gadelha.eti.br
 **/

@Getter @AllArgsConstructor
public class DTOResponseUser {
    @NotBlank @Size(min = 3, max = 20) @UniqueNameRole
    private String username;
    @NotBlank @Size(max = 50) @Email @UniqueEmailAddress
    private String email;
//    @NotNull
    private Set<Role> role;
    @NotBlank
    @Size(min = 6, max = 40)
    private String password;

    public static DTOResponseUser toDTO(User user) {
        return new DTOResponseUser(user.getUsername(), user.getEmail(), user.getRoles(), user.getPassword());
    }
}