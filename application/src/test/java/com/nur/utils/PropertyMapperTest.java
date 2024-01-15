package com.nur.utils;

import com.nur.core.BussinessRuleValidationException;
import com.nur.dtos.PropertyDto;
import com.nur.dtos.PropertyDtoTest;
import com.nur.model.Property;
import com.nur.model.PropertyFixture;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.text.ParseException;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class PropertyMapperTest {
    @Mock
    PropertyMapper mapper;

    @BeforeEach
    void setUp() {
        mapper = new PropertyMapper();
    }
    @Test
    void from() throws ParseException, BussinessRuleValidationException {
        PropertyDto expect = PropertyDtoTest.withDefaultResponse();
        PropertyDto response = PropertyMapper.from(PropertyFixture.whitDefault());
        assertEquals(expect.toString(), response.toString());
    }

    @Test
    void testFromNull() throws ParseException {
        PropertyDto response = PropertyMapper.from((Property) null);
        assertEquals(PropertyDto.builder().build().toString(), response.toString());
    }
}