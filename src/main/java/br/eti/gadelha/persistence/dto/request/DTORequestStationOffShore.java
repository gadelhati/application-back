package br.eti.gadelha.persistence.dto.request;

import br.eti.gadelha.persistence.model.unity.*;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter @Builder
public class DTORequestStationOffShore extends DTORequestStation {

    private LocalDateTime first;
    private LocalDateTime last;
    private double latitudeMostBottom;
    private double latitudeMostTop;
    private double longitudeMostRight;
    private double longitudeMostLeft;
    private Platform platform;

    public StationOffShore toObject(){
        return new StationOffShore(first, last, latitudeMostBottom, latitudeMostBottom, longitudeMostLeft, longitudeMostLeft, platform);
    }
}