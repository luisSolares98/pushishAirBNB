package com.nur.factories.characteristic;

import com.nur.core.BussinessRuleValidationException;
import com.nur.model.Characteristic;

public interface ICharacteristicFactory {

	Characteristic create(String name) throws BussinessRuleValidationException;

}
