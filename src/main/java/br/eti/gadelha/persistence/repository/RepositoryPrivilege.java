package br.eti.gadelha.persistence.repository;

import br.eti.gadelha.persistence.model.Privilege;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface RepositoryPrivilege extends JpaRepository<Privilege, UUID> {
    //    List<Role> findByNameContainingIgnoreCaseOrderByNameAsc(String name);
    Privilege findByName(String name);
    boolean existsByName(String value);
}