package com.nur.utils;

import com.nur.dtos.PropertyCharacteristicDto;
import com.nur.model.CharacteristicProperty;

public class CharacteristicPropertyMapper {

    private CharacteristicPropertyMapper() {
        throw new IllegalStateException("Utility class");
    }

    public static PropertyCharacteristicDto from(CharacteristicProperty property) {
        if (property == null) return PropertyCharacteristicDto.builder().build();
        return PropertyCharacteristicDto.builder()
                .id(property.getId().toString())
                .characteristicId(property.getCharacteristicId().toString())
                .propertyId(property.getPropertyId().toString()).build();
    }
}
