package com.nur.objects;

import com.nur.core.BussinessRuleValidationException;
import com.nur.core.ValueObject;
import com.nur.rules.PersonNameRule;
import com.nur.rules.StringNotNullOrEmptyRule;

public class PersonNameValue extends ValueObject {

	private String name;

	public PersonNameValue(String name) throws BussinessRuleValidationException {
		checkRule(new StringNotNullOrEmptyRule(name));
		checkRule(new PersonNameRule(name));
		this.name = name;
	}

	public String getName() {
		return name;
	}

}
