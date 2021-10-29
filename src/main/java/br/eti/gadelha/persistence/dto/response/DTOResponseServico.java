package br.eti.gadelha.persistence.dto.response;

import br.eti.gadelha.persistence.model.servico.Militar;
import br.eti.gadelha.persistence.model.servico.Servico;
import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

/**
 * @author	Marcelo Ribeiro Gadelha
 * @mail	gadelha.ti@gmail.com
 * @link	www.gadelha.eti.br
 **/

@Getter @AllArgsConstructor
public class DTOResponseServico {

    @Column
    private Militar clti;
    @Column
    private Militar afastado;
    @Temporal(TemporalType.TIMESTAMP)
    private Date data;

    public static DTOResponseServico toDTO(Servico servico) {
        return new DTOResponseServico(servico.getS1(), servico.getS2(), servico.getData());
    }
}