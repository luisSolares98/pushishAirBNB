package com.nur.utils;

import com.nur.annotations.Generated;
import com.nur.core.BusinessRuleValidationException;
import com.nur.model.PersonaJpaModel;
import com.nur.model.Persona;

@Generated
public class PersonaUtils {

  public static PersonaJpaModel passangerToJpaEntity(Persona passanger) {
    PersonaJpaModel passangerJpaModel = new PersonaJpaModel();
    passangerJpaModel.setCi(passanger.getCi());
    passangerJpaModel.setId(passanger.getId());
    passangerJpaModel.setLastname(passanger.getLastname());
    passangerJpaModel.setName(passanger.getName());
    return passangerJpaModel;
  }

  public static Persona jpaModelToPassanger(PersonaJpaModel jpaModel)
    throws BusinessRuleValidationException {
    return new Persona(
      jpaModel.getName(),
      jpaModel.getLastname(),
      jpaModel.getCi()
    );
  }
}
