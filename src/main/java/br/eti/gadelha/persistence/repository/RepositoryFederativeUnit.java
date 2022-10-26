package br.eti.gadelha.persistence.repository;

import br.eti.gadelha.persistence.model.FederativeUnit;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface RepositoryFederativeUnit extends JpaRepository<FederativeUnit, UUID>, RepositoryInterface<FederativeUnit> {
    boolean existsByInitialsIgnoreCase(String value);
}