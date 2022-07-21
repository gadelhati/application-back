package br.eti.gadelha.persistence.dto.request;

import br.eti.gadelha.persistence.model.File;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter @AllArgsConstructor
public class DTORequestFile {

    private String fileName;
    private String fileType;
    private long size;

    public File toObject(){
        return new File(fileName, fileType, size);
    }
}