package br.eti.gadelha.persistence.dto.response;

import br.eti.gadelha.exception.enumeration.EnumTypeComission;
import br.eti.gadelha.exception.enumeration.EnumMidia;
import br.eti.gadelha.exception.enumeration.EnumTypeStation;
import br.eti.gadelha.persistence.model.observation.Equipment;
import br.eti.gadelha.persistence.model.observation.Platform;
import br.eti.gadelha.persistence.model.observation.StationShip;
import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * @author	Marcelo Ribeiro Gadelha
 * @mail	gadelha.ti@gmail.com
 * @link	www.gadelha.eti.br
 **/

@Getter @AllArgsConstructor
public class DTOResponseStationShip {

    private UUID id;
    private LocalDateTime dataHora;
    private int latitude;
    private int longitude;
    private String telegraphicCallsign;
//    private EnumEquipment equipment;
    private EnumTypeComission commission;
    private EnumTypeStation typeStation;
    private EnumMidia midia;
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
//	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
//	@JoinColumn(name = "manufacturer")
//	private Manufacturer manufacturer;
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
    @JoinColumn(name = "plataform")
    private Platform platform;
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
    @JoinColumn(name = "equipment")
    private Equipment equipment;

    public static DTOResponseStationShip toDTO(StationShip value) {
        return new DTOResponseStationShip(value.getId(), value.getDataHora(), value.getLatitude(), value.getLongitude(), value.getTelegraphicCallsign(), value.getCommission(), value.getTypeStation(), value.getMidia(), value.getName(), value.getDay(), value.getMonth(), value.getYear(), value.getMarsdenSquare(), value.getMarsdenSubSquare_1(), value.getMarsdenSubSquare_5(), value.getWmoSquare(), value.getObs(), value.getCollectionDepth(), value.getLoadedInAlpha(), value.getPlatform(), value.getEquipment());
    }
}