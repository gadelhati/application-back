package br.eti.gadelha.persistence.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.envers.AuditTable;
import org.hibernate.envers.Audited;

import javax.persistence.Entity;
import javax.persistence.Table;

@Audited @AuditTable(value = "file_auditoria")
@Entity @Table//(name="file", schema="shipsynopweb")
@AllArgsConstructor @NoArgsConstructor @EqualsAndHashCode(callSuper = false) @Data
public class File extends GenericEntity {
    private String fileName;
    private String fileType;
    private long size;
}
