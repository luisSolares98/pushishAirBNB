package com.nur.objects;


import com.nur.core.BusinessRuleValidationException;
import com.nur.core.ValueObject;
import com.nur.rules.NotNegativeNumber;


public class PrecioValue extends ValueObject {
    private final double value ;
    public PrecioValue(double value) throws BusinessRuleValidationException {
        checkRule(new NotNegativeNumber(value));
        this.value = value;
    }

    public double getValue() {
        return value;
    }


}
