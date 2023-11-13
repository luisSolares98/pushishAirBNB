package com.nur.model;

import com.nur.core.Entity;
import lombok.Getter;

import java.util.UUID;
@Getter
public class Transaccion extends Entity {

  private UUID code;
  private String descripcion;
  private Double monto;


  public Transaccion(UUID code, String descripcion, Double monto) {
    this.code = code;
    this.descripcion = descripcion;
    this.monto = monto;
  }

}
