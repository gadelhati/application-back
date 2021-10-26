package br.eti.gadelha.persistence.model;

import javax.persistence.Column;
import java.util.Date;

/**
 * @author	Marcelo Ribeiro Gadelha
 * @mail	gadelha.ti@gmail.com
 * @link	www.gadelha.eti.br
 **/

public abstract class Pessoa extends GenericEntity {
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private Date birthdate;
}
