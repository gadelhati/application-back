package br.eti.gadelha.persistence.repository;

import br.eti.gadelha.persistence.model.synopticObservation.Station;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface RepositoryStation extends JpaRepository<Station, UUID> {
    List<Station> findByComContainingIgnoreCaseOrderByComAsc(String com);
    Station findByCom(String com);
    boolean existsByCom(String com);
}