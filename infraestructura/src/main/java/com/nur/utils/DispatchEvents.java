package com.nur.utils;

import com.nur.core.Entity;

public class DispatchEvents {

  public void dispatchEvent(Entity entity) {
    entity.domainEvents.stream().forEach(domain -> {});
  }
}
