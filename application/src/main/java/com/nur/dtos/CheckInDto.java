package com.nur.dtos;

import java.util.Date;
import java.util.List;

public class CheckInDto {

  public String checkInId;
  public String propiedadId;
  public Date date;
  public PropiedadDto propiedad;
  public List<PropiedadDto> avaiblePropiedades;
  public PersonaDto persona;

  public CheckInDto() {}

  public CheckInDto(
    String checkInId,
    String propiedadId,
    Date date,
    PropiedadDto propiedad,

    List<PropiedadDto> avaiblePropiedades,
    PersonaDto passanger
  ) {
    this.checkInId = checkInId;
    this.propiedadId = propiedadId;
    this.date = date;
    this.propiedad = propiedad;
    this.avaiblePropiedades = avaiblePropiedades;
    this.persona = passanger;
  }
}
