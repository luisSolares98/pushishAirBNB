package com.nur.utils;

import com.nur.core.BusinessRuleValidationException;
import com.nur.model.CharacteristicProperty;
import com.nur.model.CharacteristicPropertyJpaModel;

import java.util.Collections;
import java.util.List;

public class CharacteristicPropertyUtils {
    public static CharacteristicPropertyJpaModel ToJpaEntity(CharacteristicProperty property) {
        if (property == null) return null;
        CharacteristicPropertyJpaModel characteristicJpaModel = new CharacteristicPropertyJpaModel();
        characteristicJpaModel.setId(property.getId());
        characteristicJpaModel.setCharacteristicId(property.getCharacteristicId());
        characteristicJpaModel.setPropertyId(property.getPropertyId());
        return characteristicJpaModel;
    }

    public static List<CharacteristicPropertyJpaModel> ToJpaEntities(List<CharacteristicProperty> list) {
        if (list == null) return Collections.emptyList();
        return list.stream().map(CharacteristicPropertyUtils::ToJpaEntity).toList();
    }

    public static CharacteristicProperty jpaModelToCharacteristicProperty(CharacteristicPropertyJpaModel jpaModel)
            throws BusinessRuleValidationException {
        return new CharacteristicProperty(
                jpaModel.getId(),
                jpaModel.getCharacteristicId(),
                jpaModel.getPropertyId()
        );
    }
}
