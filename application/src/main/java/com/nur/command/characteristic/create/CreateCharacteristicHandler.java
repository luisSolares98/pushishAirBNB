package com.nur.command.characteristic.create;

import an.awesome.pipelinr.Command;
import com.nur.dtos.CharacteristicDto;
import com.nur.core.BusinessRuleValidationException;
import com.nur.factories.characteristic.CharacteristicFactory;
import com.nur.model.Characteristic;
import org.springframework.stereotype.Component;
import com.nur.repositories.CharacteristicRepository;
import com.nur.utils.CharacteristicMapper;

@Component
public class CreateCharacteristicHandler implements Command.Handler<CreateCharacteristicCommand, CharacteristicDto> {

	private final CharacteristicRepository characteristicRepository;

	private final CharacteristicFactory characteristicFactory;

	public CreateCharacteristicHandler(CharacteristicRepository characteristicRepository

	) {
		this.characteristicRepository = characteristicRepository;

		this.characteristicFactory = new CharacteristicFactory();
	}

	@Override
	public CharacteristicDto handle(CreateCharacteristicCommand request) {
		try {
			Characteristic characteristic = characteristicFactory.create(request.characteristic.getName());
			characteristicRepository.update(characteristic);
			return CharacteristicMapper.from(characteristic);
		}
		catch (BusinessRuleValidationException e) {
			return null;
		}
	}

}
