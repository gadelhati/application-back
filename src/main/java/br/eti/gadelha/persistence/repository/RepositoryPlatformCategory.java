package br.eti.gadelha.persistence.repository;

import br.eti.gadelha.persistence.model.unity.PlatformCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface RepositoryPlatformCategory extends JpaRepository<PlatformCategory, UUID> {
    List<PlatformCategory> findByNameContainingIgnoreCaseOrderByNameAsc(String name);
    PlatformCategory findByName(String name);
}