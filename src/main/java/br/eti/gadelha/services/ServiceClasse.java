package br.eti.gadelha.services;

import br.eti.gadelha.persistence.dto.request.DTORequestClasse;
import br.eti.gadelha.persistence.dto.response.DTOResponseClasse;
import br.eti.gadelha.persistence.model.Classe;
import br.eti.gadelha.persistence.repository.RepositoryClasse;
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
public class ServiceClasse {

    private final RepositoryClasse repository;

    public ServiceClasse(RepositoryClasse repository) {
        this.repository = repository;
    }

    public DTOResponseClasse create(DTORequestClasse created){
//        Classe classe = DTOResponseClasse.toObject(created);
        return DTOResponseClasse.toDTO(repository.save(created.toObject()));
    }
    public Page<DTOResponseClasse> retrieve(Pageable pageable){
        List<DTOResponseClasse> list = new ArrayList<>();
        for(Classe classe: repository.findAll()) {
            list.add(DTOResponseClasse.toDTO(classe));
        }
        return new PageImpl<DTOResponseClasse>(list, pageable, list.size());
    }
    public DTOResponseClasse retrieve(UUID id){
        return DTOResponseClasse.toDTO(repository.findById(id).get());
    }
    public Page<DTOResponseClasse> retrieveSource(Pageable pageable, String source){
        final List<DTOResponseClasse> list = new ArrayList<>();
        if (source == null) {
            for (Classe classe : repository.findAll()) {
                list.add(DTOResponseClasse.toDTO(classe));
            }
        } else {
            for (Classe classe : repository.findByNameContainingIgnoreCaseOrderByNameAsc(source)) {
                list.add(DTOResponseClasse.toDTO(classe));
            }
        }
        return new PageImpl<DTOResponseClasse>(list, pageable, list.size());
    }
    public DTOResponseClasse update(UUID id, DTORequestClasse updated){
//        TREXO DE CÓDIGO FUNCIONA SEM PROBLEMAS SE O DTO FOR IDENTICO AO OBJETO
//        Classe classe = mapStructMapper.toObject(updated);
//        classe.setId(repository.findById(id).get().getId());
        Classe classe = repository.findById(id).get();
        classe.setName(updated.getName());
        classe.setName2(updated.getName2());
        return DTOResponseClasse.toDTO(repository.save(classe));
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
}