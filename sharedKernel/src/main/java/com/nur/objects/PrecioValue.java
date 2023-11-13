package com.nur.objects;


import com.nur.core.BusinessRuleValidationException;
import com.nur.core.ValueObject;


public class PrecioValue extends ValueObject {
    private final double Value ;
    public PrecioValue(double value) throws BusinessRuleValidationException {
        if (value < 0)
        {
            throw new BusinessRuleValidationException("Price value cannot be negative");
        }
        Value = value;
    }

    public double getValue() {
        return Value;
    }

    public static PrecioValue fromDouble(double value) throws BusinessRuleValidationException {
        return new PrecioValue(value);
    }

}
