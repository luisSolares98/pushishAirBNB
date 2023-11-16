package com.nur.utils;

import com.nur.dtos.PropertyDto;
import com.nur.model.Property;

import java.util.UUID;

public class PropertyMapper {

    public static PropertyDto from(Property property) {
        if (property == null) return PropertyDto.builder().build();
        return PropertyDto.builder()
                .id(property.getId().toString())
                .name(property.getName())
                .amount(property.getAmount().getValue())
                .description(property.getDescription())
                .userId(property.getUserId().toString()).build();
    }
}