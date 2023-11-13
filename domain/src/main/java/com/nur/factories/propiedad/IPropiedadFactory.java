package com.nur.factories.propiedad;


import com.nur.core.BusinessRuleValidationException;
import com.nur.model.Propiedad;

import java.util.UUID;

public interface IPropiedadFactory {
    Propiedad create(UUID id, String nombre, String estado, double precio) throws BusinessRuleValidationException;
}
