package com.nur.event;

import com.nur.core.DomainEvent;
import com.nur.model.CheckIn;

public class CheckInCompleted extends DomainEvent {

  private CheckIn checkIn;

  public CheckInCompleted(CheckIn checkIn) {
    super(checkIn.getDate());
    this.checkIn = checkIn;
  }

  public CheckIn getCheckIn() {
    return checkIn;
  }
}
