package br.eti.gadelha.services;

import br.eti.gadelha.persistence.MapStruct;
import br.eti.gadelha.persistence.payload.request.DTORequestCompany;
import br.eti.gadelha.persistence.payload.response.DTOResponseCompany;
import br.eti.gadelha.persistence.model.Company;
import br.eti.gadelha.persistence.repository.RepositoryCompany;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service @RequiredArgsConstructor
public class ServiceCompany implements ServiceInterface<DTOResponseCompany, DTORequestCompany, Company> {

    private final RepositoryCompany repositoryCompany;

    public DTOResponseCompany create(DTORequestCompany created){
        return MapStruct.MAPPER.toDTO(repositoryCompany.save(MapStruct.MAPPER.toObject(created)));
    }
    public List<DTOResponseCompany> retrieve(){
        List<DTOResponseCompany> list = new ArrayList<>();
        for(Company om: repositoryCompany.findAll()) {
            list.add(MapStruct.MAPPER.toDTO(om));
        }
        return list;
    }
    public Page<DTOResponseCompany> retrieve(Pageable pageable){
        List<DTOResponseCompany> list = new ArrayList<>();
        for(Company role: repositoryCompany.findAll()) {
            list.add(MapStruct.MAPPER.toDTO(role));
        }
        return new PageImpl<DTOResponseCompany>(list, pageable, list.size());
    }
    public Page<DTOResponseCompany> retrieve(Pageable pageable, String source) {
        List<DTOResponseCompany> list = new ArrayList<>();
        for(Company object: repositoryCompany.findAll()) {
            list.add(MapStruct.MAPPER.toDTO(object));
        }
        return new PageImpl<DTOResponseCompany>(list, pageable, list.size());
    }
    public DTOResponseCompany retrieve(UUID id){
        return MapStruct.MAPPER.toDTO(repositoryCompany.findById(id).orElse(null));
    }
    public Page<DTOResponseCompany> retrieveSource(Pageable pageable, String source){
        final List<DTOResponseCompany> list = new ArrayList<>();
        if (source == null) {
            for (Company role : repositoryCompany.findAll()) {
                list.add(MapStruct.MAPPER.toDTO(role));
            }
        } else {
            for (Company role : repositoryCompany.findByNameContainingIgnoreCaseOrderByNameAsc(source)) {
                list.add(MapStruct.MAPPER.toDTO(role));
            }
        }
        return new PageImpl<>(list, pageable, list.size());
    }
    public DTOResponseCompany update(UUID id, DTORequestCompany updated){
        return MapStruct.MAPPER.toDTO(repositoryCompany.save(MapStruct.MAPPER.toObject(updated)));
    }
    public DTOResponseCompany delete(UUID id){
        Company object = repositoryCompany.findById(id).orElse(null);
        repositoryCompany.deleteById(id);
        return MapStruct.MAPPER.toDTO(object);
    }
    public void delete() {
        repositoryCompany.deleteAll();
    }
    public Company findByName(String value) { return  repositoryCompany.findByName(value); }
    public boolean existsByName(String value) {
        return repositoryCompany.existsByNameContainingIgnoreCase(value);
    }
}