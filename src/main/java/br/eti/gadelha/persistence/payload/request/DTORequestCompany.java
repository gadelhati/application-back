package br.eti.gadelha.persistence.payload.request;

import br.eti.gadelha.exception.annotation.UniqueManufacturer;
import br.eti.gadelha.persistence.model.Company;
import lombok.Getter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
public class DTORequestCompany {

    @NotNull(message = "{name.not.null}") @NotBlank(message = "{name.not.blank}") @UniqueManufacturer
    private String name;

    public Company toObject(){
        return new Company(name);
    }
}