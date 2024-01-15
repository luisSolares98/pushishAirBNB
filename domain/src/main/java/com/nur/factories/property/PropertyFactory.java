package com.nur.factories.property;

import com.nur.core.BussinessRuleValidationException;
import com.nur.model.Property;

import java.util.UUID;

public class PropertyFactory implements IPropertyFactory {

	@Override
	public Property create(String name, double amount, String description, String state, UUID userID)
			throws BussinessRuleValidationException {
		return new Property(name, amount, description, state, userID);
	}

}
