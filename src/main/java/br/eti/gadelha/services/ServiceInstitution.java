package br.eti.gadelha.services;

import br.eti.gadelha.persistence.payload.request.DTORequestInstitution;
import br.eti.gadelha.persistence.payload.response.DTOResponseInstitution;
import br.eti.gadelha.persistence.model.unity.Institution;
import br.eti.gadelha.persistence.repository.RepositoryInstitution;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service @RequiredArgsConstructor
public class ServiceInstitution implements ServiceInterface<DTOResponseInstitution, DTORequestInstitution, Institution> {

    private final RepositoryInstitution repositoryInstitution;

    public DTOResponseInstitution create(DTORequestInstitution created){
        return DTOResponseInstitution.toDTO(repositoryInstitution.save(created.toObject()));
    }
    public DTOResponseInstitution retrieve(UUID id){
        return DTOResponseInstitution.toDTO(repositoryInstitution.findById(id).orElse(null));
    }
    public List<DTOResponseInstitution> retrieve(){
        List<DTOResponseInstitution> list = new ArrayList<>();
        for(Institution object: repositoryInstitution.findAll()) {
            list.add(DTOResponseInstitution.toDTO(object));
        }
        return list;
    }
    public Page<DTOResponseInstitution> retrieve(Pageable pageable){
        List<DTOResponseInstitution> list = new ArrayList<>();
        for(Institution object: repositoryInstitution.findAll()) {
            list.add(DTOResponseInstitution.toDTO(object));
        }
        return new PageImpl<DTOResponseInstitution>(list, pageable, list.size());
    }
    public Page<DTOResponseInstitution> retrieve(Pageable pageable, String source){
        final List<DTOResponseInstitution> list = new ArrayList<>();
        if (source == null) {
            for (Institution object : repositoryInstitution.findAll()) {
                list.add(DTOResponseInstitution.toDTO(object));
            }
        } else {
            for (Institution object : repositoryInstitution.findByNameContainingIgnoreCaseOrderByNameAsc(source)) {
                list.add(DTOResponseInstitution.toDTO(object));
            }
        }
        return new PageImpl<>(list, pageable, list.size());
    }
    public DTOResponseInstitution update(UUID id, DTORequestInstitution updated){
        Institution object = repositoryInstitution.findById(id).orElse(null);
        object.setName(updated.getName());
        object.setCountry(updated.getCountry());
        return DTOResponseInstitution.toDTO(repositoryInstitution.save(object));
    }
    public DTOResponseInstitution delete(UUID id){
        Institution object = repositoryInstitution.findById(id).orElse(null);
        repositoryInstitution.deleteById(id);
        return DTOResponseInstitution.toDTO(object);
    }
    public void delete() {
        repositoryInstitution.deleteAll();
    }
    public Institution findByName(String value) { return  repositoryInstitution.findByName(value); }
    public boolean existsByName(String value) {
        return repositoryInstitution.existsByName(value);
    }
}