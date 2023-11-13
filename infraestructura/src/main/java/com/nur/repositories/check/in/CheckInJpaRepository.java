package com.nur.repositories.check.in;

import com.nur.model.CheckIn;
import com.nur.model.CheckInJpaModel;
import com.nur.model.PersonaJpaModel;
import com.nur.model.PropiedadJpaModel;
import com.nur.utils.CheckInUtils;
import com.nur.utils.PersonaUtils;
import com.nur.utils.PropiedadUtils;
import com.nur.core.BusinessRuleValidationException;
import com.nur.repositories.persona.PersonaCrudRepository;
import com.nur.repositories.propiedad.PropiedadCrudRepository;

import java.util.*;
// import javax.transaction.Transactional;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.nur.repositories.CheckInRepository;

@Repository
public class CheckInJpaRepository implements CheckInRepository {

  @Autowired
  private CheckInCrudRepository checkInCrudRepository;

  @Autowired
  private PersonaCrudRepository passangerCrudRepository;

  @Autowired
  private PropiedadCrudRepository seatCrudRepository;

  @Override
  @Transactional
  public UUID update(CheckIn checkIn) {
    CheckInJpaModel checkInJpaModel = new CheckInJpaModel();
    checkInJpaModel.setPropiedadId(checkIn.getPropiedadId());
    checkInJpaModel.setDate(checkIn.getDate());
    checkInJpaModel.setId(checkIn.getId());
    checkInJpaModel.setPersona(
      PersonaUtils.passangerToJpaEntity(checkIn.getPersona())
    );

    if (checkIn.getPropiedad() != null) {
      checkInJpaModel.setPropiedad(PropiedadUtils.propiedadToJpaEntity(checkIn.getPropiedad()));
    }
    return checkInCrudRepository.save(checkInJpaModel).getId();
  }

  @Override
  public CheckIn get(UUID id) {
    try {
      return CheckInUtils.jpaModelToCheckIn(
        checkInCrudRepository.findById(id).orElse(null),
        new ArrayList<>()
      );
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
  }

  @Override
  public CheckIn findByPersonAndId(UUID passengerId, UUID flightId)
    throws BusinessRuleValidationException {
    PersonaJpaModel passangerJpaModel = passangerCrudRepository
      .findById(passengerId)
      .orElse(null);
    if (passangerJpaModel == null) return null;
    CheckInJpaModel model = checkInCrudRepository.findByPersonaAndPersonaId(
      passangerJpaModel,
      flightId
    );
    if (model != null) {
      List<PropiedadJpaModel> seatsAvailable = seatCrudRepository.findPropiedadById(
        flightId
      );
      return CheckInUtils.jpaModelToCheckIn(model, seatsAvailable);
    }
    return null;
  }
}
