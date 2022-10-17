package br.eti.gadelha.persistence.payload.request;

import br.eti.gadelha.persistence.model.Equipment;
import br.eti.gadelha.persistence.model.Manufacturer;
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