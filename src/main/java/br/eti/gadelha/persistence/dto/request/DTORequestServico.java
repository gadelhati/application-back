package br.eti.gadelha.persistence.dto.request;

import br.eti.gadelha.persistence.model.servico.Militar;
import br.eti.gadelha.persistence.model.servico.Servico;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

/**
 * @author	Marcelo Ribeiro Gadelha
 * @mail	gadelha.ti@gmail.com
 * @link	www.gadelha.eti.br
 **/

@Getter @AllArgsConstructor @NoArgsConstructor
public class DTORequestServico {

    @Column
    private Militar s1;
    @Column
    private Militar s2;
    @Temporal(TemporalType.TIMESTAMP)
    private Date data;

    public Servico toObject(){
        return new Servico(s1, s2, data);
    }
}