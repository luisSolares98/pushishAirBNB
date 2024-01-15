package com.nur.utils;

import com.nur.dtos.PropertyDto;
import com.nur.model.Property;

public class PropertyMapper {

	public static PropertyDto from(Property property) {
		if (property == null)
			return PropertyDto.builder().build();
		return PropertyDto.builder().id(property.getId().toString()).name(property.getName())
				.amount(property.getAmount()).description(property.getDescription())
				.state(property.getState()).userId(property.getUserId().toString()).build();
	}

}