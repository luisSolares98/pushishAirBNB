package com.nur.command.property.delete;

import java.util.UUID;

import an.awesome.pipelinr.Command;

public class DeletePropertyQuery implements Command<UUID> {

  String id;

  public DeletePropertyQuery(String id) {
    this.id = id;
  }
}
