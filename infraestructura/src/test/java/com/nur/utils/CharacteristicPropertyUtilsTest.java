package com.nur.utils;

import com.nur.core.BussinessRuleValidationException;
import com.nur.exceptions.InvalidDataException;
import com.nur.model.CharacteristicProperty;
import com.nur.model.CharacteristicPropertyFixture;
import com.nur.model.CharacteristicPropertyJpaModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.text.ParseException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class CharacteristicPropertyUtilsTest {
    @Mock
    CharacteristicPropertyUtils utils;

    @BeforeEach
    void setUp() {
        utils = new CharacteristicPropertyUtils();
    }

    @Test
    void JpaModelListVoid() throws BussinessRuleValidationException, ParseException {
        List<CharacteristicPropertyJpaModel> expect = CharacteristicPropertyUtils.ToJpaEntities(null);
        assertNotNull(expect);
    }

    @Test
    void JpaModelList() throws BussinessRuleValidationException, ParseException {
        List<CharacteristicPropertyJpaModel> listJpa = CharacteristicPropertyFixture.whitDefaultListJPA();
        List<CharacteristicProperty> list = CharacteristicPropertyFixture.whitDefaultList();
        List<CharacteristicPropertyJpaModel> expect = CharacteristicPropertyUtils.ToJpaEntities(list);
        assertEquals(expect.toString(), listJpa.toString());
    }

    @Test
    void jpaToCheckInNull() throws BussinessRuleValidationException {
        InvalidDataException exception = assertThrows(InvalidDataException.class,
                () -> CharacteristicPropertyUtils.jpaModelToCharacteristicProperty(null));
        assertEquals("jpaModel is null", exception.getMessage());
    }

    @Test
    void jpaTModel() throws BussinessRuleValidationException, ParseException {
        CharacteristicProperty expect = CharacteristicPropertyFixture.whitDefault();
        CharacteristicProperty response = CharacteristicPropertyUtils.jpaModelToCharacteristicProperty(CharacteristicPropertyFixture.whitDefaultJPA());
        assertEquals(expect.toString(), response.toString());
    }
    @Test
    void jpaTModelNull() throws BussinessRuleValidationException, ParseException {
        CharacteristicProperty expect = CharacteristicPropertyFixture.whitDefault();
        CharacteristicProperty response = CharacteristicPropertyUtils.jpaModelToCharacteristicProperty(CharacteristicPropertyFixture.whitDefaultJPA());
        assertEquals(expect.toString(), response.toString());
    }
    @Test
    void jpaToEntity() throws BussinessRuleValidationException {
        InvalidDataException exception = assertThrows(InvalidDataException.class,
                () -> CharacteristicPropertyUtils.ToJpaEntity(null));
        assertEquals("entity is null", exception.getMessage());
    }
}