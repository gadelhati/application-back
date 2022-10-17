package br.eti.gadelha.persistence.repository;

import br.eti.gadelha.persistence.model.synopticObservation.SynopticObservation;
import br.eti.gadelha.persistence.model.synopticObservation.SynopticObservationId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositorySynopticObservation extends JpaRepository<SynopticObservation, SynopticObservationId> {

}