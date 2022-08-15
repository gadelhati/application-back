package br.eti.gadelha.persistence.dto.request;

import br.eti.gadelha.persistence.model.Researcher;
import lombok.Getter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
public class DTORequestResearcher {

    @NotNull(message = "{name.not.null}") @NotBlank(message = "{name.not.blank}")
    private String name;
    @NotNull(message = "{email.not.null}") @NotBlank(message = "{email.not.blank}")
    private String email;
    private String address;

    public Researcher toObject(){
        return new Researcher(name, email, address);
    }
}