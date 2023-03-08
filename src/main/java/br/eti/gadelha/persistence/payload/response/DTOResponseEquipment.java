package br.eti.gadelha.persistence.payload.response;

import br.eti.gadelha.persistence.model.Manufacturer;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.UUID;

@Getter @AllArgsConstructor
public class DTOResponseEquipment {

    private UUID id;
    private String name;
    private Manufacturer manufacturer;
}