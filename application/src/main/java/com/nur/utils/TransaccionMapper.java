package com.nur.utils;

import com.nur.dtos.TransactionDto;
import com.nur.model.Transaccion;

public final class TransaccionMapper {

  public static TransactionDto from(Transaccion seat) {
    if (seat == null) return new TransactionDto();
    return new TransactionDto(
      seat.getCode() == null ? "" : seat.getCode().toString(),
      seat.getDescripcion() == null ? "" : seat.getDescripcion(),
      seat.getMonto() == null ? 0.0 : seat.getMonto()
    );
  }
}
