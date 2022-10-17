package br.eti.gadelha.persistence.model.synopticObservation;

import br.eti.gadelha.persistence.model.GenericEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.envers.Audited;

import javax.persistence.*;

@Audited @Entity @Data @AllArgsConstructor @NoArgsConstructor
public class Quality extends GenericEntity {

    private String io;
    private String ie;
    private String iq;
    private String criticado;
}