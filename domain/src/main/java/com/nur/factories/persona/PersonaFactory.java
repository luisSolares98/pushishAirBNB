package com.nur.factories.persona;

import com.nur.core.BusinessRuleValidationException;
import com.nur.model.Persona;

public interface PersonaFactory {
  Persona create(
    String name,
    String lastname,
    String ci

  ) throws BusinessRuleValidationException;
}
