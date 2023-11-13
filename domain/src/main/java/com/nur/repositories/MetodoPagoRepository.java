package com.nur.repositories;

import com.nur.core.BusinessRuleValidationException;
import java.util.List;
import java.util.UUID;
import com.nur.model.MetodoPago;

public interface MetodoPagoRepository {
  UUID update(MetodoPago baggage);

  List<MetodoPago> findMetodoPagoById(UUID metodoId)
    throws BusinessRuleValidationException;
}
