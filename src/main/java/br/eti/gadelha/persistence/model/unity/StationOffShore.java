package br.eti.gadelha.persistence.model.unity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import java.time.LocalDateTime;

@Audited @Entity @Table @Data @AllArgsConstructor @NoArgsConstructor @EqualsAndHashCode(callSuper = false)
public class StationOffShore extends Station {

    private LocalDateTime first;
    private LocalDateTime last;
    private double latitudeMostBottom;
    private double latitudeMostTop;
    private double longitudeMostRight;
    private double longitudeMostLeft;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
    @JoinColumn(name = "platform")
    private Platform platform;
}