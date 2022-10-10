package br.eti.gadelha.persistence.repository;

import br.eti.gadelha.persistence.model.unity.StationOnShore;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface RepositoryStationOnShore extends JpaRepository<StationOnShore, UUID>, RepositoryInterface<StationOnShore> {

}