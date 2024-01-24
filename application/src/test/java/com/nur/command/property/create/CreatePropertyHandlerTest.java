package com.nur.command.property.create;

import com.nur.core.BussinessRuleValidationException;
import com.nur.dtos.PropertyDto;
import com.nur.dtos.PropertyDtoTest;
import com.nur.exceptions.InvalidDataException;
import com.nur.factories.property.IPropertyFactory;
import com.nur.repositories.PropertyRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

import java.text.ParseException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;

@ExtendWith(MockitoExtension.class)
class CreatePropertyHandlerTest {

	@Mock
	PropertyRepository iProperty;

	@Spy
	IPropertyFactory iPropertyFactory;

	@InjectMocks
	CreatePropertyHandler service;

	@Mock
	RabbitTemplate template;

	@BeforeEach
	void setUp() {
		service = new CreatePropertyHandler(iProperty);
		MockitoAnnotations.openMocks(this);
	}

	@Test
	void handle() throws ParseException, BussinessRuleValidationException {
		PropertyDto expect = PropertyDtoTest.withDefaultResponse();
		CreatePropertyCommand command = new CreatePropertyCommand(PropertyDtoTest.withDefaultResponse());
		Mockito.doNothing().when(template).convertAndSend(anyString(), (Object) any());

		PropertyDto respuesta = service.handle(command);
		assertEquals(expect.getUserId(), respuesta.getUserId());
	}

	@Test
	void handleError() throws ParseException, BussinessRuleValidationException {
		CreatePropertyCommand command = new CreatePropertyCommand(null);
		assertThrows(InvalidDataException.class, () -> service.handle(command));
	}

}