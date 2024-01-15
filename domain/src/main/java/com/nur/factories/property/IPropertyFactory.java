package com.nur.factories.property;

import com.nur.core.BussinessRuleValidationException;
import com.nur.model.Property;

import java.util.UUID;

public interface IPropertyFactory {

	Property create(String name, double amount, String description, String state, UUID userID)
			throws BussinessRuleValidationException;

}
