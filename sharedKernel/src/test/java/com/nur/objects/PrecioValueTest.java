package com.nur.objects;

import com.nur.core.BussinessRuleValidationException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class PrecioValueTest {

    @Mock
    PrecioValue precioValue;

    @BeforeEach
    void setUp() {
    }

    @Test
    void testOk() throws BussinessRuleValidationException {
        Double precio = 1.1;
        precioValue = new PrecioValue(precio);
        assertEquals(precio, precioValue.getValue());
    }

    @Test
    void testFail() throws BussinessRuleValidationException {
        BussinessRuleValidationException exception = assertThrows(BussinessRuleValidationException.class,
                () -> new PrecioValue(0));
        assertEquals("Price value cannot be negative or zero", exception.getMessage());
    }
}