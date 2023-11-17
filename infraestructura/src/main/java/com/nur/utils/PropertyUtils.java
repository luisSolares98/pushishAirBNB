package com.nur.utils;

import com.nur.annotations.Generated;
import com.nur.core.BusinessRuleValidationException;
import com.nur.model.PropertyJpaModel;
import com.nur.model.Property;

import java.util.Collections;
import java.util.List;

@Generated
public class PropertyUtils {

    public static PropertyJpaModel propiedadToJpaEntity(Property propiedad) {
        if (propiedad == null) return null;
        PropertyJpaModel propertyJpaModel = new PropertyJpaModel();
        propertyJpaModel.setId(propiedad.getId());
        propertyJpaModel.setName(propiedad.getName());
        propertyJpaModel.setDescription(propiedad.getDescription());
        propertyJpaModel.setUserID(propiedad.getUserId());
        propertyJpaModel.setState(propiedad.getState());
        propertyJpaModel.setAmount(propiedad.getAmount().getValue());
        return propertyJpaModel;
    }

    public static List<PropertyJpaModel> propiedadToJpaEntities(List<Property> propiedades) {
        if (propiedades == null) return Collections.emptyList();
        return propiedades.stream().map(PropertyUtils::propiedadToJpaEntity).toList();
    }

    public static Property jpaModelToPropiedad(PropertyJpaModel jpaModel)
            throws BusinessRuleValidationException {
        return new Property(
                jpaModel.getId(),
                jpaModel.getName(),
                jpaModel.getAmount(),
                jpaModel.getDescription(),
                jpaModel.getState(),
                jpaModel.getUserID()
        );
    }
}
