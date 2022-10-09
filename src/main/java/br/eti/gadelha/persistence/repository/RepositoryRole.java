package br.eti.gadelha.persistence.repository;

import br.eti.gadelha.exception.enumeration.ERole;
import br.eti.gadelha.persistence.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface RepositoryRole extends JpaRepository<Role, UUID> {
    List<Role> findByNameContainingIgnoreCaseOrderByNameAsc(String name);
    Role findByName(String name);
    boolean existsByName(String value);
}