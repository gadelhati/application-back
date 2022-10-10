package br.eti.gadelha.persistence.repository;

import br.eti.gadelha.persistence.model.OM;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface RepositoryOM extends JpaRepository<OM, UUID>, RepositoryInterface<OM> {

}