package com.nur.core;

import lombok.Getter;

@Getter
public class BussinessRuleValidationException extends Exception {

	private BussinessRule brokenRule;

	private final String message;

	public BussinessRuleValidationException(BussinessRule brokenRule) {
		this.brokenRule = brokenRule;
		this.message = brokenRule.getMessage();
	}

	public BussinessRuleValidationException(String message, String details) {
		super(message);
		this.message = details;
	}

	@Override
	public String getMessage() {
		return this.message;
	}

	@Override
	public String toString() {
		return "BussinessRule:" + this.message;
	}

}
