package br.eti.gadelha.persistence.model.akumanomi;

import br.eti.gadelha.persistence.model.Abiliity;
import br.eti.gadelha.persistence.model.GenericEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * @author	Marcelo Ribeiro Gadelha
 * @mail	gadelha.ti@gmail.com
 * @link	www.gadelha.eti.br
 **/

@Entity @Table @Data @AllArgsConstructor @NoArgsConstructor @EqualsAndHashCode( callSuper = false )
public class Akumanomi extends GenericEntity {

    @Column //@UniqueTitleTutorial
    private String especie;
    @Column
    private AkumanomiClasse classe;
    @Column
    private float preco;
    @Column
    private boolean artificial;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
    @JoinColumn(name = "abiliity")
    private Abiliity abiliity;
}