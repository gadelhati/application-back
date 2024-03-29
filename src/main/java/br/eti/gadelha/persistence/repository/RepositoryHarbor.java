package br.eti.gadelha.persistence.repository;

import br.eti.gadelha.persistence.model.sailingDirection.Harbor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface RepositoryHarbor extends JpaRepository<Harbor, UUID>, RepositoryInterface<Harbor> {

}