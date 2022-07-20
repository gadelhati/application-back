package br.eti.gadelha.persistence.model.observation;

import br.eti.gadelha.persistence.model.Commission;
import br.eti.gadelha.persistence.model.Country;
import br.eti.gadelha.persistence.model.GenericEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.envers.AuditTable;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * @author	Marcelo Ribeiro Gadelha
 * @mail	marcelo.gadelha@marinha.mil.br
 * @link	www.gadelha.eti.br
 **/

@Audited @AuditTable(value = "audit_station")
@Entity @Table
@AllArgsConstructor @NoArgsConstructor @Data @EqualsAndHashCode(callSuper = false)
public class Station extends GenericEntity {

    private LocalDateTime dateTime;
    private float latitude;
    private float longitude;
    private float collectionDepth;
    private float localDepth;
    private int marsdenSquare_10;
    private int marsdenSubSquare_1;
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
    @JoinColumn(name = "commission")
    private Commission commission;
//    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
//    @JoinColumn(name = "platform")
//    private Platform platform;
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
    @JoinColumn(name = "stationCategory")
    private StationCategory stationCategory;
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
    @JoinColumn(name = "equipment")
    private Equipment equipment;
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
    @JoinColumn(name = "equipment")
    private Surveying surveying;
//    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
//    @JoinColumn(name = "responsible"/*, nullable = true*/)
//    private Institution responsible;
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
    @JoinColumn(name = "responsible"/*, nullable = true*/)
    private Country country;
}