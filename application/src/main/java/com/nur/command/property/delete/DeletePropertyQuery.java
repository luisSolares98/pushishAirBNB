package com.nur.command.property.delete;

import an.awesome.pipelinr.Command;
import com.nur.dtos.PropertyDto;
import com.nur.model.Property;

import java.util.UUID;

public class DeletePropertyQuery implements Command<UUID> {

  String id;

  public DeletePropertyQuery(String id) {
    this.id = id;
  }
}
