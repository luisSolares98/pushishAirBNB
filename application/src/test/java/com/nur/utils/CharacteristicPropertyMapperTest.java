package com.nur.utils;

import com.nur.core.BussinessRuleValidationException;
import com.nur.dtos.PropertyCharacteristicDto;
import com.nur.dtos.PropertyCharacteristicDtoTest;
import com.nur.model.CharacteristicProperty;
import com.nur.model.CharacteristicPropertyFixture;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.text.ParseException;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class CharacteristicPropertyMapperTest {

	@Mock
	CharacteristicPropertyMapper mapper;

	@BeforeEach
	void setUp() {
		mapper = new CharacteristicPropertyMapper();
	}

	@Test
	void from() throws ParseException, BussinessRuleValidationException {
		PropertyCharacteristicDto expect = PropertyCharacteristicDtoTest.withDefaultResponse();
		PropertyCharacteristicDto response = CharacteristicPropertyMapper
				.from(CharacteristicPropertyFixture.whitDefault());
		assertEquals(expect.toString(), response.toString());
	}

	@Test
	void testFromNull() throws ParseException {
		PropertyCharacteristicDto response = CharacteristicPropertyMapper.from((CharacteristicProperty) null);
		assertEquals(PropertyCharacteristicDto.builder().build().toString(), response.toString());
	}

}