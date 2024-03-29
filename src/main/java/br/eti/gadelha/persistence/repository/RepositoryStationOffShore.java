package br.eti.gadelha.persistence.repository;

import br.eti.gadelha.persistence.model.synopticObservation.StationOnShore;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface RepositoryStationOffShore extends JpaRepository<StationOnShore, UUID> {

}