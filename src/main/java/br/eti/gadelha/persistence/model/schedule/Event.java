package br.eti.gadelha.persistence.model.schedule;

import br.eti.gadelha.persistence.model.GenericEntity;
import br.eti.gadelha.persistence.model.User;

import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

//@Audited @AuditTable(value = "audit_event")
//@Entity @Table(name="event")//, schema="event")
//@AllArgsConstructor @NoArgsConstructor @EqualsAndHashCode(callSuper = false) @Data
public class Event extends GenericEntity {
    @Column(length = 128)
    private String subject;
    @Column(length = 128)
    private User responsible;
//    @Column(length = 128)
//    private OM destiny;
    @Temporal(TemporalType.TIMESTAMP)
    private Date limit;
    @Temporal(TemporalType.TIMESTAMP)
    private Date frequency;//periodicidade
    @Column(length = 128)
    private String reference;//inciso, alínea do documento de referencia
    @Column(length = 128)
    private String send;//documento envio, forma de envio
}