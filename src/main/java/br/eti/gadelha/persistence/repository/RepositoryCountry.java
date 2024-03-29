package br.eti.gadelha.persistence.repository;

import br.eti.gadelha.persistence.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface RepositoryCountry extends JpaRepository<Country, UUID>, RepositoryInterface<Country> {

}