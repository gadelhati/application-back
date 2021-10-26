package br.eti.gadelha.persistence.payload.request;

import java.util.UUID;

public class LogOutRequest {
  private UUID userId;

  public UUID getUserId() {
    return this.userId;
  }
}