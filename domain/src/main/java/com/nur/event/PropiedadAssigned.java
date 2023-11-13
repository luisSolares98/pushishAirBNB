package com.nur.event;

import com.nur.model.CheckIn;
import com.nur.core.DomainEvent;

public class PropiedadAssigned extends DomainEvent {

  private CheckIn checkIn;

  public PropiedadAssigned(CheckIn checkIn) {
    super(checkIn.getDate());
    this.checkIn = checkIn;
  }

  public CheckIn getCheckIn() {
    return checkIn;
  }
}
