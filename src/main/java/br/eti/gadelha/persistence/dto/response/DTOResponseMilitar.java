package br.eti.gadelha.persistence.dto.response;

import br.eti.gadelha.persistence.model.servico.Militar;
import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.persistence.Column;

/**
 * @author	Marcelo Ribeiro Gadelha
 * @mail	gadelha.ti@gmail.com
 * @link	www.gadelha.eti.br
 **/

@Getter @AllArgsConstructor
public class DTOResponseMilitar {

    @Column
    private boolean clti;
    @Column
    private boolean afastado;
    @Column
    private long qtdDeServico;
    @Column
    private boolean s2;
    @Column
    private long antiguidade;
    @Column
    private String especialidade;
    @Column
    private String nip;
    @Column
    private String nomeDeGuerra;
    @Column
    private String nome;
    @Column
    private String funcao;

    public static DTOResponseMilitar toDTO(Militar militar) {
        return new DTOResponseMilitar(militar.isClti(), militar.isAfastado(), militar.getQtdDeServico(), militar.isS2(), militar.getAntiguidade(), militar.getEspecialidade(), militar.getNip(), militar.getNomeDeGuerra(), militar.getNome(), militar.getFuncao());
    }
}