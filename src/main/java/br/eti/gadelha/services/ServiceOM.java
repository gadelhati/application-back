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

@Service
public class ServiceOM {

    private final RepositoryOM repositoryOM;

    public ServiceOM(RepositoryOM repositoryOM) {
        this.repositoryOM = repositoryOM;
    }

    public DTOResponseOM create(DTORequestOM created){
//        OM role = MAPPER_ROLE.toObject(created);
        return DTOResponseOM.toDTO(repositoryOM.save(created.toObject()));
    }

    public List<DTOResponseOM> retrieve(){
        List<DTOResponseOM> list = new ArrayList<>();
        for(OM om: repositoryOM.findAll()) {
            list.add(DTOResponseOM.toDTO(om));
        }
        return list;
    }

    public Page<DTOResponseOM> retrieve(Pageable pageable){
        List<DTOResponseOM> list = new ArrayList<>();
        for(OM role: repositoryOM.findAll()) {
            list.add(DTOResponseOM.toDTO(role));
        }
        return new PageImpl<DTOResponseOM>(list, pageable, list.size());
    }
    public DTOResponseOM retrieve(UUID id){
        return DTOResponseOM.toDTO(repositoryOM.findById(id).orElse(null));
    }
    public Page<DTOResponseOM> retrieveSource(Pageable pageable, String source){
        final List<DTOResponseOM> list = new ArrayList<>();
        if (source == null) {
            for (OM role : repositoryOM.findAll()) {
                list.add(DTOResponseOM.toDTO(role));
            }
        } else {
            for (OM role : repositoryOM.findByNameContainingIgnoreCaseOrderByNameAsc(source)) {
                list.add(DTOResponseOM.toDTO(role));
            }
        }
        return new PageImpl<>(list, pageable, list.size());
    }
    public DTOResponseOM update(UUID id, DTORequestOM updated){
        OM object = repositoryOM.findById(id).orElse(null);
        object.setName(updated.getName());
        return DTOResponseOM.toDTO(repositoryOM.save(object));
    }
    public DTOResponseOM delete(UUID id){
        OM object = repositoryOM.findById(id).orElse(null);
        repositoryOM.deleteById(id);
        return DTOResponseOM.toDTO(object);
    }
    public void delete() {
        repositoryOM.deleteAll();
    }

    public boolean isNameValid(String value) {
        return repositoryOM.existsByName(value);
    }
    public OM findByName(String value) { return  repositoryOM.findByName(value); }
}