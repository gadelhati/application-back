package br.eti.gadelha.persistence.repository;

import br.eti.gadelha.persistence.model.Surveying;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface RepositorySurveying extends JpaRepository<Surveying, UUID>, RepositoryInterface<Surveying> {

}