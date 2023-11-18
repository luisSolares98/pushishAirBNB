package com.nur.command.property.create;

import an.awesome.pipelinr.Command;
import com.nur.dtos.PropertyDto;
import com.nur.core.BusinessRuleValidationException;
import com.nur.factories.property.PropertyFactory;
import com.nur.model.Property;
import com.nur.rabbit.Config;
import com.nur.rabbit.CustomMessage;
import com.nur.rabbit.Pattern;
import com.nur.rabbit.Response;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.nur.repositories.PropertyRepository;
import com.nur.utils.PropertyMapper;

import java.util.UUID;

@Component
public class CreatePropertyHandler
        implements Command.Handler<CreatePropertyCommand, PropertyDto> {

    private final PropertyRepository propertyRepository;

    private final PropertyFactory propertyFactory;

    @Autowired
    private RabbitTemplate template;

    public CreatePropertyHandler(
            PropertyRepository propertyRepository

    ) {
        this.propertyRepository = propertyRepository;

        this.propertyFactory = new PropertyFactory();
    }

    @Override
    public PropertyDto handle(CreatePropertyCommand request) {
        try {
            Property property =
                    propertyFactory.create(
                            request.propertyDto.getName(),
                            request.propertyDto.getAmount(),
                            request.propertyDto.getDescription(),
                            request.propertyDto.getState(),
                            UUID.fromString(request.propertyDto.getUserId())
                    );
            propertyRepository.update(property);

            Pattern pattern = Pattern.builder().cmd(Config.EXCHANGE).build();

            CustomMessage message = CustomMessage.builder().id(UUID.fromString(request.propertyDto.getUserId()))
                    .message("The Property was successfully Created/Modified").build();

            Response response = Response.builder().data(message).pattern(pattern).build();


            // Reddis notify
            template.convertAndSend(Config.EXCHANGE, response);
            return PropertyMapper.from(property);
        } catch (BusinessRuleValidationException e) {
            return null;
        }
    }
}
