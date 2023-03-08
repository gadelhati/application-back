package br.eti.gadelha.persistence.payload.response;

import br.eti.gadelha.exception.enumeration.EGender;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Date;
import java.util.UUID;

@Getter @AllArgsConstructor
public class DTOResponseIndividual {

    private UUID id;
    private String name;
    private Date birthdate;
    private EGender gender;
    private String cpf;
}