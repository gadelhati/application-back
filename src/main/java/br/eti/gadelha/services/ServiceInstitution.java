package br.eti.gadelha.services;

import br.eti.gadelha.persistence.MapStruct;
import br.eti.gadelha.persistence.payload.request.DTORequestInstitution;
import br.eti.gadelha.persistence.payload.response.DTOResponseInstitution;
import br.eti.gadelha.persistence.model.Institution;
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
        return MapStruct.MAPPER.toDTO(repositoryInstitution.save(MapStruct.MAPPER.toObject(created)));
    }
    public DTOResponseInstitution retrieve(UUID id){
        return MapStruct.MAPPER.toDTO(repositoryInstitution.findById(id).orElse(null));
    }
    public List<DTOResponseInstitution> retrieve(){
        List<DTOResponseInstitution> list = new ArrayList<>();
        for(Institution object: repositoryInstitution.findAll()) {
            list.add(MapStruct.MAPPER.toDTO(object));
        }
        return list;
    }
    public Page<DTOResponseInstitution> retrieve(Pageable pageable){
        List<DTOResponseInstitution> list = new ArrayList<>();
        for(Institution object: repositoryInstitution.findAll()) {
            list.add(MapStruct.MAPPER.toDTO(object));
        }
        return new PageImpl<DTOResponseInstitution>(list, pageable, list.size());
    }
    public Page<DTOResponseInstitution> retrieve(Pageable pageable, String source){
        final List<DTOResponseInstitution> list = new ArrayList<>();
        if (source == null) {
            for (Institution object : repositoryInstitution.findAll()) {
                list.add(MapStruct.MAPPER.toDTO(object));
            }
        } else {
            for (Institution object : repositoryInstitution.findByNameContainingIgnoreCaseOrderByNameAsc(source)) {
                list.add(MapStruct.MAPPER.toDTO(object));
            }
        }
        return new PageImpl<>(list, pageable, list.size());
    }
    public DTOResponseInstitution update(UUID id, DTORequestInstitution updated){
        return MapStruct.MAPPER.toDTO(repositoryInstitution.save(MapStruct.MAPPER.toObject(updated)));
    }
    public DTOResponseInstitution delete(UUID id){
        Institution object = repositoryInstitution.findById(id).orElse(null);
        repositoryInstitution.deleteById(id);
        return MapStruct.MAPPER.toDTO(object);
    }
    public void delete() {
        repositoryInstitution.deleteAll();
    }
    public Institution findByName(String value) { return  repositoryInstitution.findByName(value); }
    public boolean existsByName(String value) {
        return repositoryInstitution.existsByNameContainingIgnoreCase(value);
    }
}