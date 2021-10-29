package br.eti.gadelha.services;

import br.eti.gadelha.persistence.dto.request.DTORequestServico;
import br.eti.gadelha.persistence.dto.response.DTOResponseServico;
import br.eti.gadelha.persistence.model.servico.Servico;
import br.eti.gadelha.persistence.repository.RepositoryServico;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @author	Marcelo Ribeiro Gadelha
 * @mail	gadelha.ti@gmail.com
 * @link	www.gadelha.eti.br
 **/

@Service
public class ServiceServico {

    private final RepositoryServico repository;

    public ServiceServico(RepositoryServico repository) {
        this.repository = repository;
    }

    public DTOResponseServico create(DTORequestServico created){
        return DTOResponseServico.toDTO(repository.save(created.toObject()));
    }

    public List<DTOResponseServico> retrieveAll(){
        List<DTOResponseServico> list = new ArrayList<>();
        for(Servico servico: repository.findAll()) {
            list.add(DTOResponseServico.toDTO(servico));
        }
        return list;
    }

    public Page<DTOResponseServico> retrieve(Pageable pageable){
        List<DTOResponseServico> list = new ArrayList<>();
        for(Servico servico: repository.findAll()) {
            list.add(DTOResponseServico.toDTO(servico));
        }
        return new PageImpl<DTOResponseServico>(list, pageable, list.size());
    }
    public DTOResponseServico retrieve(UUID id){
        return DTOResponseServico.toDTO(repository.findById(id).get());
    }
    public Page<DTOResponseServico> retrieveSource(Pageable pageable, String source){
        final List<DTOResponseServico> list = new ArrayList<>();
        if (source == null) {
            for (Servico servico : repository.findAll()) {
                list.add(DTOResponseServico.toDTO(servico));
            }
        } /*else {
            for (Servico Servico : repository.findByEstacaoContainingIgnoreCaseOrderByEstacaoAsc(source)) {
                list.add(DTOResponseServico.toDTO(Servico));
            }
        }*/
        return new PageImpl<DTOResponseServico>(list, pageable, list.size());
    }
    public DTOResponseServico update(UUID id, DTORequestServico updated){
        Servico servico = repository.findById(id).get();
        servico.setS1(updated.getS1());
        servico.setS2(updated.getS2());
        servico.setData(updated.getData());
        return DTOResponseServico.toDTO(repository.save(servico));
    }
    public void delete(UUID id){
        repository.deleteById(id);
    }
    public void delete() {
        repository.deleteAll();
    };
}