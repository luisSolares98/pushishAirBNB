package com.nur.core;


public class BusinessRuleValidationException extends Exception {

  private final BusinessRule brokenRule;
  private final String message;

  public BusinessRuleValidationException(BusinessRule brokenRule) {
    this.brokenRule = brokenRule;
    this.message = brokenRule.getMessage();
  }

  public BusinessRuleValidationException(BusinessRule brokenRule, String message) {
    this.brokenRule = brokenRule;
    this.message = message;
  }

  @Override
  public String getMessage() {
    return this.message;
  }

  @Override
  public String toString() {
    return "BusinessRule " + this.message;
  }
}
