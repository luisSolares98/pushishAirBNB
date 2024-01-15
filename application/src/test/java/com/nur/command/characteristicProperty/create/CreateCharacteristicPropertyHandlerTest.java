package com.nur.command.characteristicProperty.create;

import com.nur.command.property.create.CreatePropertyCommand;
import com.nur.core.BussinessRuleValidationException;
import com.nur.dtos.PropertyCharacteristicDto;
import com.nur.dtos.PropertyCharacteristicDtoTest;
import com.nur.exceptions.InvalidDataException;
import com.nur.factories.characteristicProperty.ICharacteristicPropertyFactory;
import com.nur.repositories.CharacteristicPropertyRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.text.ParseException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
@ExtendWith(MockitoExtension.class)
class CreateCharacteristicPropertyHandlerTest {


    @Mock
    CharacteristicPropertyRepository propertyRepository;

    @Spy
    ICharacteristicPropertyFactory factory;

    @Mock
    CreateCharacteristicPropertyHandler service;

    @BeforeEach
    void setUp() {
        service = new CreateCharacteristicPropertyHandler(propertyRepository);

    }

    @Test
    void handle() throws ParseException, BussinessRuleValidationException {
        PropertyCharacteristicDto expect = PropertyCharacteristicDtoTest.withDefaultResponse();
        CreateCharacteristicPropertyCommand command = new CreateCharacteristicPropertyCommand(PropertyCharacteristicDtoTest.withDefaultResponse());
        PropertyCharacteristicDto respuesta = service.handle(command);
        assertEquals(expect.getPropertyId(), respuesta.getPropertyId());
    }


    @Test
    void handleError() throws ParseException, BussinessRuleValidationException {
        CreateCharacteristicPropertyCommand command = new CreateCharacteristicPropertyCommand(null);
        assertThrows(InvalidDataException.class, () -> service.handle(command));
    }
}