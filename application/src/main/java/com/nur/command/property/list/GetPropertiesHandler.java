package com.nur.command.property.list;

import an.awesome.pipelinr.Command;
import com.nur.dtos.PropertyDto;
import com.nur.core.BusinessRuleValidationException;
import com.nur.model.Property;
import org.springframework.stereotype.Component;
import com.nur.repositories.PropertyRepository;
import com.nur.utils.PropertyMapper;

import java.util.List;

@Component
public class GetPropertiesHandler
        implements Command.Handler<GetPropertiesQuery, List<PropertyDto>> {

  private final PropertyRepository propiedadRepository;

  public GetPropertiesHandler(PropertyRepository propiedadRepository) {
    this.propiedadRepository = propiedadRepository;
  }

  @Override
  public List<PropertyDto> handle(GetPropertiesQuery command) {
    try {
      List<Property> properties = this.propiedadRepository.getAll();
      return properties.stream().map(PropertyMapper::from).toList();
    } catch (BusinessRuleValidationException e) {
      throw new RuntimeException(e.getMessage());
    }
  }
}
