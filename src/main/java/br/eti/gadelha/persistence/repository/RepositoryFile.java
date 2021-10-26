package br.eti.gadelha.persistence.repository;

import br.eti.gadelha.persistence.model.File;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

/**
 * @author	Marcelo Ribeiro Gadelha
 * @mail	gadelha.ti@gmail.com
 * @link	www.gadelha.eti.br
 **/

public interface RepositoryFile extends JpaRepository<File, UUID> {
    List<File> findByFileNameContainingIgnoreCaseOrderByFileNameAsc(String name);
    boolean existsByFileName(String value);
}