package com.nur.factories.characteristic;

import com.nur.core.BusinessRuleValidationException;
import com.nur.model.Characteristic;

public interface ICharacteristicFactory {

	Characteristic create(String name) throws BusinessRuleValidationException;

}
