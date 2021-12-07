package br.eti.gadelha.persistence.repository;

import br.eti.gadelha.persistence.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * @author	Marcelo Ribeiro Gadelha
 * @mail	gadelha.ti@gmail.com
 * @link	www.gadelha.eti.br
 **/

public interface RepositoryUser extends JpaRepository<User, UUID> {
    List<User> findByUsernameContainingIgnoreCaseOrderByUsernameAsc(String name);
    boolean existsByUsername(String value);
    boolean existsByEmail(String email);
    Optional<User> findByUsername(String username);
}