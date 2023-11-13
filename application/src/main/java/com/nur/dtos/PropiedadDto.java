package com.nur.dtos;

import java.util.UUID;

public class PropiedadDto {
  public UUID id;
  public String nombre;
  public String estado;
  public double precio;
  public PropiedadDto() {}

  public PropiedadDto(UUID id, String nombre, String estado, double precio) {
    this.id = id;
    this.nombre = nombre;
    this.estado = estado;
    this.precio = precio;
  }

}
