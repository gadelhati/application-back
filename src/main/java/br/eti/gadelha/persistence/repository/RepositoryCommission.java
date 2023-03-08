package br.eti.gadelha.persistence.repository;

import br.eti.gadelha.persistence.model.sailingDirection.Commission;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface RepositoryCommission extends JpaRepository<Commission, UUID>, RepositoryInterface<Commission> {

}