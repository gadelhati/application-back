package br.eti.gadelha.persistence.dto.response;

import br.eti.gadelha.persistence.model.File;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter @AllArgsConstructor
public class DTOResponseFile {

    private String fileName;
    private String fileType;
    private long size;

    public static DTOResponseFile toDTO(File value) {
        return new DTOResponseFile(value.getFileName(), value.getFileType(), value.getSize());
    }
}