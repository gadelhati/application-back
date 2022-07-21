package br.eti.gadelha.persistence.repository;

import br.eti.gadelha.persistence.model.synoptic.SynopticObservation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

/**
 * @author	Marcelo Ribeiro Gadelha
 * @mail	gadelha.ti@gmail.com
 * @link	www.gadelha.eti.br
 **/

public interface RepositoryObservation extends JpaRepository<SynopticObservation, UUID> {
//    List<Observation> findByEstacaoContainingIgnoreCaseOrderByEstacaoAsc(String name);
//    boolean existsByEstacao(String value);
}