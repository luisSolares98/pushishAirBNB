package com.nur.model;

import com.nur.core.BussinessRuleValidationException;

import java.text.ParseException;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

public class CharacteristicPropertyFixture {

	public static CharacteristicProperty whitDefault() throws BussinessRuleValidationException, ParseException {
		return new CharacteristicProperty(UUID.fromString("effa368e-2f33-49c7-94e4-a4dfb3be2c07"),
				UUID.fromString("effa368e-2f33-49c7-94e4-a4dfb3be2c27"),
				UUID.fromString("effa368e-2f33-49c7-94e4-a4dfb3be2c37"));
	}

	public static List<CharacteristicProperty> whitDefaultList()
			throws BussinessRuleValidationException, ParseException {
		return Arrays.asList(
				new CharacteristicProperty(UUID.fromString("effa368e-2f33-49c7-94e4-a4dfb3be2c07"),
						UUID.fromString("effa368e-2f33-49c7-94e4-a4dfb3be2c27"),
						UUID.fromString("effa368e-2f33-49c7-94e4-a4dfb3be2c37")),
				new CharacteristicProperty(UUID.fromString("effa368e-2f33-49c7-94e4-a4dfb3be2c08"),
						UUID.fromString("effa368e-2f33-49c7-94e4-a4dfb3be2c28"),
						UUID.fromString("effa368e-2f33-49c7-94e4-a4dfb3be2c38")));
	}

}