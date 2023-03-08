package br.eti.gadelha.persistence.payload.request;

import br.eti.gadelha.exception.annotation.UniqueIndividual;
import br.eti.gadelha.exception.enumeration.EGender;
import lombok.Builder;
import lombok.Getter;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Getter @Builder
public class DTORequestIndividual extends DTORequestPerson {

    private String name;
    private Date birthdate;
    private EGender gender;
    @NotNull(message = "{name.not.null}") @NotBlank(message = "{name.not.blank}") @CPF @UniqueIndividual
    private String cpf;
}