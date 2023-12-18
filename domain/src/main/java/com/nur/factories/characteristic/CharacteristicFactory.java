package com.nur.factories.characteristic;

import com.nur.core.BusinessRuleValidationException;
import com.nur.model.Characteristic;

public class CharacteristicFactory implements ICharacteristicFactory {

    @Override
    public Characteristic create(String name) throws BusinessRuleValidationException {
        return new Characteristic(name);
    }
}
