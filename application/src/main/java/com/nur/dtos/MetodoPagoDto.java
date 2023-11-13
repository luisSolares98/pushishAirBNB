package com.nur.dtos;

import java.util.UUID;

public class MetodoPagoDto {

  public UUID id;
  public String detalle;
  public String tipo;

  public MetodoPagoDto() {}

  public MetodoPagoDto(String detalle, String tipo) {

    this.detalle = detalle;
    this.tipo = tipo;
  }

  @Override
  public String toString() {
    return (
      "{" +
      "detalle:" +
      detalle +
      ", type:'" +
      tipo + '}'
    );
  }
}
