package br.eti.gadelha.persistence.dto.response;

import br.eti.gadelha.exception.annotation.UniqueUserName;
import br.eti.gadelha.exception.enumeration.EnumTypePlatform;
import br.eti.gadelha.persistence.model.Country;
import br.eti.gadelha.persistence.model.observation.Plataform;
import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.UUID;

/**
 * @author	Marcelo Ribeiro Gadelha
 * @mail	gadelha.ti@gmail.com
 * @link	www.gadelha.eti.br
 **/

@Getter @AllArgsConstructor
public class DTOResponsePlataform {

    private UUID id;
    private String /*EnumTypePlatform*/ typePlatform;
    private String telegraphicCallsign;
    private String internationalCallsign;
    @NotNull(message = "{name.not.null}") @NotBlank(message = "{name.not.blank}") @UniqueUserName
    @Enumerated(EnumType.STRING)
    private String name;
    private String internationalName;
    private String visualCallsign;
    private Country country;

    public static DTOResponsePlataform toDTO(Plataform value) {
        return new DTOResponsePlataform(value.getId(), value.getTypePlatform(), value.getTelegraphicCallsign(), value.getInternationalCallsign(), value.getName(), value.getInternationalName(), value.getVisualCallsign(), value.getCountry());
    }
}