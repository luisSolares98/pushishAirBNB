package com.nur.command.characteristic.list;

import an.awesome.pipelinr.Command;
import com.nur.dtos.CharacteristicDto;
import com.nur.core.BussinessRuleValidationException;
import com.nur.exceptions.InvalidDataException;
import com.nur.model.Characteristic;
import org.springframework.stereotype.Component;
import com.nur.repositories.CharacteristicRepository;
import com.nur.utils.CharacteristicMapper;

import java.util.List;

@Component
public class GetListCharacteristicHandler
		implements Command.Handler<GetListCharacteristicQuery, List<CharacteristicDto>> {

	private final CharacteristicRepository tipo;

	public GetListCharacteristicHandler(CharacteristicRepository tipo) {
		this.tipo = tipo;
	}

	@Override
	public List<CharacteristicDto> handle(GetListCharacteristicQuery command) {
		try {
			List<Characteristic> list = this.tipo.getAll();
			return list.stream().map(CharacteristicMapper::from).toList();
		}
		catch (Exception e) {
			throw new InvalidDataException(e.getMessage());
		}
	}

}
