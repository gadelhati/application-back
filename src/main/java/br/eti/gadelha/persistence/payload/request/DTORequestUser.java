package br.eti.gadelha.persistence.payload.request;

import br.eti.gadelha.exception.annotation.auth.*;
import br.eti.gadelha.persistence.model.OM;
import br.eti.gadelha.persistence.model.Role;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.*;
import java.util.Collection;

@Getter @Setter
public class DTORequestUser {

    @NotNull(message = "{name.not.null}") @NotBlank(message = "{name.not.blank}") @UniqueUserName @ValidUserName
    @UserNameLength
    private String username;
    @NotBlank(message = "{email.not.blank}") @Size(max = 50) @Email @UniqueEmail
    private String email;
    @NotNull(message = "{password.not.null}") @NotBlank(message = "{password.not.blank}") @PasswordHasDigit
    @PasswordHasLetter
    @PasswordLength
    private String password;
    @NotNull(message = "{active.not.null}")
    private boolean active;
    private OM om;
    private Collection<Role> roles;
}