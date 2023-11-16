package com.nur.command.characteristicProperty.create;

import an.awesome.pipelinr.Command;
import com.nur.dtos.PropertyCharacteristicDto;
import com.nur.dtos.PropertyDto;

public class CreateCharacteristicPropertyCommand implements Command<PropertyCharacteristicDto> {

  PropertyCharacteristicDto dto;

  public CreateCharacteristicPropertyCommand(PropertyCharacteristicDto propertyDto) {
    this.dto = propertyDto;
  }
}
