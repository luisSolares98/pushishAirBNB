package com.nur.command.characteristicProperty.create;

import an.awesome.pipelinr.Command;
import com.nur.core.BusinessRuleValidationException;
import com.nur.dtos.PropertyCharacteristicDto;
import com.nur.factories.characteristicProperty.CharacteristicPropertyFactory;
import com.nur.model.CharacteristicProperty;
import com.nur.repositories.CharacteristicPropertyRepository;
import com.nur.utils.CharacteristicPropertyMapper;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class CreateCharacteristicPropertyHandler
		implements Command.Handler<CreateCharacteristicPropertyCommand, PropertyCharacteristicDto> {

	private final CharacteristicPropertyRepository repository;

	private final CharacteristicPropertyFactory factory;

	public CreateCharacteristicPropertyHandler(CharacteristicPropertyRepository repository

	) {
		this.repository = repository;

		this.factory = new CharacteristicPropertyFactory();
	}

	@Override
	public PropertyCharacteristicDto handle(CreateCharacteristicPropertyCommand request) {
		try {
			CharacteristicProperty property = factory.create(UUID.fromString(request.dto.getCharacteristicId()),
					UUID.fromString(request.dto.getPropertyId())

			);
			repository.update(property);
			return CharacteristicPropertyMapper.from(property);
		}
		catch (BusinessRuleValidationException e) {
			return null;
		}
	}

}
