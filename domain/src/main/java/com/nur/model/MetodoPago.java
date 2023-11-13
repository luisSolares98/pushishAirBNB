package com.nur.model;

import com.nur.core.BusinessRuleValidationException;
import com.nur.core.Entity;
import lombok.Getter;

import java.util.UUID;

@Getter
public class MetodoPago extends Entity {

  private String detalle;
  private MetodoTipo type;

  public MetodoPago(String detalle, String tipo)
    throws BusinessRuleValidationException {
    this.id = UUID.randomUUID();
    this.detalle = detalle;
    if (tipo == "T") type = MetodoTipo.TARJETA; else type =
      MetodoTipo.PAYPAL;
  }

}
