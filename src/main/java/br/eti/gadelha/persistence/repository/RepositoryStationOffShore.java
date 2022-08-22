package br.eti.gadelha.persistence.repository;

import br.eti.gadelha.persistence.model.unity.StationOffShore;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface RepositoryStationOffShore extends JpaRepository<StationOffShore, UUID> {
//    List<StationOffShore> findByLatitudeMostBottomContainingIgnoreCaseOrderByLatitudeMostBottomAsc(String name);
//    StationOffShore findByName(String name);
}