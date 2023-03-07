package br.eti.gadelha.persistence.repository;

import br.eti.gadelha.persistence.model.synopticObservation.StationOffShore;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface RepositoryStationShip extends JpaRepository<StationOffShore, UUID> {

}