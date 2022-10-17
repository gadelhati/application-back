package br.eti.gadelha.persistence.repository;

import br.eti.gadelha.persistence.model.Institution;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface RepositoryInstitution extends JpaRepository<Institution, UUID>, RepositoryInterface<Institution> {

}