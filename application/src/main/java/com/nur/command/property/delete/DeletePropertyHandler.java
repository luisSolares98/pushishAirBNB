package com.nur.command.property.delete;

import an.awesome.pipelinr.Command;
import com.nur.core.BusinessRuleValidationException;
import com.nur.dtos.PropertyDto;
import com.nur.exceptions.InvalidDataException;
import com.nur.model.Property;
import com.nur.rabbit.Config;
import com.nur.rabbit.CustomMessage;
import com.nur.repositories.PropertyRepository;
import com.nur.utils.PropertyMapper;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class DeletePropertyHandler
  implements Command.Handler<DeletePropertyQuery, PropertyDto> {

  private final PropertyRepository propertyRepository;
  @Autowired
  private RabbitTemplate template;
  public DeletePropertyHandler(PropertyRepository propiedadRepository) {
    this.propertyRepository = propiedadRepository;
  }

  @Override
  public PropertyDto handle(DeletePropertyQuery command) {
    try {
      Property property = propertyRepository.findPropertyById(UUID.fromString(command.id));

      propertyRepository.deletePropertyById(
              UUID.fromString(command.id)
      );
      CustomMessage message = CustomMessage.builder().id(property.getUserId())
              .message("The Property was successfully Created/Modified").build();
      // Reddis notify
      template.convertAndSend(Config.EXCHANGE,
              Config.ROUTING_KEY, message);

      return PropertyMapper.from(property);
    } catch (BusinessRuleValidationException e) {
      throw new InvalidDataException(e.getMessage());
    }
  }
}
