package com.nur.command.property.list;

import com.nur.command.characteristic.list.GetListCharacteristicHandler;
import com.nur.command.characteristic.list.GetListCharacteristicQuery;
import com.nur.core.BussinessRuleValidationException;
import com.nur.dtos.CharacteristicDto;
import com.nur.dtos.CharacteristicDtoTest;
import com.nur.dtos.PropertyDto;
import com.nur.dtos.PropertyDtoTest;
import com.nur.exceptions.InvalidDataException;
import com.nur.factories.characteristic.ICharacteristicFactory;
import com.nur.model.CharacteristicFixture;
import com.nur.model.PropertyFixture;
import com.nur.repositories.CharacteristicRepository;
import com.nur.repositories.PropertyRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.text.ParseException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class GetPropertiesHandlerTest {
    @Mock
    PropertyRepository propertyRepository;

    @Mock
    ICharacteristicFactory factory;

    @InjectMocks
    GetPropertiesHandler service;


    @BeforeEach
    void setUp() {
        service = new GetPropertiesHandler(propertyRepository);
    }

    @Test
    void handle() throws ParseException, BussinessRuleValidationException {
        when(propertyRepository.getAll()).thenReturn(PropertyFixture.whitDefaultList());

        PropertyDto expect = PropertyDtoTest.withDefaultResponse();
        GetPropertiesQuery command = new GetPropertiesQuery();
        List<PropertyDto> respuesta = service.handle(command);

        assertEquals(expect.getId(), respuesta.get(0).getId());
    }

    @Test
    void handleError() throws ParseException, BussinessRuleValidationException {
        when(propertyRepository.getAll()).thenThrow(new RuntimeException("Simulated repository exception"));

        assertThrows(InvalidDataException.class, () -> service.handle(null));
    }
}