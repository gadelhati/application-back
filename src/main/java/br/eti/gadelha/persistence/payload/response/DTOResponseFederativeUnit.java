package br.eti.gadelha.persistence.payload.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.UUID;

@Getter @AllArgsConstructor
public class DTOResponseFederativeUnit {

    private UUID id;
    private String name;
}