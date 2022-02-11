package br.eti.gadelha.services;

import br.eti.gadelha.persistence.dto.request.DTORequestOM;
import br.eti.gadelha.persistence.dto.response.DTOResponseOM;
import br.eti.gadelha.persistence.model.OM;
import br.eti.gadelha.persistence.repository.RepositoryOM;
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
public class ServiceOM {

    private final RepositoryOM repository;

    public ServiceOM(RepositoryOM repository) {
        this.repository = repository;
    }

    public DTOResponseOM create(DTORequestOM created){
//        OM role = MAPPER_ROLE.toObject(created);
        return DTOResponseOM.toDTO(repository.save(created.toObject()));
    }
    public Page<DTOResponseOM> retrieve(Pageable pageable){
        List<DTOResponseOM> list = new ArrayList<>();
        for(OM role: repository.findAll()) {
            list.add(DTOResponseOM.toDTO(role));
        }
        return new PageImpl<DTOResponseOM>(list, pageable, list.size());
    }
    public DTOResponseOM retrieve(UUID id){
        return DTOResponseOM.toDTO(repository.findById(id).get());
    }
    public Page<DTOResponseOM> retrieveSource(Pageable pageable, String source){
        final List<DTOResponseOM> list = new ArrayList<>();
        if (source == null) {
            for (OM role : repository.findAll()) {
                list.add(DTOResponseOM.toDTO(role));
            }
        }
//        } else {
//            for (OM role : repository.findByNameContainingIgnoreCaseOrderByNameAsc(source)) {
//                list.add(DTOResponseOM.toDTO(role));
//            }
//        }
        return new PageImpl<DTOResponseOM>(list, pageable, list.size());
    }
    public DTOResponseOM update(UUID id, DTORequestOM updated){
        OM role = repository.findById(id).get();
        role.setName(updated.getName());
        return DTOResponseOM.toDTO(repository.save(role));
    }
    public void delete(UUID id){
        repository.deleteById(id);
    }
    public void delete() {
        repository.deleteAll();
    };

    public boolean isNameValid(String value) {
        return repository.existsByName(value);
    }
    public OM findByName(String value) { return  repository.findByName(value); }
}