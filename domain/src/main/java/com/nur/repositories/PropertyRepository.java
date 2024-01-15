package com.nur.repositories;

import com.nur.core.BussinessRuleValidationException;
import com.nur.model.Property;

import java.util.List;
import java.util.UUID;

public interface PropertyRepository {

	UUID update(Property property);

	Property findPropertyById(UUID id) throws BussinessRuleValidationException;

	UUID deletePropertyById(UUID id) throws BussinessRuleValidationException;

	List<Property> getAll() throws BussinessRuleValidationException;

}
