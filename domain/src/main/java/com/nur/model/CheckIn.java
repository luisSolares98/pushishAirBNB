package com.nur.model;

import com.nur.event.CheckInCompleted;
import com.nur.core.AggregateRoot;
import com.nur.core.BusinessRuleValidationException;
import com.nur.event.PropiedadAssigned;
import lombok.Getter;

import java.util.Date;
import java.util.List;
import java.util.UUID;
@Getter
public class CheckIn extends AggregateRoot {

  private UUID propiedadId;
  private Date date;
  private Propiedad propiedad;
  //private List<Baggage> baggages;
  private List<Propiedad> avaiblePropiedades;
  private Persona persona;

  public CheckIn(UUID propiedadId, List<Propiedad> propiedadListAvailable, Persona persona) {
    this.propiedadId = propiedadId;
    this.avaiblePropiedades = propiedadListAvailable;
    this.persona = persona;
    this.date = new Date();
  }


  public CheckIn(UUID id,UUID propiedadId, Date date, Propiedad propiedad, List<Propiedad> avaiblePropiedades, Persona persona) {
    this.id = id;
    this.propiedadId = propiedadId;
    this.date = date;
    this.propiedad = propiedad;
    this.avaiblePropiedades = avaiblePropiedades;
    this.persona = persona;
  }

  public void assignPropiedad(UUID propiedadCode) throws BusinessRuleValidationException {
    Propiedad targetSeat = avaiblePropiedades
      .stream()
      .filter(s -> s.getId().equals(propiedadCode))
      .findFirst()
      .orElse(null);
    /*if (targetSeat == null) throw new BusinessRuleValidationException(
      "This propiedadCode is not valid" + propiedadCode
    );*/
    /*if (targetSeat.getEstado().equals(Estado.INHABILITADO)) {
      throw new BusinessRuleValidationException(
        "This propiedadCode is already booked" + propiedadCode
      );
    }*/

    /*if (this.propiedad != null) {
      this.oldSeat = this.seat;
      this.propiedad.updateStatus(SeatStatus.FREE);
    }*/
    //targetSeat.updateStatus(SeatStatus.BOOKED);
    this.propiedad = targetSeat;
    addDomainEvent(new PropiedadAssigned(this));
    completeCheckIn();
  }

  public void completeCheckIn() {
    if (this.propiedad != null ) addDomainEvent(
      new CheckInCompleted(this)
    );
  }

}
