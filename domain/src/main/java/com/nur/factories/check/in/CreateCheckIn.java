package com.nur.factories.check.in;

import java.util.List;
import java.util.UUID;
import com.nur.model.CheckIn;
import com.nur.model.Persona;
import com.nur.model.Propiedad;

public class CreateCheckIn implements CheckInFactory {

  @Override
  public CheckIn create(
    UUID flightId,
    List<Propiedad> avaiblePropiedades,
    Persona persona
  ) {
    return new CheckIn(flightId, avaiblePropiedades, persona);
  }
}
