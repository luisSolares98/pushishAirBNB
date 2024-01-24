package com.nur.factories.property;

import com.nur.core.BussinessRuleValidationException;
import com.nur.factories.characteristic.CharacteristicFactory;
import com.nur.factories.characteristic.ICharacteristicFactory;
import com.nur.model.Characteristic;
import com.nur.model.CharacteristicFixture;
import com.nur.model.Property;
import com.nur.model.PropertyFixture;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.text.ParseException;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class PropertyFactoryTest {

	@Mock
	PropertyFactory factory;

	@Spy
	IPropertyFactory inFactory;

	@BeforeEach
	void setUp() {
		this.factory = new PropertyFactory();
	}

	@Test
	void create() throws BussinessRuleValidationException, ParseException {
		Property expect = PropertyFixture.whitDefault();
		Property response = factory.create(expect.getName(), expect.getAmount(), expect.getDescription(),
				expect.getState(), expect.getUserId());
		assertEquals(expect.toString(), response.toString());
	}

}