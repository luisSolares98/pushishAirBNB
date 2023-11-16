package com.nur.command.characteristicProperty.list;

import an.awesome.pipelinr.Command;
import com.nur.core.BusinessRuleValidationException;
import com.nur.dtos.PropertyCharacteristicDto;
import com.nur.model.Characteristic;
import com.nur.model.CharacteristicProperty;
import com.nur.repositories.CharacteristicPropertyRepository;
import com.nur.repositories.CharacteristicRepository;
import com.nur.utils.CharacteristicPropertyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class GetCharacteristicByPropertyHandler
        implements Command.Handler<GetCharacteristicByPropertyQuery, List<PropertyCharacteristicDto>> {

  private final CharacteristicPropertyRepository repository;

  @Autowired
  private  CharacteristicRepository tipo;


  public GetCharacteristicByPropertyHandler(CharacteristicPropertyRepository repository) {
    this.repository = repository;
  }

  @Override
  public List<PropertyCharacteristicDto> handle(GetCharacteristicByPropertyQuery command) {
    try {
      List<CharacteristicProperty> properties = this.repository.getAllByProperty();

      List<PropertyCharacteristicDto> resul = properties.stream().filter(c -> c.getPropertyId().equals(UUID.fromString(command.property))).map(CharacteristicPropertyMapper::from).toList();

      List<Characteristic> list = this.tipo.getAll();
      for (int i = 0; i < resul.size(); i++) {
        PropertyCharacteristicDto element = resul.get(i);
        System.out.println(element.getCharacteristicId());
        System.out.println();
        String name = list.stream().filter(c -> c.getId().equals(UUID.fromString(element.getCharacteristicId()))).toList().get(0).getName();
        resul.get(i).setName(name);
      }

      return resul;
    } catch (BusinessRuleValidationException e) {
      e.printStackTrace();
      return null;
    }
  }
}
