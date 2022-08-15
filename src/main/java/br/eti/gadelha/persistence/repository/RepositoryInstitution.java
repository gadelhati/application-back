package br.eti.gadelha.persistence.repository;

import br.eti.gadelha.persistence.model.unity.Institution;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface RepositoryInstitution extends JpaRepository<Institution, UUID> {
    List<Institution> findByNameContainingIgnoreCaseOrderByNameAsc(String name);
    Institution findByName(String name);
}