package br.eti.gadelha.persistence.repository;

import br.eti.gadelha.persistence.model.synopticObservation.StationCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface RepositoryStationCategory extends JpaRepository<StationCategory, UUID>, RepositoryInterface<StationCategory> {

}