package br.eti.gadelha.persistence.payload.request;

import br.eti.gadelha.persistence.model.*;
import lombok.Getter;

import java.util.Date;

@Getter
public class DTORequestPerson {

    private String name;
    private Date birthdate;

    public Person toObject(){
        return new Person(name, birthdate);
    }
}