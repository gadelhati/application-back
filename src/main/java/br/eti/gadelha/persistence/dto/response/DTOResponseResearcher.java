package br.eti.gadelha.persistence.dto.response;

import br.eti.gadelha.persistence.model.Researcher;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.UUID;

@Getter @AllArgsConstructor
public class DTOResponseResearcher {

    private UUID id;
    private String name;
    private String email;
    private String address;

    public static DTOResponseResearcher toDTO(Researcher value) {
        return new DTOResponseResearcher(value.getId(), value.getName(), value.getEmail(), value.getAddress());
    }
}