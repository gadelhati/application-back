package br.eti.gadelha.persistence.payload.response;

import br.eti.gadelha.persistence.model.OM;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.UUID;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class DTOResponseOM {

    private UUID id;
    private String name;

    public static DTOResponseOM toDTO(OM om) {
        return new DTOResponseOM(om.getId(), om.getName());
    }
}
