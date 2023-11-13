package com.nur.dtos;

import java.util.UUID;

public class TipoPropiedadDto {
  public UUID id;
  public String nombreTipo;

  public TipoPropiedadDto() {}

  public TipoPropiedadDto(UUID id, String nombreTipo) {
    this.id = id;
    this.nombreTipo = nombreTipo;
  }
}
