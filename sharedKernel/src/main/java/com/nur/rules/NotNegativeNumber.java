package com.nur.rules;

import com.nur.core.BussinessRule;

public class NotNegativeNumber implements BussinessRule {

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
		return "Price value cannot be negative or zero";
	}

}
