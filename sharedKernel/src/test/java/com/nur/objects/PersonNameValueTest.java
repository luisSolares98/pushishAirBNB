package com.nur.objects;

import com.nur.core.BussinessRuleValidationException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class PersonNameValueTest {

	@Mock
	PersonNameValue ciRule;

	@BeforeEach
	void setUp() {
	}

	@Test
	void testOk() throws BussinessRuleValidationException {
		String entero = new String("pepe pepito");
		ciRule = new PersonNameValue(entero);
		assertEquals(entero, ciRule.getName());
	}

	@Test
	void testFail() throws BussinessRuleValidationException {
		BussinessRuleValidationException exception = assertThrows(BussinessRuleValidationException.class,
				() -> new PersonNameValue(
						"pepe pepito asdasaa asdasdsacasdasdas asdasdas asdasdas asdasdsa asdasdasdasdasdasdasdasd asdasdasdasd asdasdsa"));
		assertEquals("The name lenght can not be greater than 50", exception.getMessage());
	}

}