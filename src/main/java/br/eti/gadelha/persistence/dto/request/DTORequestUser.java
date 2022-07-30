package br.eti.gadelha.persistence.dto.request;

import br.eti.gadelha.exception.annotation.*;
import br.eti.gadelha.persistence.model.OM;
import br.eti.gadelha.persistence.model.Role;
import br.eti.gadelha.persistence.model.User;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.*;
import java.util.Set;

@Getter @Setter
public class DTORequestUser {

    @NotNull(message = "{name.not.null}") @NotBlank(message = "{name.not.blank}") /*@UniqueUserName*/ @ValidUserName @UserNameLength
    private String username;
    @NotBlank(message = "{email.not.blank}") @Size(max = 50) @Email //@UniqueEmail
    private String email;
    @NotNull(message = "{password.not.null}") @NotBlank(message = "{password.not.blank}") @PasswordHasDigit @PasswordHasLetter @PasswordLength
    private String password;
    @NotNull(message = "{active.not.null}")
    private boolean active;
//    @NotNull(message = "{om.not.null}")
    private OM om;
    private Set<Role> roles;

    public User toObject(){
        return new User(username, email, password);
    }
}