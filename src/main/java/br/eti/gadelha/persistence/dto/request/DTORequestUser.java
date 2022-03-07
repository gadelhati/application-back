package br.eti.gadelha.persistence.dto.request;

import br.eti.gadelha.exception.annotation.UniqueEmailAddress;
import br.eti.gadelha.exception.annotation.UniqueUserName;
import br.eti.gadelha.persistence.model.OM;
import br.eti.gadelha.persistence.model.Role;
import br.eti.gadelha.persistence.model.User;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
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

@Getter @Setter
public class DTORequestUser {

    @NotNull(message = "{name.not.null}") @NotBlank(message = "{name.not.blank}") @UniqueUserName
    private String username;
    @NotBlank @Size(max = 50) @Email @UniqueEmailAddress
    private String email;
    @NotNull(message = "{password.not.null}") @NotBlank(message = "{password.not.blank}")
    private String password;
    private Boolean active;
    @NotNull(message = "{om.not.null}")
    private OM om;
    private Set<Role> roles;

    public User toObject(){
        return new User(username, password, email, active, om);
    }
}