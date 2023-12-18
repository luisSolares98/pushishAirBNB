package com.nur.command.property.listByUserId;

import an.awesome.pipelinr.Command;
import com.nur.core.BusinessRuleValidationException;
import com.nur.dtos.PropertyDto;
import com.nur.model.Property;
import com.nur.repositories.PropertyRepository;
import com.nur.utils.PropertyMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class GetPropertiesByUserHandler
        implements Command.Handler<GetPropertiesByUserQuery, List<PropertyDto>> {

  private final PropertyRepository propiedadRepository;

  public GetPropertiesByUserHandler(PropertyRepository propiedadRepository) {
    this.propiedadRepository = propiedadRepository;
  }

  @Override
  public List<PropertyDto> handle(GetPropertiesByUserQuery command) {
    try {
      List<Property> properties = this.propiedadRepository.getAll();
      return properties.stream().filter(c -> c.getUserId().equals(UUID.fromString(command.userId))).map(PropertyMapper::from).toList();
    } catch (BusinessRuleValidationException e) {
      throw new RuntimeException(e.getMessage());
    }
  }
}
