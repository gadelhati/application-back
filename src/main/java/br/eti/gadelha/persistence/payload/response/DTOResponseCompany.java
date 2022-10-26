package br.eti.gadelha.persistence.payload.response;

import br.eti.gadelha.persistence.model.Company;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.UUID;

@Getter @AllArgsConstructor
public class DTOResponseCompany {

    private UUID id;
    private String name;

    public static DTOResponseCompany toDTO(Company value) {
        return new DTOResponseCompany(value.getId(), value.getName());
    }
}