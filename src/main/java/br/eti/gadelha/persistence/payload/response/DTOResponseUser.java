package br.eti.gadelha.persistence.payload.response;

import br.eti.gadelha.exception.annotation.auth.UniqueEmail;
import br.eti.gadelha.exception.annotation.auth.UniqueNameRole;
import br.eti.gadelha.persistence.model.OM;
import br.eti.gadelha.persistence.model.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Collection;
import java.util.UUID;

@Getter @AllArgsConstructor
public class DTOResponseUser {

    private UUID id;
    @NotBlank @Size(min = 3, max = 20) @UniqueNameRole
    private String username;
    @NotBlank @Size(max = 50) @Email @UniqueEmail
    private String email;
    private String password;
    private Boolean active;
    private OM om;
    private Collection<Role> roles;
}