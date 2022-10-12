package br.eti.gadelha.persistence.repository;

import br.eti.gadelha.persistence.model.Role2;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface RepositoryRole2 extends JpaRepository<Role2, UUID> {
    Role2 findByName(String name);
}