package br.eti.gadelha.persistence.model;

import org.hibernate.validator.constraints.br.CNPJ;

/**
 * @author	Marcelo Ribeiro Gadelha
 * @mail	gadelha.ti@gmail.com
 * @link	www.gadelha.eti.br
 **/

public class PessoaJuridica extends Pessoa {
    @CNPJ
    private String cnpj;
}
