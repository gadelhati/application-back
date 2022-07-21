package br.eti.gadelha.persistence.model.unity;

import br.eti.gadelha.exception.enumeration.EnumTypeVessel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.envers.AuditTable;
import org.hibernate.envers.Audited;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

/**
 * @author	Marcelo Ribeiro Gadelha
 * @mail	gadelha.ti@gmail.com
 * @link	www.gadelha.eti.br
 **/

@Audited @Entity @Table @Data @AllArgsConstructor @NoArgsConstructor @EqualsAndHashCode(callSuper = false)
public class StationShip extends Station {
//    private String imo;
    private String navalCallsign;
//    private String visualCallsign;
//    private String telegraphicCallsign;
//    private double latitude;
//    private double longitude;
    private EnumTypeVessel type;
    private Date since;
}