package br.eti.gadelha.persistence.repository;

import br.eti.gadelha.persistence.model.User2;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface RepositoryUser2 extends JpaRepository<User2, UUID> {
    User2 findByEmail(String email);
}