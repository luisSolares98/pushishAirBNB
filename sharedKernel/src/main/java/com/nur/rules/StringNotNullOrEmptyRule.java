package com.nur.rules;

import com.nur.core.BussinessRule;

public class StringNotNullOrEmptyRule implements BussinessRule {

	private final String value;

	public StringNotNullOrEmptyRule(String value) {
		this.value = value;
	}

	@Override
	public boolean isValid() {
		return !value.isEmpty();
	}

	@Override
	public String getMessage() {
		return "String can not be empty";
	}

}
