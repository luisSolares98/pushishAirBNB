package com.nur.repositories;

import com.nur.core.BusinessRuleValidationException;
import java.util.List;
import java.util.UUID;
import com.nur.model.Persona;

public interface PersonaRepository {
  UUID update(Persona passanger);

  Persona get(UUID id) throws BusinessRuleValidationException;

  List<Persona> getAll() throws BusinessRuleValidationException;
}
