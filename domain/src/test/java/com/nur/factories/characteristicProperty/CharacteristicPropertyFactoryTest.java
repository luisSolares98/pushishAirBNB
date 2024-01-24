package com.nur.factories.characteristicProperty;

import com.nur.core.BussinessRuleValidationException;
import com.nur.model.CharacteristicProperty;
import com.nur.model.CharacteristicPropertyFixture;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.text.ParseException;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class CharacteristicPropertyFactoryTest {

	@Mock
	CharacteristicPropertyFactory factory;

	@Spy
	ICharacteristicPropertyFactory inFactory;

	@BeforeEach
	void setUp() {
		this.factory = new CharacteristicPropertyFactory();
	}

	@Test
	void create() throws BussinessRuleValidationException, ParseException {
		CharacteristicProperty expect = CharacteristicPropertyFixture.whitDefault();
		CharacteristicProperty response = factory.create(expect.getCharacteristicId(), expect.getPropertyId());
		assertEquals(expect.toString(), response.toString());
	}

}