package com.nur.factories.transaccion;

import com.nur.core.BusinessRuleValidationException;
import com.nur.model.Transaccion;

public interface TransaccionFactory {
  Transaccion create(String code, String descripcion, double monto)
    throws BusinessRuleValidationException;
}
