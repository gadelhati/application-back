package br.eti.gadelha.persistence.dto.request;

import br.eti.gadelha.persistence.model.servico.Militar;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * @author	Marcelo Ribeiro Gadelha
 * @mail	gadelha.ti@gmail.com
 * @link	www.gadelha.eti.br
 **/

@Getter @AllArgsConstructor @NoArgsConstructor
public class DTORequestMilitar {

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
    private String funcao;

    public Militar toObject(){
        return new Militar(clti, afastado, qtdDeServico, s2, antiguidade, especialidade, nip, nomeDeGuerra, nome, funcao);
    }
}