package br.eti.gadelha.persistence.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.envers.Audited;

import javax.persistence.*;

@Audited @Entity @Data @AllArgsConstructor @NoArgsConstructor
public class Equipment extends GenericEntity {

    private String name;
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
    @JoinColumn(name = "manufacturer")
    private Manufacturer manufacturer;
}