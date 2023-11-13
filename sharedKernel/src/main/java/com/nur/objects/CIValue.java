package com.nur.objects;

import com.nur.core.BusinessRuleValidationException;
import com.nur.core.ValueObject;
import com.nur.rules.CIRule;
import com.nur.rules.StringNotNullOrEmptyRule;

public class CIValue extends ValueObject {

  private final String ci;

  public CIValue(String ci) throws BusinessRuleValidationException {
    checkRule(new StringNotNullOrEmptyRule(ci));
    checkRule(new CIRule(ci));
    this.ci = ci;
  }

  public String getCi() {
    return ci;
  }
}
