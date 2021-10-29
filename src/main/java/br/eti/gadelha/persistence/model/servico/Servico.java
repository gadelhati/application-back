package br.eti.gadelha.persistence.model.servico;

import br.eti.gadelha.persistence.model.GenericEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.envers.AuditTable;
import org.hibernate.envers.Audited;

import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@Audited @AuditTable(value = "audit_servico")
@Entity @AllArgsConstructor @NoArgsConstructor @EqualsAndHashCode(callSuper = false) @Data
public class Servico extends GenericEntity {
    private Militar s1;
    private Militar s2;
    @Temporal(TemporalType.TIMESTAMP)
    private Date data;
}