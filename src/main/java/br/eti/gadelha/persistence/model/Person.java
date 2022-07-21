package br.eti.gadelha.persistence.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import java.util.Date;

/**
 * @author	Marcelo Ribeiro Gadelha
 * @mail	gadelha.ti@gmail.com
 * @link	www.gadelha.eti.br
 **/

@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Audited @Entity @Table @Data @AllArgsConstructor @NoArgsConstructor @EqualsAndHashCode(callSuper = false)
public abstract class Person extends GenericEntity {
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private Date birthdate;
}
