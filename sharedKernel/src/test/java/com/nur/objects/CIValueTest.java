package com.nur.objects;

import com.nur.core.BussinessRuleValidationException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
class CIValueTest {

    @Mock
    CIValue ciRule;

    @BeforeEach
    void setUp() {
    }

    @Test
    void testOk() throws BussinessRuleValidationException {
        String entero = new String("1234567");
        ciRule = new CIValue(entero);
        assertEquals(entero, ciRule.getCi());
    }

    @Test
    void testFail() throws BussinessRuleValidationException {
        BussinessRuleValidationException exception = assertThrows(BussinessRuleValidationException.class,
                () -> new CIValue("1234567891011121314"));
        assertEquals("The CI can not be greater than 10 characters", exception.getMessage());
    }
    @Test
    void testFailVoid() throws BussinessRuleValidationException {
        BussinessRuleValidationException exception = assertThrows(BussinessRuleValidationException.class,
                () -> new CIValue(""));
        assertEquals("String can not be empty", exception.getMessage());
    }
    @Test
    void testFailNull() throws BussinessRuleValidationException {
        BussinessRuleValidationException exception = assertThrows(BussinessRuleValidationException.class,
                () -> new CIValue(null));
        assertEquals("Object can not be null", exception.getMessage());
    }
}