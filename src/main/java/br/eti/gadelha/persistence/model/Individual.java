package br.eti.gadelha.persistence.model;

import br.eti.gadelha.exception.enumeration.EGender;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.envers.Audited;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;

@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Audited @Entity @Table @Data @AllArgsConstructor @NoArgsConstructor @EqualsAndHashCode(callSuper = false)
public class Individual extends Person {
    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private EGender gender;
    @CPF
    private String cpf;
}
