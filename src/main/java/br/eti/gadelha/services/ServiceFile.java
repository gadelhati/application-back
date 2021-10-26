package br.eti.gadelha.services;

import br.eti.gadelha.persistence.dto.request.DTORequestFile;
import br.eti.gadelha.persistence.dto.response.DTOResponseFile;
import br.eti.gadelha.persistence.model.File;
import br.eti.gadelha.persistence.repository.RepositoryFile;
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
public class ServiceFile {

    private final RepositoryFile repository;

    public ServiceFile(RepositoryFile repository) {
        this.repository = repository;
    }

    public DTOResponseFile create(DTORequestFile created){
        return DTOResponseFile.toDTO(repository.save(created.toObject()));
    }
    public Page<DTOResponseFile> retrieve(Pageable pageable){
        List<DTOResponseFile> list = new ArrayList<>();
        for(File file: repository.findAll()) {
            list.add(DTOResponseFile.toDTO(file));
        }
        return new PageImpl<DTOResponseFile>(list, pageable, list.size());
    }
    public DTOResponseFile retrieve(UUID id){
        return DTOResponseFile.toDTO(repository.findById(id).get());
    }
    public Page<DTOResponseFile> retrieveSource(Pageable pageable, String source){
        final List<DTOResponseFile> list = new ArrayList<>();
        if (source == null) {
            for (File file : repository.findAll()) {
                list.add(DTOResponseFile.toDTO(file));
            }
        } else {
            for (File file : repository.findByFileNameContainingIgnoreCaseOrderByFileNameAsc(source)) {
                list.add(DTOResponseFile.toDTO(file));
            }
        }
        return new PageImpl<DTOResponseFile>(list, pageable, list.size());
    }
    public DTOResponseFile update(UUID id, DTORequestFile updated){
        File file = repository.findById(id).get();
        file.setFileName(updated.getFileName());
        file.setFileType(updated.getFileType());
        file.setSize(updated.getSize());
        return DTOResponseFile.toDTO(repository.save(file));
    }
    public void delete(UUID id){
        repository.deleteById(id);
    }
    public void delete() {
        repository.deleteAll();
    };

    public boolean isFileNameValid(String value) {
        return repository.existsByFileName(value);
    }
}