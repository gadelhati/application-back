package br.eti.gadelha.persistence.repository;

import br.eti.gadelha.persistence.model.unity.Equipment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface RepositoryEquipment extends JpaRepository<Equipment, UUID> {
    List<Equipment> findByNameContainingIgnoreCaseOrderByNameAsc(String name);
    Equipment findByName(String name);
}