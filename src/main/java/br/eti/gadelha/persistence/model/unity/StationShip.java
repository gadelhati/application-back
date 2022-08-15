package br.eti.gadelha.persistence.model.unity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.envers.Audited;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Audited @Entity @Table @Data @AllArgsConstructor @NoArgsConstructor @EqualsAndHashCode(callSuper = false)
public class StationShip extends Station {

    private LocalDateTime first;
    private LocalDateTime last;
    private double latitudeMostBottom;
    private double latitudeMostTop;
    private double longitudeMostRight;
    private double longitudeMostLeft;

//    private String imo;
//    private String navalCallsign;
//    private String visualCallsign;
//    private EnumTypeVessel type;
//    private Date since;
}