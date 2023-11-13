package com.nur.factories.tipo;

import com.nur.core.BusinessRuleValidationException;
import com.nur.model.TipoPropiedad;

import java.util.UUID;

public interface TipoFactory {
    TipoPropiedad create(UUID id, String nombre) throws BusinessRuleValidationException;
}
