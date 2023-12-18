package com.nur.repositories;

import com.nur.core.BusinessRuleValidationException;
import com.nur.model.Property;

import java.util.List;
import java.util.UUID;

public interface PropertyRepository {

	UUID update(Property property);

	Property findPropertyById(UUID id) throws BusinessRuleValidationException;

	UUID deletePropertyById(UUID id) throws BusinessRuleValidationException;

	List<Property> getAll() throws BusinessRuleValidationException;

}
