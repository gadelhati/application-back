package br.eti.gadelha.persistence.repository;

import br.eti.gadelha.persistence.model.ShipSynop;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

/**
 * @author	Marcelo Ribeiro Gadelha
 * @mail	gadelha.ti@gmail.com
 * @link	www.gadelha.eti.br
 **/

public interface RepositoryShipSynop extends JpaRepository<ShipSynop, UUID> {
    List<ShipSynop> findByEstacaoContainingIgnoreCaseOrderByEstacaoAsc(String name);
    boolean existsByEstacao(String value);
}