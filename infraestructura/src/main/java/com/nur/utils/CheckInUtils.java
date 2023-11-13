package com.nur.utils;

import com.nur.annotations.Generated;
import com.nur.model.CheckIn;
import com.nur.model.Propiedad;
import com.nur.core.BusinessRuleValidationException;
import com.nur.model.CheckInJpaModel;
import com.nur.model.PropiedadJpaModel;

import java.util.ArrayList;
import java.util.List;

@Generated
public class CheckInUtils {

  public static CheckIn jpaModelToCheckIn(
    CheckInJpaModel jpaModel,
    List<PropiedadJpaModel> propiedades
  ) throws BusinessRuleValidationException {
    if (jpaModel == null) return null;
    List<Propiedad> seatsAvailable = new ArrayList<>();
    for (PropiedadJpaModel seatJpaModel : propiedades) {
      seatsAvailable.add(PropiedadUtils.jpaModelToPropiedad(seatJpaModel));
    }
    /*Persona persona = null;
    if (jpaModel.getPersona() != null) {
      persona = PropiedadUtils.jpaModelToPropiedad(jpaModel.getPropiedad());
    }*/

    /*List<MetodoPago> baggages = new ArrayList<>();
    for (MetodoPagoJpaModel baggageJpaModel : jpaModel.getBaggages()) {
      baggages.add(MetodoPagoUtils.jpaToBaggage(baggageJpaModel));
    }**/

    return new CheckIn(
      jpaModel.getId(),
      jpaModel.getPropiedadId(),
      jpaModel.getDate(),
      PropiedadUtils.jpaModelToPropiedad(jpaModel.getPropiedad()),
      seatsAvailable,
      PersonaUtils.jpaModelToPassanger(jpaModel.getPersona())
    );

  }
}
