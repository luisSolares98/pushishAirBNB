package com.nur.utils;

import com.nur.annotations.Generated;
import com.nur.core.BussinessRuleValidationException;
import com.nur.exceptions.InvalidDataException;
import com.nur.model.PropertyJpaModel;
import com.nur.model.Property;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

@Generated
public class PropertyUtils {

	public static PropertyJpaModel propiedadToJpaEntity(Property propiedad) {
		if (Objects.isNull(propiedad))
			throw new InvalidDataException("entity is null");
		PropertyJpaModel propertyJpaModel = new PropertyJpaModel();
		propertyJpaModel.setId(propiedad.getId());
		propertyJpaModel.setName(propiedad.getName());
		propertyJpaModel.setDescription(propiedad.getDescription());
		propertyJpaModel.setUserID(propiedad.getUserId());
		propertyJpaModel.setState(propiedad.getState());
		propertyJpaModel.setAmount(propiedad.getAmount());
		return propertyJpaModel;
	}

	public static List<PropertyJpaModel> propiedadToJpaEntities(List<Property> propiedades) {
		if (propiedades == null)
			return Collections.emptyList();
		return propiedades.stream().map(PropertyUtils::propiedadToJpaEntity).toList();
	}

	public static Property jpaModelToPropiedad(PropertyJpaModel jpaModel) throws BussinessRuleValidationException {
		if (Objects.isNull(jpaModel))
			throw new InvalidDataException("jpaModel is null");

		return new Property(jpaModel.getId(), jpaModel.getName(), jpaModel.getAmount(), jpaModel.getDescription(),
				jpaModel.getState(), jpaModel.getUserID());
	}

}
