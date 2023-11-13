package com.nur.repositories.persona;

import com.nur.model.PersonaJpaModel;
import com.nur.utils.PersonaUtils;
import com.nur.core.BusinessRuleValidationException;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import com.nur.model.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Repository;
import com.nur.repositories.PersonaRepository;

@Repository
public class PersonaJpaRepository implements PersonaRepository {

  @Autowired
  private PersonaCrudRepository passangerCrudRepository;

  @Override
  public UUID update(Persona passanger) {
    PersonaJpaModel jpaModel = PersonaUtils.passangerToJpaEntity(passanger);
    return passangerCrudRepository.save(jpaModel).getId();
  }

  @Override
  public Persona get(UUID id) throws BusinessRuleValidationException {
    PersonaJpaModel jpaModel = passangerCrudRepository
      .findById(id)
      .orElse(null);
    if (jpaModel == null) return null;
    return PersonaUtils.jpaModelToPassanger(jpaModel);
  }

  @Override
  public List<Persona> getAll() throws BusinessRuleValidationException {
    List<PersonaJpaModel> jpaModels = Streamable
      .of(passangerCrudRepository.findAll())
      .toList();
    List<Persona> passengers = new ArrayList<>();
    for (PersonaJpaModel jpaModel : jpaModels) {
      passengers.add(PersonaUtils.jpaModelToPassanger(jpaModel));
    }
    return passengers;
  }
}
