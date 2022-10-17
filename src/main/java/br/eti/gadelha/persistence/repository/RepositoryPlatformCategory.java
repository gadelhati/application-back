package br.eti.gadelha.persistence.repository;

import br.eti.gadelha.persistence.model.synopticObservation.PlatformCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface RepositoryPlatformCategory extends JpaRepository<PlatformCategory, UUID>, RepositoryInterface<PlatformCategory> {

}