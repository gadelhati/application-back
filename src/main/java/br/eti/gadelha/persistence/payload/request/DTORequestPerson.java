package br.eti.gadelha.persistence.payload.request;

import lombok.Getter;

import java.util.Date;

@Getter
public class DTORequestPerson {

    private String name;
    private Date birthdate;
}