package com.nur.command.characteristicProperty.list;

import an.awesome.pipelinr.Command;
import com.nur.dtos.PropertyCharacteristicDto;
import com.nur.dtos.PropertyDto;
import com.nur.model.CharacteristicProperty;

import java.util.List;

public class GetCharacteristicByPropertyQuery implements Command<List<PropertyCharacteristicDto>> {

  public String property;
  public GetCharacteristicByPropertyQuery(String property) {
    this.property = property;
  }
}
