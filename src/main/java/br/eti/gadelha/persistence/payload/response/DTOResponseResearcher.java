package br.eti.gadelha.persistence.payload.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.UUID;

@Getter @AllArgsConstructor
public class DTOResponseResearcher {

    private UUID id;
    private String name;
    private String email;
    private String address;
}