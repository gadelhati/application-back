package br.eti.gadelha.services;

import br.eti.gadelha.persistence.dto.request.DTORequestSeal;
import br.eti.gadelha.persistence.dto.response.DTOResponseSeal;
import br.eti.gadelha.persistence.model.support.Seal;
import br.eti.gadelha.persistence.repository.RepositorySeal;
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
public class ServiceSeal {

    private final RepositorySeal repository;

    public ServiceSeal(RepositorySeal repository) {
        this.repository = repository;
    }

    public DTOResponseSeal create(DTORequestSeal created){
//        Seal seal = DTORequestSeal.toObject(created);
        return DTOResponseSeal.toDTO(repository.save(created.toObject()));
    }
    public Page<DTOResponseSeal> retrieve(Pageable pageable){
        List<DTOResponseSeal> list = new ArrayList<>();
        for(Seal seal: repository.findAll()) {
            list.add(DTOResponseSeal.toDTO(seal));
        }
        return new PageImpl<DTOResponseSeal>(list, pageable, list.size());
    }
    public DTOResponseSeal retrieve(UUID id){
        return DTOResponseSeal.toDTO(repository.findById(id).get());
    }
    public Page<DTOResponseSeal> retrieveSource(Pageable pageable, String source){
        final List<DTOResponseSeal> list = new ArrayList<>();
        if (source == null) {
            for (Seal seal : repository.findAll()) {
                list.add(DTOResponseSeal.toDTO(seal));
            }
        } else {
            for (Seal seal : repository.findByNumberContainingIgnoreCaseOrderByNumberAsc(source)) {
                list.add(DTOResponseSeal.toDTO(seal));
            }
        }
        return new PageImpl<DTOResponseSeal>(list, pageable, list.size());
    }
    public DTOResponseSeal update(UUID id, DTORequestSeal updated){
        Seal seal = repository.findById(id).get();
        seal.setNumber(updated.getNumber());
        seal.setBroken(updated.isBroken());
        seal.setColor(updated.getColor());
        return DTOResponseSeal.toDTO(repository.save(seal));
    }
    public void delete(UUID id){
        repository.deleteById(id);
    }
    public void delete() {
        repository.deleteAll();
    };

    public boolean isNumberValid(String value) {
        return repository.existsByNumber(value);
    }
}