package com.nur.objects;

import com.nur.core.BussinessRuleValidationException;
import com.nur.core.ValueObject;
import com.nur.rules.NotNegativeNumber;

public class PrecioValue extends ValueObject {

	private final double value;

	public PrecioValue(double value) throws BussinessRuleValidationException {
		checkRule(new NotNegativeNumber(value));
		this.value = value;
	}

	public double getValue() {
		return value;
	}

}
