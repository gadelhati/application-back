package br.eti.gadelha.persistence.repository;

import br.eti.gadelha.persistence.model.OM;
import br.eti.gadelha.persistence.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

/**
 * @author	Marcelo Ribeiro Gadelha
 * @mail	gadelha.ti@gmail.com
 * @link	www.gadelha.eti.br
 **/

public interface RepositoryOM extends JpaRepository<OM, UUID> {
    //    List<Role> findByNameContainingIgnoreCaseOrderByNameAsc(String name);
    OM findByName(String name);
    boolean existsByName(String value);
}