package com.nur.factories.characteristic;

import com.nur.core.BussinessRuleValidationException;
import com.nur.factories.characteristicProperty.CharacteristicPropertyFactory;
import com.nur.model.Characteristic;
import com.nur.model.CharacteristicFixture;
import com.nur.model.CharacteristicProperty;
import com.nur.model.CharacteristicPropertyFixture;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.text.ParseException;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class CharacteristicFactoryTest {

	@Mock
	CharacteristicFactory factory;

	@Spy
	ICharacteristicFactory inFactory;

	@BeforeEach
	void setUp() {
		this.factory = new CharacteristicFactory();
	}

	@Test
	void create() throws BussinessRuleValidationException, ParseException {
		Characteristic expect = CharacteristicFixture.whitDefault();
		Characteristic response = factory.create(expect.getName());
		assertEquals(expect.toString(), response.toString());
	}

}