package br.eti.gadelha.persistence.payload.response;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class DTOResponseTokenRefresh {
    private String accessToken;
    private String refreshToken;
    private String tokenType = "Bearer";

    public DTOResponseTokenRefresh(String accessToken, String refreshToken) {
        this.accessToken = accessToken;
        this.refreshToken = refreshToken;
    }
}