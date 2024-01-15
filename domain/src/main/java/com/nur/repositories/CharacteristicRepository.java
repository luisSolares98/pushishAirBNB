package com.nur.repositories;

import com.nur.core.BussinessRuleValidationException;
import com.nur.model.Characteristic;

import java.util.List;
import java.util.UUID;

public interface CharacteristicRepository {

	UUID update(Characteristic tipo);

	List<Characteristic> getAll() throws BussinessRuleValidationException;

}
