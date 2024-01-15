package com.nur.command.characteristic.list;

import com.nur.command.characteristicProperty.list.GetCharacteristicByPropertyHandler;
import com.nur.command.characteristicProperty.list.GetCharacteristicByPropertyQuery;
import com.nur.core.BussinessRuleValidationException;
import com.nur.dtos.CharacteristicDto;
import com.nur.dtos.CharacteristicDtoTest;
import com.nur.dtos.PropertyCharacteristicDto;
import com.nur.dtos.PropertyCharacteristicDtoTest;
import com.nur.exceptions.InvalidDataException;
import com.nur.factories.characteristic.ICharacteristicFactory;
import com.nur.model.CharacteristicFixture;
import com.nur.model.CharacteristicPropertyFixture;
import com.nur.repositories.CharacteristicPropertyRepository;
import com.nur.repositories.CharacteristicRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.text.ParseException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class GetListCharacteristicHandlerTest {
    @Mock
    CharacteristicRepository propertyRepository;

    @Mock
    ICharacteristicFactory factory;

    @InjectMocks
    GetListCharacteristicHandler service;


    @BeforeEach
    void setUp() {
        service = new GetListCharacteristicHandler(propertyRepository);
    }

    @Test
    void handle() throws ParseException, BussinessRuleValidationException {
        when(propertyRepository.getAll()).thenReturn(CharacteristicFixture.whitDefaultList());

        CharacteristicDto expect = CharacteristicDtoTest.withDefaultResponse();
        GetListCharacteristicQuery command = new GetListCharacteristicQuery();
        List<CharacteristicDto> respuesta = service.handle(command);

        assertEquals(expect.getId(), respuesta.get(0).getId());
    }

    @Test
    void handleError() throws ParseException, BussinessRuleValidationException {
        when(propertyRepository.getAll()).thenThrow(new RuntimeException("Simulated repository exception"));

        assertThrows(InvalidDataException.class, () -> service.handle(null));
    }
}