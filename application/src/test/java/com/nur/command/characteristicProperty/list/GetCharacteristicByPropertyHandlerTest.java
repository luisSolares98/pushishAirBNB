package com.nur.command.characteristicProperty.list;

import com.nur.core.BussinessRuleValidationException;
import com.nur.dtos.PropertyCharacteristicDto;
import com.nur.dtos.PropertyCharacteristicDtoTest;
import com.nur.exceptions.InvalidDataException;
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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class GetCharacteristicByPropertyHandlerTest {
    @Mock
    CharacteristicPropertyRepository propertyRepository;

    @Mock
    CharacteristicRepository tipo;

    @InjectMocks
    GetCharacteristicByPropertyHandler service;


    @BeforeEach
    void setUp() {
        service = new GetCharacteristicByPropertyHandler(propertyRepository, tipo);
    }

    @Test
    void handle() throws ParseException, BussinessRuleValidationException {
        doReturn(CharacteristicPropertyFixture.whitDefaultList()).when(propertyRepository).getAllByProperty();

        when(tipo.getAll()).thenReturn(CharacteristicFixture.whitDefaultList());
        List<PropertyCharacteristicDto> expect = PropertyCharacteristicDtoTest.whitDefaultList();
        GetCharacteristicByPropertyQuery command = new GetCharacteristicByPropertyQuery(CharacteristicPropertyFixture.whitDefault().getPropertyId().toString());
        List<PropertyCharacteristicDto> respuesta = service.handle(command);

        assertEquals(expect.get(0).getId(), respuesta.get(0).getId());
    }

    @Test
    void handleError() throws ParseException, BussinessRuleValidationException {
        when(propertyRepository.getAllByProperty()).thenThrow(new RuntimeException("Simulated repository exception"));

        GetCharacteristicByPropertyQuery command = new GetCharacteristicByPropertyQuery(null);
        assertThrows(InvalidDataException.class, () -> service.handle(null));
    }
}