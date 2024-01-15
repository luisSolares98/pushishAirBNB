package com.nur.command.characteristic.create;

import com.nur.command.characteristicProperty.create.CreateCharacteristicPropertyCommand;
import com.nur.command.characteristicProperty.create.CreateCharacteristicPropertyHandler;
import com.nur.core.BussinessRuleValidationException;
import com.nur.dtos.CharacteristicDto;
import com.nur.dtos.CharacteristicDtoTest;
import com.nur.dtos.PropertyCharacteristicDto;
import com.nur.dtos.PropertyCharacteristicDtoTest;
import com.nur.exceptions.InvalidDataException;
import com.nur.factories.characteristic.ICharacteristicFactory;
import com.nur.factories.characteristicProperty.ICharacteristicPropertyFactory;
import com.nur.repositories.CharacteristicPropertyRepository;
import com.nur.repositories.CharacteristicRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.text.ParseException;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class CreateCharacteristicHandlerTest {


    @Mock
    CharacteristicRepository repository;

    @Spy
    ICharacteristicFactory factory;

    @Mock
    CreateCharacteristicHandler service;

    @BeforeEach
    void setUp() {
        service = new CreateCharacteristicHandler(repository);

    }

    @Test
    void handle() throws ParseException, BussinessRuleValidationException {
        CharacteristicDto expect = CharacteristicDtoTest.withDefaultResponse();
        CreateCharacteristicCommand command = new CreateCharacteristicCommand(CharacteristicDtoTest.withDefaultResponse());
        CharacteristicDto respuesta = service.handle(command);
        assertEquals(expect.getName(), respuesta.getName());
    }


    @Test
    void handleError() throws ParseException, BussinessRuleValidationException {
        CreateCharacteristicCommand command = new CreateCharacteristicCommand(null);
        assertThrows(InvalidDataException.class, () -> service.handle(command));
    }
}