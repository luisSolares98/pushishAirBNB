package com.nur.command.property.get;

import com.nur.core.BussinessRuleValidationException;
import com.nur.dtos.PropertyDto;
import com.nur.exceptions.InvalidDataException;
import com.nur.model.Property;
import com.nur.repositories.PropertyRepository;
import com.nur.utils.PropertyMapper;

import org.springframework.stereotype.Component;

import java.util.UUID;

import an.awesome.pipelinr.Command;

@Component
public class GetPropertyHandler implements Command.Handler<GetPropertyQuery, PropertyDto> {

	private final PropertyRepository propiedadRepository;

	public GetPropertyHandler(PropertyRepository propiedadRepository) {
		this.propiedadRepository = propiedadRepository;
	}

	@Override
	public PropertyDto handle(GetPropertyQuery command) {
		try {
			Property property = propiedadRepository.findPropertyById(UUID.fromString(command.id));
			return PropertyMapper.from(property);
		}
		catch (Exception e) {
			throw new InvalidDataException(e.getMessage());
		}
	}

}
