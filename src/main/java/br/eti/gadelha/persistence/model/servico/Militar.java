package br.eti.gadelha.persistence.model.servico;

import br.eti.gadelha.persistence.model.GenericEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.envers.AuditTable;
import org.hibernate.envers.Audited;

import javax.persistence.Entity;

@Audited @AuditTable(value = "audit_militar")
@Entity @AllArgsConstructor @NoArgsConstructor @EqualsAndHashCode(callSuper = false) @Data
public class Militar extends GenericEntity {
    private boolean clti;
    private boolean afastado;
    private long qtdDeServico;
    private boolean s2;
    private long antiguidade;
    private String especialidade;
    private String nip;
    private String nomeDeGuerra;
    private String nome;
    private String funcao;
}