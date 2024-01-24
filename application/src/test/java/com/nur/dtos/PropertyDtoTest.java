package com.nur.dtos;

import com.nur.core.BussinessRuleValidationException;
import com.nur.model.CharacteristicProperty;

import java.text.ParseException;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

public class PropertyDtoTest {

	public static PropertyDto withDefault() throws ParseException {
		return PropertyDto.builder().description("test description").amount(10.0).state("disponible").name("test")
				.userId("effa368e-2f33-49c7-94e4-a4dfb3be2c10").build();
	}

	public static PropertyDto withDefaultResponse() throws ParseException {
		return PropertyDto.builder().id("effa368e-2f33-49c7-94e4-a4dfb3be2c20").description("test description")
				.amount(10.0).name("test").state("disponible").userId("effa368e-2f33-49c7-94e4-a4dfb3be2c10").build();
	}

}