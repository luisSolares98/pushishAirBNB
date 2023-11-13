package com.nur.repositories.persona;

import com.nur.model.PersonaJpaModel;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;

public interface PersonaCrudRepository
  extends CrudRepository<PersonaJpaModel, UUID> {}
