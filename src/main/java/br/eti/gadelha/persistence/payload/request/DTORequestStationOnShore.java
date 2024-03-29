package br.eti.gadelha.persistence.payload.request;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter @Builder
public class DTORequestStationOnShore extends DTORequestStation {

    private long number;
    private String name;
    private long altitude;
    private boolean status;
    private LocalDateTime deactivation;
}