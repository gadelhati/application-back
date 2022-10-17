package br.eti.gadelha.persistence.repository;

import br.eti.gadelha.persistence.model.Equipment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface RepositoryEquipment extends JpaRepository<Equipment, UUID>, RepositoryInterface<Equipment> {

}