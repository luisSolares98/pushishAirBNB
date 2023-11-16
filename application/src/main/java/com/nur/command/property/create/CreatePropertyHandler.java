package com.nur.command.property.create;

import an.awesome.pipelinr.Command;
import com.nur.dtos.PropertyDto;
import com.nur.core.BusinessRuleValidationException;
import com.nur.factories.property.PropertyFactory;
import com.nur.model.Property;
import org.springframework.stereotype.Component;
import com.nur.repositories.PropertyRepository;
import com.nur.utils.PropertyMapper;

import java.util.UUID;

@Component
public class CreatePropertyHandler
        implements Command.Handler<CreatePropertyCommand, PropertyDto> {

    private final PropertyRepository propertyRepository;

    private final PropertyFactory propertyFactory;


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
                            UUID.fromString(request.propertyDto.getUserId())
                    );
            propertyRepository.update(property);
            return PropertyMapper.from(property);
        } catch (BusinessRuleValidationException e) {
            return null;
        }
    }
}
