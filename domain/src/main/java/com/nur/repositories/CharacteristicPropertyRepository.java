package com.nur.repositories;

import com.nur.core.BussinessRuleValidationException;
import com.nur.model.CharacteristicProperty;

import java.util.List;
import java.util.UUID;

public interface CharacteristicPropertyRepository {

	UUID update(CharacteristicProperty tipo);

	List<CharacteristicProperty> getAllByProperty() throws BussinessRuleValidationException;

}
