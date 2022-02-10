package br.eti.gadelha.persistence.dto.request;

import br.eti.gadelha.exception.enumeration.EnumEquipment;
import br.eti.gadelha.exception.enumeration.EnumMidia;
import br.eti.gadelha.exception.enumeration.EnumTypeComission;
import br.eti.gadelha.exception.enumeration.EnumTypeStation;
import br.eti.gadelha.persistence.model.observation.Plataform;
import br.eti.gadelha.persistence.model.observation.StationSynop;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * @author	Marcelo Ribeiro Gadelha
 * @mail	gadelha.ti@gmail.com
 * @link	www.gadelha.eti.br
 **/

@Getter
public class DTORequestStationSynop {

    private EnumTypeStation typeStation;
    private EnumTypeComission comission;
    private Plataform plataform;
    private EnumEquipment equipment;
    private LocalDateTime first;
    private LocalDateTime last;
    private Date latitudeMostBottom;
    private Date latitudeMostTop;
    private Date longitudeMostRight;
    private Date longitudeMostLeft;
    private EnumMidia midia;
    private String fb;
//    private Plataform plataform;

    public StationSynop toObject(){
        return new StationSynop(typeStation, comission, plataform, equipment, first, last, latitudeMostBottom, latitudeMostTop, longitudeMostRight, longitudeMostLeft, midia, fb/*, plataform*/);
    }
}