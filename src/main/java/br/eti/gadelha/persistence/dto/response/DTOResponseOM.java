package br.eti.gadelha.persistence.dto.response;

import br.eti.gadelha.persistence.model.OM;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class DTOResponseOM {

    private String name;

    public static DTOResponseOM toDTO(OM om) {
        return new DTOResponseOM(om.getName());
    }
}
