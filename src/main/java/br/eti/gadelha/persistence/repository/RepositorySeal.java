package br.eti.gadelha.persistence.repository;

import br.eti.gadelha.persistence.model.support.Seal;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

/**
 * @author	Marcelo Ribeiro Gadelha
 * @mail	gadelha.ti@gmail.com
 * @link	www.gadelha.eti.br
 **/

public interface RepositorySeal extends JpaRepository<Seal, UUID> {
    List<Seal> findByBrokenFalse();
    List<Seal> findByNumberContainingIgnoreCaseOrderByNumberAsc(String number);
    boolean existsByNumber(String value);
}