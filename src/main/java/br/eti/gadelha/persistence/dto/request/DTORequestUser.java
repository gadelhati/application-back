package br.eti.gadelha.persistence.dto.request;

import br.eti.gadelha.exception.annotation.*;
import br.eti.gadelha.persistence.model.OM;
import br.eti.gadelha.persistence.model.Role;
import br.eti.gadelha.persistence.model.User;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.*;
import java.util.Set;

/**
 * @author	Marcelo Ribeiro Gadelha
 * @mail	gadelha.ti@gmail.com
 * @link	www.gadelha.eti.br
 **/

@Getter @Setter
public class DTORequestUser {

    @NotNull(message = "{name.not.null}") @NotBlank(message = "{name.not.blank}") /*@UniqueUserName*/ @ValidUserName @UserNameLength
    private String username;
    @NotBlank @Size(max = 50) @Email //@UniqueEmailAddress
    private String email;
    @NotNull(message = "{password.not.null}") @NotBlank(message = "{password.not.blank}") @PasswordHasDigit @PasswordHasLetter @PasswordLength
    private String password;
    @NotNull(message = "{active.not.null}")
    private Boolean active;
//    @NotNull(message = "{om.not.null}")
    private OM om;
    private Set<Role> roles;

    public User toObject(){
        return new User(username, email, password);
    }
}