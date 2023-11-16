package com.nur.command.property.create;

import an.awesome.pipelinr.Command;
import com.nur.dtos.PropertyDto;

public class CreatePropertyCommand implements Command<PropertyDto> {

  PropertyDto propertyDto;

  public CreatePropertyCommand(PropertyDto propertyDto) {
    this.propertyDto = propertyDto;
  }
}
