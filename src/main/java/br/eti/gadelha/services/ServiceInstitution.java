package br.eti.gadelha.services;

import br.eti.gadelha.persistence.dto.request.DTORequestInstitution;
import br.eti.gadelha.persistence.dto.response.DTOResponseInstitution;
import br.eti.gadelha.persistence.model.unity.Institution;
import br.eti.gadelha.persistence.repository.RepositoryInstitution;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class ServiceInstitution {

    private final RepositoryInstitution repository;

    public ServiceInstitution(RepositoryInstitution repository) {
        this.repository = repository;
    }

    public DTOResponseInstitution create(DTORequestInstitution created){
        return DTOResponseInstitution.toDTO(repository.save(created.toObject()));
    }
    public DTOResponseInstitution retrieve(UUID id){
        return DTOResponseInstitution.toDTO(repository.findById(id).orElse(null));
    }
    public List<DTOResponseInstitution> retrieve(){
        List<DTOResponseInstitution> list = new ArrayList<>();
        for(Institution object: repository.findAll()) {
            list.add(DTOResponseInstitution.toDTO(object));
        }
        return list;
    }
    public Page<DTOResponseInstitution> retrieve(Pageable pageable){
        List<DTOResponseInstitution> list = new ArrayList<>();
        for(Institution object: repository.findAll()) {
            list.add(DTOResponseInstitution.toDTO(object));
        }
        return new PageImpl<DTOResponseInstitution>(list, pageable, list.size());
    }
    public Page<DTOResponseInstitution> retrieve(Pageable pageable, String source){
        final List<DTOResponseInstitution> list = new ArrayList<>();
        if (source == null) {
            for (Institution object : repository.findAll()) {
                list.add(DTOResponseInstitution.toDTO(object));
            }
        } else {
            for (Institution object : repository.findByNameContainingIgnoreCaseOrderByNameAsc(source)) {
                list.add(DTOResponseInstitution.toDTO(object));
            }
        }
        return new PageImpl<>(list, pageable, list.size());
    }
    public DTOResponseInstitution update(UUID id, DTORequestInstitution updated){
        Institution object = repository.findById(id).orElse(null);
        object.setName(updated.getName());
        object.setCountry(updated.getCountry());
        return DTOResponseInstitution.toDTO(repository.save(object));
    }
    public DTOResponseInstitution delete(UUID id){
        Institution object = repository.findById(id).orElse(null);
        repository.deleteById(id);
        return DTOResponseInstitution.toDTO(object);
    }
    public void delete() {
        repository.deleteAll();
    }

    public Institution findByName(String value) { return  repository.findByName(value); }
}