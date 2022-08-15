package br.eti.gadelha.persistence.repository;

import br.eti.gadelha.persistence.model.unity.Manufacturer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface RepositoryManufacturer extends JpaRepository<Manufacturer, UUID> {
    List<Manufacturer> findByNameContainingIgnoreCaseOrderByNameAsc(String name);
    Manufacturer findByName(String name);
}