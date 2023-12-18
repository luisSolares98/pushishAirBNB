package com.nur.command.characteristic.create;

import an.awesome.pipelinr.Command;
import com.nur.dtos.CharacteristicDto;

public class CreateCharacteristicCommand implements Command<CharacteristicDto> {

	CharacteristicDto characteristic;

	public CreateCharacteristicCommand(CharacteristicDto characteristic) {
		this.characteristic = characteristic;
	}

}
