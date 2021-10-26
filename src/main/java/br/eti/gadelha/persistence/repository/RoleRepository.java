package br.eti.gadelha.persistence.repository;

import java.util.Optional;
import java.util.UUID;

import br.eti.gadelha.persistence.model.ERole;
import br.eti.gadelha.persistence.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, UUID> {
  Optional<Role> findByName(ERole name);
}