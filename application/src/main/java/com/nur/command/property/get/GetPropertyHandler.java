package com.nur.command.property.get;

import an.awesome.pipelinr.Command;
import com.nur.dtos.PropertyDto;
import com.nur.core.BusinessRuleValidationException;
import com.nur.model.Property;
import org.springframework.stereotype.Component;
import com.nur.repositories.PropertyRepository;
import com.nur.utils.PropertyMapper;

import java.util.List;
import java.util.UUID;

@Component
public class GetPropertyHandler
  implements Command.Handler<GetPropertyQuery, PropertyDto> {

  private final PropertyRepository propiedadRepository;

  public GetPropertyHandler(PropertyRepository propiedadRepository) {
    this.propiedadRepository = propiedadRepository;
  }

  @Override
  public PropertyDto handle(GetPropertyQuery command) {
    try {
      Property property = propiedadRepository.findPropertyById(
              UUID.fromString(command.id)
      );
      return PropertyMapper.from(property);
    } catch (BusinessRuleValidationException e) {
      e.printStackTrace();
      return null;
    }
  }
}
