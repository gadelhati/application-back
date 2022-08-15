package br.eti.gadelha.persistence.repository;

import br.eti.gadelha.persistence.model.Researcher;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface RepositoryResearcher extends JpaRepository<Researcher, UUID> {
    List<Researcher> findByNameContainingIgnoreCaseOrderByNameAsc(String name);
    Researcher findByName(String name);
}