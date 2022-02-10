package br.eti.gadelha.persistence.dto.response;

import br.eti.gadelha.exception.enumeration.EnumEquipment;
import br.eti.gadelha.exception.enumeration.EnumMidia;
import br.eti.gadelha.exception.enumeration.EnumTypeComission;
import br.eti.gadelha.exception.enumeration.EnumTypeStation;
import br.eti.gadelha.persistence.model.observation.Plataform;
import br.eti.gadelha.persistence.model.observation.StationSynop;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;

/**
 * @author	Marcelo Ribeiro Gadelha
 * @mail	gadelha.ti@gmail.com
 * @link	www.gadelha.eti.br
 **/

@Getter @AllArgsConstructor
public class DTOResponseStationSynop {

    private UUID id;
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

    public static DTOResponseStationSynop toDTO(StationSynop value) {
        return new DTOResponseStationSynop(value.getId(), value.getTypeStation(), value.getTypeComission(), value.getPlataform(), value.getEquipment(), value.getFirst(), value.getLast(), value.getLatitudeMostBottom(), value.getLatitudeMostTop(), value.getLongitudeMostRight(), value.getLongitudeMostLeft(), value.getMidia(), value.getFb()/*, value.getPlataform()*/ );
    }
}