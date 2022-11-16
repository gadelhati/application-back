package br.eti.gadelha.persistence.repository;

import br.eti.gadelha.persistence.model.synopticObservation.Observer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.util.Streamable;

import java.util.UUID;

public interface RepositoryObserver extends JpaRepository<Observer, UUID>, RepositoryInterface<Observer> {
    boolean existsByNipIgnoreCase(String value);
    boolean existsByNameIgnoreCase(String value);
    boolean existsById(UUID value);
    boolean existsByIdAndNip(UUID id, String nip);
    boolean existsByIdAndNameIgnoringCase(UUID id, String name);
//    @Query("SELECT EXISTS (SELECT c FROM Observer c WHERE c.name = ?1 and c.id != ?2)")
//    boolean searchNameAndId(String name, UUID id);
//    @Query("SELECT EXISTS (SELECT c FROM Observer c WHERE c.nip = ?1 and c.id != ?2)")
//    boolean searchNipAndId(String name, UUID id);
    Streamable<Observer> findByNameContaining(String value);
    Streamable<Observer> findByNip(String value);
    Streamable<Observer> findByIdNot(UUID value);
//    Observer findByName(String value);
}