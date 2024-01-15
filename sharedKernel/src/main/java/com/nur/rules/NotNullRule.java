package com.nur.rules;

import com.nur.core.BussinessRule;

public class NotNullRule implements BussinessRule {

	private final Object object;

	public NotNullRule(Object object) {
		this.object = object;
	}

	@Override
	public boolean isValid() {
		return this.object != null;
	}

	@Override
	public String getMessage() {
		return "Object can not be null";
	}

}
