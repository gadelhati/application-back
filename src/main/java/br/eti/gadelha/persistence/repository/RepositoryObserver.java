package br.eti.gadelha.persistence.repository;

import br.eti.gadelha.persistence.model.synopticObservation.Observer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface RepositoryObserver extends JpaRepository<Observer, UUID>, RepositoryInterface<Observer> {
    boolean existsByNipContainingIgnoreCase(String value);
}