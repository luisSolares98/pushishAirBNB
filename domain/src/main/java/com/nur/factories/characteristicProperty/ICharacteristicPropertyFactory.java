package com.nur.factories.characteristicProperty;

import com.nur.core.BussinessRuleValidationException;
import com.nur.model.CharacteristicProperty;

import java.util.UUID;

public interface ICharacteristicPropertyFactory {

	CharacteristicProperty create(UUID characteristicId, UUID propertyId) throws BussinessRuleValidationException;

}
