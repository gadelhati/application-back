package br.eti.gadelha.persistence.model;

import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

/**
 * @author	Marcelo Ribeiro Gadelha
 * @mail	gadelha.ti@gmail.com
 * @link	www.gadelha.eti.br
 **/

public class PessoaFisica extends Pessoa {
    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private Gender gender;
    @CPF
    private String cpf;
}
