package com.nur.utils;

import com.nur.dtos.PropertyCharacteristicDto;
import com.nur.dtos.PropertyDto;
import com.nur.model.CharacteristicProperty;
import com.nur.model.Property;

public class CharacteristicPropertyMapper {
    public static PropertyCharacteristicDto from(CharacteristicProperty property) {
        if (property == null) return PropertyCharacteristicDto.builder().build();
        return PropertyCharacteristicDto.builder()
                .id(property.getId().toString())
                .characteristicId(property.getCharacteristicId().toString())
                .propertyId(property.getPropertyId().toString()).build();
    }
}
