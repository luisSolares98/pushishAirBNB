package com.nur.factories.property;

import com.nur.core.BusinessRuleValidationException;
import com.nur.model.Property;

import java.util.UUID;

public class PropertyFactory implements IPropertyFactory {

    @Override
    public Property create(String name, double amount, String description, String state, UUID userID) throws BusinessRuleValidationException {
        return new Property(name, amount, description, state, userID);
    }
}
