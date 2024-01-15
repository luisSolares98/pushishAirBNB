package com.nur.rules;

import com.nur.core.BussinessRule;

public class PersonNameRule implements BussinessRule {

	private static final int MAX_LENGHT = 50;

	private final String name;

	public PersonNameRule(String name) {
		this.name = name;
	}

	@Override
	public boolean isValid() {
		return name.length() < MAX_LENGHT;
	}

	@Override
	public String getMessage() {
		return "The name lenght can not be greater than " + MAX_LENGHT;
	}

}
