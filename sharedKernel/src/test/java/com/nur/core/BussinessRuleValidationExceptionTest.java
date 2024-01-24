package com.nur.core;

import com.nur.rules.NotNullRule;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.util.ReflectionTestUtils;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
class BussinessRuleValidationExceptionTest {

	@Spy
	BussinessRule brokenRule;

	@Mock
	BussinessRuleValidationException exception;

	@Mock
	ValueObject valueObject;

	@BeforeEach
	void setUp() {
		exception = new BussinessRuleValidationException("Error", "Test");
		ReflectionTestUtils.setField(exception, "brokenRule", null);
		ReflectionTestUtils.setField(exception, "message", "test prueba");
		valueObject = new ValueObject() {
			@Override
			public void checkRule(BussinessRule rule) throws BussinessRuleValidationException {
				super.checkRule(rule);
			}
		};

	}

	@Test
	void testToString() {
		exception = new BussinessRuleValidationException(new NotNullRule(2));
		String toString = exception.toString();
		assertEquals("BussinessRule:Object can not be null", toString.toString());
	}

	@Test
	void getBrokenRule() {
		exception = new BussinessRuleValidationException(new NotNullRule(2));
		BussinessRule rule = exception.getBrokenRule();
		assertEquals(rule.getClass().getName(), "com.nur.rules.NotNullRule");
	}

	@Test
	void getDetails() {
		String toString = exception.toString();
		assertEquals("BussinessRule:test prueba", toString.toString());
	}

	@Test
	void checkRuleNull() {
		IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
				() -> valueObject.checkRule(null));
		assertEquals("Rule cannot be null", exception.getMessage());
	}

}