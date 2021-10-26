package br.eti.gadelha.persistence.dto.response;

import br.eti.gadelha.persistence.model.Classe;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author	Marcelo Ribeiro Gadelha
 * @mail	gadelha.ti@gmail.com
 * @link	www.gadelha.eti.br
 **/

@Getter @AllArgsConstructor
public class DTOResponseClasse {

    private String name;
    private String name2;

    public static DTOResponseClasse toDTO(Classe classe) {
        return new DTOResponseClasse(classe.getName(), classe.getName2());
    }
}