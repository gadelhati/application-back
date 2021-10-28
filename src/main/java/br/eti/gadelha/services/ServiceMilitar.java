package br.eti.gadelha.services;

import br.eti.gadelha.persistence.dto.request.DTORequestMilitar;
import br.eti.gadelha.persistence.dto.response.DTOResponseMilitar;
import br.eti.gadelha.persistence.model.servico.Militar;
import br.eti.gadelha.persistence.repository.RepositoryMilitar;
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
public class ServiceMilitar {

    private final RepositoryMilitar repository;

    public ServiceMilitar(RepositoryMilitar repository) {
        this.repository = repository;
    }

    public DTOResponseMilitar create(DTORequestMilitar created){
        return DTOResponseMilitar.toDTO(repository.save(created.toObject()));
    }

    public List<DTOResponseMilitar> retrieveAll(){
        List<DTOResponseMilitar> list = new ArrayList<>();
        for(Militar militar: repository.findAll()) {
            list.add(DTOResponseMilitar.toDTO(militar));
        }
        return list;
    }

    public Page<DTOResponseMilitar> retrieve(Pageable pageable){
        List<DTOResponseMilitar> list = new ArrayList<>();
        for(Militar militar: repository.findAll()) {
            list.add(DTOResponseMilitar.toDTO(militar));
        }
        return new PageImpl<DTOResponseMilitar>(list, pageable, list.size());
    }
    public DTOResponseMilitar retrieve(UUID id){
        return DTOResponseMilitar.toDTO(repository.findById(id).get());
    }
    public Page<DTOResponseMilitar> retrieveSource(Pageable pageable, String source){
        final List<DTOResponseMilitar> list = new ArrayList<>();
        if (source == null) {
            for (Militar militar : repository.findAll()) {
                list.add(DTOResponseMilitar.toDTO(militar));
            }
        } /*else {
            for (Militar Militar : repository.findByEstacaoContainingIgnoreCaseOrderByEstacaoAsc(source)) {
                list.add(DTOResponseMilitar.toDTO(Militar));
            }
        }*/
        return new PageImpl<DTOResponseMilitar>(list, pageable, list.size());
    }
    public DTOResponseMilitar update(UUID id, DTORequestMilitar updated){
        Militar militar = repository.findById(id).get();
        militar.setClti(updated.isClti());

        militar.setEspecialidade(updated.getEspecialidade());
        militar.setNip(updated.getNip());
        militar.setNomeDeGuerra(updated.getNomeDeGuerra());
        militar.setNome(updated.getNome());
        militar.setFuncao(updated.getFuncao());
        return DTOResponseMilitar.toDTO(repository.save(militar));
    }
    public void delete(UUID id){
        repository.deleteById(id);
    }
    public void delete() {
        repository.deleteAll();
    };

    public List<DTOResponseMilitar> disponivel(){
        List<DTOResponseMilitar> list = new ArrayList<>();
        for(Militar militar: repository.findAll()) {
            //MILITAR NÃO AFASTADO
            if(!militar.isAfastado()) {
                list.add(DTOResponseMilitar.toDTO(militar));
            }
        }
        return list;
    }
}