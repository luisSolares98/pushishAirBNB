package com.nur.command.characteristicProperty.create;

import com.nur.dtos.PropertyCharacteristicDto;

import an.awesome.pipelinr.Command;

public class CreateCharacteristicPropertyCommand implements Command<PropertyCharacteristicDto> {

  PropertyCharacteristicDto dto;

  public CreateCharacteristicPropertyCommand(PropertyCharacteristicDto propertyDto) {
    this.dto = propertyDto;
  }
}
