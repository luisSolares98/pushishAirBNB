package com.nur.rules;

import com.nur.core.BusinessRule;

public class NotNegativeNumber implements BusinessRule {

	private final Double amount;

	public NotNegativeNumber(Double amount) {
		this.amount = amount;
	}

	@Override
	public boolean isValid() {
		return amount > 0;
	}

	@Override
	public String getMessage() {
		return "Price value cannot be negative";
	}

}
