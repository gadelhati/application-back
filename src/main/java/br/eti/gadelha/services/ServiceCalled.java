package br.eti.gadelha.services;

import br.eti.gadelha.persistence.dto.request.DTORequestCalled;
import br.eti.gadelha.persistence.dto.response.DTOResponseCalled;
import br.eti.gadelha.persistence.model.support.Called;
import br.eti.gadelha.persistence.repository.RepositoryCalled;
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
public class ServiceCalled {

    private final RepositoryCalled repository;

    public ServiceCalled(RepositoryCalled repository) {
        this.repository = repository;
    }

    public DTOResponseCalled create(DTORequestCalled created){
//        Called classe = DTORequestCalled.toObject(created);
        return DTOResponseCalled.toDTO(repository.save(created.toObject()));
    }
    public Page<DTOResponseCalled> retrieve(Pageable pageable){
        List<DTOResponseCalled> list = new ArrayList<>();
        for(Called classe: repository.findAll()) {
            list.add(DTOResponseCalled.toDTO(classe));
        }
        return new PageImpl<DTOResponseCalled>(list, pageable, list.size());
    }
    public DTOResponseCalled retrieve(UUID id){
        return DTOResponseCalled.toDTO(repository.findById(id).get());
    }
    public Page<DTOResponseCalled> retrieveSource(Pageable pageable, String source){
        final List<DTOResponseCalled> list = new ArrayList<>();
        if (source == null) {
            for (Called classe : repository.findAll()) {
                list.add(DTOResponseCalled.toDTO(classe));
            }
        } else {
            for (Called classe : repository.findByNumberContainingIgnoreCaseOrderByNumberAsc(source)) {
                list.add(DTOResponseCalled.toDTO(classe));
            }
        }
        return new PageImpl<DTOResponseCalled>(list, pageable, list.size());
    }
    public DTOResponseCalled update(UUID id, DTORequestCalled updated){
        Called called = repository.findById(id).get();
        called.setEntrance(updated.getEntrance());
        called.setExit(updated.getExit());
        called.setDeliveryman(updated.getDeliveryman());
        called.setReceiver(updated.getReceiver());
        called.setDelivery(updated.getDelivery());
        called.setReceivement(updated.getReceivement());
        called.setNumber(updated.getNumber());
        called.setHost(updated.getHost());
        return DTOResponseCalled.toDTO(repository.save(called));
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