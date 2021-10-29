package br.eti.gadelha.persistence.repository;

import br.eti.gadelha.persistence.model.servico.Servico;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

/**
 * @author	Marcelo Ribeiro Gadelha
 * @mail	gadelha.ti@gmail.com
 * @link	www.gadelha.eti.br
 **/

public interface RepositoryServico extends JpaRepository<Servico, UUID> {

}