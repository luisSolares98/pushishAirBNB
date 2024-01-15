package com.nur.factories.characteristic;

import com.nur.core.BussinessRuleValidationException;
import com.nur.model.Characteristic;

public class CharacteristicFactory implements ICharacteristicFactory {

	@Override
	public Characteristic create(String name) throws BussinessRuleValidationException {
		return new Characteristic(name);
	}

}
