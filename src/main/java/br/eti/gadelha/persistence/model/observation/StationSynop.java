package br.eti.gadelha.persistence.model.observation;

import br.eti.gadelha.exception.enumeration.EnumEquipment;
import br.eti.gadelha.exception.enumeration.EnumMidia;
import br.eti.gadelha.exception.enumeration.EnumTypeComission;
import br.eti.gadelha.exception.enumeration.EnumTypeStation;
import br.eti.gadelha.persistence.model.GenericEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.envers.AuditTable;
import org.hibernate.envers.Audited;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Audited @AuditTable(value = "audit_station_synop")
@Entity @Table(name="station_synop")
@AllArgsConstructor @NoArgsConstructor @EqualsAndHashCode(callSuper = false) @Data
public class StationSynop extends Station {
    private LocalDateTime first;
    private LocalDateTime last;
    private float latitudeMostBottom;
    private float latitudeMostTop;
    private float longitudeMostRight;
    private float longitudeMostLeft;
}