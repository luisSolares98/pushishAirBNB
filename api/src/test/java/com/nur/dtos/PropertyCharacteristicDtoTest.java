package com.nur.dtos;

import com.nur.core.BussinessRuleValidationException;

import java.text.ParseException;
import java.util.Arrays;
import java.util.List;

public class PropertyCharacteristicDtoTest {

	public static PropertyCharacteristicDto withDefault() throws ParseException {
		return PropertyCharacteristicDto.builder().characteristicId("effa368e-2f33-49c7-94e4-a4dfb3be2c27")
				.propertyId("effa368e-2f33-49c7-94e4-a4dfb3be2c37").build();
	}

	public static PropertyCharacteristicDto withDefaultResponse() throws ParseException {
		return PropertyCharacteristicDto.builder().id("effa368e-2f33-49c7-94e4-a4dfb3be2c07")
				.characteristicId("effa368e-2f33-49c7-94e4-a4dfb3be2c27")
				.propertyId("effa368e-2f33-49c7-94e4-a4dfb3be2c37").build();

	}

	public static List<PropertyCharacteristicDto> whitDefaultList()
			throws BussinessRuleValidationException, ParseException {
		return Arrays.asList(
				PropertyCharacteristicDto.builder().id("effa368e-2f33-49c7-94e4-a4dfb3be2c07")
						.characteristicId("effa368e-2f33-49c7-94e4-a4dfb3be2c27")
						.propertyId("effa368e-2f33-49c7-94e4-a4dfb3be2c37").build(),
				PropertyCharacteristicDto.builder().id("effa368e-2f33-49c7-94e4-a4dfb3be2c08")
						.characteristicId("effa368e-2f33-49c7-94e4-a4dfb3be2c28")
						.propertyId("effa368e-2f33-49c7-94e4-a4dfb3be2c38").build());
	}

}