package br.eti.gadelha.persistence.repository;

import br.eti.gadelha.persistence.model.servico.Militar;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

/**
 * @author	Marcelo Ribeiro Gadelha
 * @mail	gadelha.ti@gmail.com
 * @link	www.gadelha.eti.br
 **/

public interface RepositoryMilitar extends JpaRepository<Militar, UUID> {

}