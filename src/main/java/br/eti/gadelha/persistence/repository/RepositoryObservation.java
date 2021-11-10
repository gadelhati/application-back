package br.eti.gadelha.persistence.repository;

import br.eti.gadelha.persistence.model.observation.Observation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

/**
 * @author	Marcelo Ribeiro Gadelha
 * @mail	gadelha.ti@gmail.com
 * @link	www.gadelha.eti.br
 **/

public interface RepositoryObservation extends JpaRepository<Observation, UUID> {
//    List<Observation> findByEstacaoContainingIgnoreCaseOrderByEstacaoAsc(String name);
//    boolean existsByEstacao(String value);
}