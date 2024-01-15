package com.nur.command.property.listByUserId;

import com.nur.command.property.list.GetPropertiesHandler;
import com.nur.command.property.list.GetPropertiesQuery;
import com.nur.core.BussinessRuleValidationException;
import com.nur.dtos.PropertyDto;
import com.nur.dtos.PropertyDtoTest;
import com.nur.exceptions.InvalidDataException;
import com.nur.factories.characteristic.ICharacteristicFactory;
import com.nur.model.PropertyFixture;
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
class GetPropertiesByUserHandlerTest {
    @Mock
    PropertyRepository propertyRepository;


    @InjectMocks
    GetPropertiesByUserHandler service;


    @BeforeEach
    void setUp() {
        service = new GetPropertiesByUserHandler(propertyRepository);
    }

    @Test
    void handle() throws ParseException, BussinessRuleValidationException {
        when(propertyRepository.getAll()).thenReturn(PropertyFixture.whitDefaultList());

        PropertyDto expect = PropertyDtoTest.withDefaultResponse();
        GetPropertiesByUserQuery command = new GetPropertiesByUserQuery(expect.getUserId());
        List<PropertyDto> respuesta = service.handle(command);

        assertEquals(expect.getId(), respuesta.get(0).getId());
    }

    @Test
    void handleError() throws ParseException, BussinessRuleValidationException {
        when(propertyRepository.getAll()).thenThrow(new RuntimeException("Simulated repository exception"));

        assertThrows(InvalidDataException.class, () -> service.handle(null));
    }
}