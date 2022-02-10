package br.eti.gadelha.persistence.dto.request;

import br.eti.gadelha.exception.enumeration.EnumEquipment;
import br.eti.gadelha.exception.enumeration.EnumMidia;
import br.eti.gadelha.exception.enumeration.EnumTypeComission;
import br.eti.gadelha.exception.enumeration.EnumTypeStation;
import br.eti.gadelha.persistence.model.observation.StationShip;
import lombok.Getter;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

/**
 * @author	Marcelo Ribeiro Gadelha
 * @mail	gadelha.ti@gmail.com
 * @link	www.gadelha.eti.br
 **/

@Getter
public class DTORequestStationShip {

    private LocalDateTime dataHora;
    private int latitude;
    private int longitude;
    private String telegraphicCallsign;
    private EnumEquipment equipment;
    private EnumTypeComission comission;
    private EnumTypeStation typeStation;
    private EnumMidia midia;
    @NotNull(message = "{name.not.null}") @NotBlank(message = "{name.not.blank}")
    @Enumerated(EnumType.STRING)
    private String name;
    private int day;
    private int month;
    private int year;
    private int marsdenSquare;
    private int marsdenSubSquare_1;
    private int marsdenSubSquare_5;
    private int wmoSquare;
    private String obs;
    private float collectionDepth;
    private float loadedInAlpha;

    public StationShip toObject(){
        return new StationShip(dataHora, latitude, longitude, telegraphicCallsign, equipment, comission, typeStation, midia, name, day, month, year, marsdenSquare, marsdenSubSquare_1, marsdenSubSquare_5, wmoSquare, obs, collectionDepth, loadedInAlpha);
    }
}