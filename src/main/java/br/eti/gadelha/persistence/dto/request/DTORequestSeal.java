package br.eti.gadelha.persistence.dto.request;

import br.eti.gadelha.exception.annotation.UniqueSealNumber;
import br.eti.gadelha.persistence.model.support.Seal;
import lombok.Getter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author	Marcelo Ribeiro Gadelha
 * @mail	gadelha.ti@gmail.com
 * @link	www.gadelha.eti.br
 **/

@Getter
public class DTORequestSeal {

    @NotNull(message = "{number.not.null}") @NotBlank(message = "{number.not.blank}") @UniqueSealNumber
    private String number;
    private String color;
    @NotNull
    private boolean broken;

    public Seal toObject(){
        return new Seal(number, color, broken);
    }
}