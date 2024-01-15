package com.nur.factories.characteristicProperty;

import com.nur.core.BussinessRuleValidationException;
import com.nur.model.CharacteristicProperty;

import java.util.UUID;

public class CharacteristicPropertyFactory implements ICharacteristicPropertyFactory {

	@Override
	public CharacteristicProperty create(UUID characteristicId, UUID propertyId)
			throws BussinessRuleValidationException {
		return new CharacteristicProperty(characteristicId, propertyId);
	}

}
