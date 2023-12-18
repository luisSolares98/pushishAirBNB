package com.nur.core;

import java.util.Date;
import java.util.UUID;
import lombok.Getter;

@Getter
public abstract class DomainEvent {

  private final Date occurredOn;
  private final UUID id;

  protected DomainEvent(Date occurredOn) {
    this.id = UUID.randomUUID();
    this.occurredOn = occurredOn;
  }
}
