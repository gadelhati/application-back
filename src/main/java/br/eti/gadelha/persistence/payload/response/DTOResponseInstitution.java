package br.eti.gadelha.persistence.payload.response;

import br.eti.gadelha.persistence.model.Country;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.UUID;

@Getter @AllArgsConstructor
public class DTOResponseInstitution {

    private UUID id;
    private String name;
    private Country country;
}