package br.eti.gadelha.persistence.repository;

import br.eti.gadelha.persistence.model.synopticObservation.StationShip;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface RepositoryStationShip extends JpaRepository<StationShip, UUID> {

}