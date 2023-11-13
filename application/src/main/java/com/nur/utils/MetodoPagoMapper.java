package com.nur.utils;

import com.nur.core.BusinessRuleValidationException;
import com.nur.dtos.MetodoPagoDto;
import com.nur.model.MetodoPago;

public final class MetodoPagoMapper {

  public static MetodoPagoDto from(MetodoPago baggage) {
    if (baggage == null) return new MetodoPagoDto();
    return new MetodoPagoDto(
      baggage.getDetalle(),
      baggage.getType().toString()
    );
  }

  public static MetodoPago from(MetodoPagoDto baggageDto)
    throws BusinessRuleValidationException {
    return new MetodoPago(
      baggageDto.detalle,
      baggageDto.tipo
    );
  }
}
