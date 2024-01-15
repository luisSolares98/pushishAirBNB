package com.nur.command.property.delete;

import com.nur.command.property.create.CreatePropertyCommand;
import com.nur.command.property.create.CreatePropertyHandler;
import com.nur.command.property.get.GetPropertyHandler;
import com.nur.command.property.get.GetPropertyQuery;
import com.nur.core.BussinessRuleValidationException;
import com.nur.dtos.PropertyDto;
import com.nur.dtos.PropertyDtoTest;
import com.nur.exceptions.InvalidDataException;
import com.nur.factories.property.IPropertyFactory;
import com.nur.model.CharacteristicFixture;
import com.nur.model.CharacteristicPropertyFixture;
import com.nur.model.PropertyFixture;
import com.nur.repositories.PropertyRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

import java.text.ParseException;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class DeletePropertyHandlerTest {
    @Mock
    PropertyRepository iProperty;


    @InjectMocks
    DeletePropertyHandler service;

    @Mock
    RabbitTemplate template;

    @BeforeEach
    void setUp() {
        service = new DeletePropertyHandler(iProperty);
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void handle() throws ParseException, BussinessRuleValidationException {
        doReturn(PropertyFixture.whitDefault()).when(iProperty).findPropertyById(any());

        PropertyDto expect = PropertyDtoTest.withDefaultResponse();
        DeletePropertyQuery command = new DeletePropertyQuery(PropertyDtoTest.withDefaultResponse().getId());
        Mockito.doNothing().when(template).convertAndSend(anyString(), (Object) any());

        UUID respuesta = service.handle(command);
        assertEquals(expect.getId(), respuesta.toString());
    }

    @Test
    void handleError() throws ParseException, BussinessRuleValidationException {
        DeletePropertyQuery command = new DeletePropertyQuery(null);
        assertThrows(InvalidDataException.class, () -> service.handle(command));
    }
}