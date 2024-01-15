package com.nur.utils;

import com.nur.core.BussinessRuleValidationException;
import com.nur.exceptions.InvalidDataException;
import com.nur.model.CharacteristicProperty;
import com.nur.model.CharacteristicPropertyJpaModel;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class CharacteristicPropertyUtils {

	public static CharacteristicPropertyJpaModel ToJpaEntity(CharacteristicProperty property) {
		if (Objects.isNull(property))
			throw new InvalidDataException("entity is null");
		CharacteristicPropertyJpaModel characteristicJpaModel = new CharacteristicPropertyJpaModel();
		characteristicJpaModel.setId(property.getId());
		characteristicJpaModel.setCharacteristicId(property.getCharacteristicId());
		characteristicJpaModel.setPropertyId(property.getPropertyId());
		return characteristicJpaModel;
	}

	public static List<CharacteristicPropertyJpaModel> ToJpaEntities(List<CharacteristicProperty> list) {
		if (list == null)
			return Collections.emptyList();
		return list.stream().map(CharacteristicPropertyUtils::ToJpaEntity).toList();
	}

	public static CharacteristicProperty jpaModelToCharacteristicProperty(CharacteristicPropertyJpaModel jpaModel)
			throws BussinessRuleValidationException {
		if (Objects.isNull(jpaModel))
			throw new InvalidDataException("jpaModel is null");
		return new CharacteristicProperty(jpaModel.getId(), jpaModel.getCharacteristicId(), jpaModel.getPropertyId());
	}

}
