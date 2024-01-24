package com.nur.dtos;

import java.text.ParseException;

public class CharacteristicDtoTest {

	public static CharacteristicDto withDefault() throws ParseException {
		return CharacteristicDto.builder().name("AGUA").build();
	}

	public static CharacteristicDto withDefaultResponse() throws ParseException {
		return CharacteristicDto.builder().id("effa368e-2f33-49c7-94e4-a4dfb3be2c27").name("AGUA").build();
	}

}