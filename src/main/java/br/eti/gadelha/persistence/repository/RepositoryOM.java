package br.eti.gadelha.persistence.repository;

import br.eti.gadelha.persistence.model.OM;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface RepositoryOM extends JpaRepository<OM, UUID> {
    List<OM> findByNameContainingIgnoreCaseOrderByNameAsc(String name);
    OM findByName(String name);
    boolean existsByName(String value);
}