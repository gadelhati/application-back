package br.eti.gadelha.persistence.repository;

import br.eti.gadelha.persistence.model.Classe;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

/**
 * @author	Marcelo Ribeiro Gadelha
 * @mail	gadelha.ti@gmail.com
 * @link	www.gadelha.eti.br
 **/

public interface RepositoryClasse extends JpaRepository<Classe, UUID> {
    List<Classe> findByNameContainingIgnoreCaseOrderByNameAsc(String name);
    boolean existsByName(String value);
}