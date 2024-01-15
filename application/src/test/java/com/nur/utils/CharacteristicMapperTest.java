package com.nur.utils;

import com.nur.core.BussinessRuleValidationException;
import com.nur.dtos.CharacteristicDto;
import com.nur.dtos.CharacteristicDtoTest;
import com.nur.dtos.PropertyCharacteristicDto;
import com.nur.dtos.PropertyCharacteristicDtoTest;
import com.nur.model.Characteristic;
import com.nur.model.CharacteristicFixture;
import com.nur.model.CharacteristicProperty;
import com.nur.model.CharacteristicPropertyFixture;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.text.ParseException;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class CharacteristicMapperTest {
    @Mock
    CharacteristicMapper mapper;

    @BeforeEach
    void setUp() {
        mapper = new CharacteristicMapper();
    }
    @Test
    void from() throws ParseException, BussinessRuleValidationException {
        CharacteristicDto expect = CharacteristicDtoTest.withDefaultResponse();
        CharacteristicDto response = CharacteristicMapper.from(CharacteristicFixture.whitDefault());
        assertEquals(expect.toString(), response.toString());
    }

    @Test
    void testFromNull() throws ParseException {
        CharacteristicDto response = CharacteristicMapper.from((Characteristic) null);
        assertEquals(CharacteristicDto.builder().build().toString(), response.toString());
    }
}