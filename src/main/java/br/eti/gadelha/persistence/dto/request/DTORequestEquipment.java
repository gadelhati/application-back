package br.eti.gadelha.persistence.dto.request;

import br.eti.gadelha.persistence.model.unity.Equipment;
import br.eti.gadelha.persistence.model.unity.Manufacturer;
import lombok.Getter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
public class DTORequestEquipment {

    @NotNull(message = "{name.not.null}") @NotBlank(message = "{name.not.blank}")
    private String name;
    private Manufacturer manufacturer;

    public Equipment toObject(){
        return new Equipment(name, manufacturer);
    }
}