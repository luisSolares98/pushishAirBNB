package com.nur.factories.characteristicProperty;

import com.nur.core.BusinessRuleValidationException;
import com.nur.model.CharacteristicProperty;
import com.nur.model.Property;

import java.util.UUID;

public class CharacteristicPropertyFactory implements ICharacteristicPropertyFactory {


    @Override
    public CharacteristicProperty create(UUID characteristicId, UUID propertyId) throws BusinessRuleValidationException {
        return new CharacteristicProperty(characteristicId, propertyId);
    }
}
