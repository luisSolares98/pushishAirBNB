package com.nur.utils;

import com.nur.core.BussinessRuleValidationException;
import com.nur.exceptions.InvalidDataException;
import com.nur.model.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.text.ParseException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class PropertyUtilsTest {
    @Mock
    PropertyUtils utils;

    @BeforeEach
    void setUp() {
        utils = new PropertyUtils();
    }

    @Test
    void JpaModelListVoid() throws BussinessRuleValidationException, ParseException {
        List<PropertyJpaModel> expect = PropertyUtils.propiedadToJpaEntities(null);
        assertNotNull(expect);
    }

    @Test
    void JpaModelList() throws BussinessRuleValidationException, ParseException {
        List<PropertyJpaModel> listJpa = PropertyFixture.whitDefaultListJPA();
        List<Property> list = PropertyFixture.whitDefaultList();
        List<PropertyJpaModel> expect = PropertyUtils.propiedadToJpaEntities(list);
        assertEquals(expect.toString(), listJpa.toString());
    }

    @Test
    void jpaToCheckInNull() throws BussinessRuleValidationException {
        InvalidDataException exception = assertThrows(InvalidDataException.class,
                () -> PropertyUtils.jpaModelToPropiedad(null));
        assertEquals("jpaModel is null", exception.getMessage());
    }

    @Test
    void jpaToModel() throws BussinessRuleValidationException, ParseException {
        Property expect = PropertyFixture.whitDefault();
        Property response = PropertyUtils.jpaModelToPropiedad(PropertyFixture.whitDefaultJPA());
        assertEquals(expect.toString(), response.toString());
    }

    @Test
    void jpaToEntity() throws BussinessRuleValidationException {
        InvalidDataException exception = assertThrows(InvalidDataException.class,
                () -> PropertyUtils.propiedadToJpaEntity(null));
        assertEquals("entity is null", exception.getMessage());
    }

}