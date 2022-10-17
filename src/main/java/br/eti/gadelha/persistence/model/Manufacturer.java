package br.eti.gadelha.persistence.model;

import br.eti.gadelha.persistence.model.GenericEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.envers.Audited;

import javax.persistence.*;

@Audited @Entity @Data @AllArgsConstructor @NoArgsConstructor
public class Manufacturer extends GenericEntity {

    private String name;
}