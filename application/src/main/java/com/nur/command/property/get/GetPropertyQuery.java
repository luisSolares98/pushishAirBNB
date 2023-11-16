package com.nur.command.property.get;

import an.awesome.pipelinr.Command;
import com.nur.dtos.PropertyDto;

import java.util.List;

public class GetPropertyQuery implements Command<PropertyDto> {

  String id;

  public GetPropertyQuery(String id) {
    this.id = id;
  }
}
