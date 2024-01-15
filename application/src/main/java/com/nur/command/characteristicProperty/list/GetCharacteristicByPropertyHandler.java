package com.nur.command.characteristicProperty.list;

import com.nur.core.BussinessRuleValidationException;
import com.nur.dtos.PropertyCharacteristicDto;
import com.nur.exceptions.InvalidDataException;
import com.nur.model.Characteristic;
import com.nur.model.CharacteristicProperty;
import com.nur.repositories.CharacteristicPropertyRepository;
import com.nur.repositories.CharacteristicRepository;
import com.nur.utils.CharacteristicPropertyMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

import an.awesome.pipelinr.Command;

@Component
public class GetCharacteristicByPropertyHandler
		implements Command.Handler<GetCharacteristicByPropertyQuery, List<PropertyCharacteristicDto>> {

	private final CharacteristicPropertyRepository repository;

	private CharacteristicRepository tipo;
	@Autowired
	public GetCharacteristicByPropertyHandler(CharacteristicPropertyRepository repository, CharacteristicRepository characteristicRepository) {
		this.repository = repository;
		this.tipo = characteristicRepository;
	}

	@Override
	public List<PropertyCharacteristicDto> handle(GetCharacteristicByPropertyQuery command) {
		try {
			List<CharacteristicProperty> properties = this.repository.getAllByProperty();

			List<PropertyCharacteristicDto> resul = properties.stream()
					.filter(c -> c.getPropertyId().equals(UUID.fromString(command.property)))
					.map(CharacteristicPropertyMapper::from).toList();

			List<Characteristic> list = this.tipo.getAll();
			for (PropertyCharacteristicDto element : resul) {
				String name = "";
				for (Characteristic characteristic : list) {
					if (characteristic.getId().equals(UUID.fromString(element.getCharacteristicId()))) {
						name = characteristic.getName();
					}
				}
				element.setName(name);
			}

			return resul;
		}
		catch (Exception e) {
			throw new InvalidDataException(e.getMessage());
		}
	}

}
