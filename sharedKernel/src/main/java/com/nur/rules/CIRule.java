package com.nur.rules;

import com.nur.core.BussinessRule;

public class CIRule implements BussinessRule {

	private final String ci;

	public CIRule(String ci) {
		this.ci = ci;
	}

	@Override
	public boolean isValid() {
		return ci.length() <= 10;
	}

	@Override
	public String getMessage() {
		return "The CI can not be greater than 10 characters";
	}

}
