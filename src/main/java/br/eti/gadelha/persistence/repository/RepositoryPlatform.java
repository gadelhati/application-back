package br.eti.gadelha.persistence.repository;

import br.eti.gadelha.persistence.model.synopticObservation.Platform;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface RepositoryPlatform extends JpaRepository<Platform, UUID>, RepositoryInterface<Platform> {
    boolean existsByTelegraphicCallsign(String value);
    boolean existsByInternationalCallsign(String value);
    boolean existsByInternationalName(String value);
}