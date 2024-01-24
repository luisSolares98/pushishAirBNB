package com.nur.command.property.get;

import com.nur.core.BussinessRuleValidationException;
import com.nur.dtos.PropertyDto;
import com.nur.dtos.PropertyDtoTest;
import com.nur.exceptions.InvalidDataException;
import com.nur.factories.property.IPropertyFactory;
import com.nur.model.PropertyFixture;
import com.nur.repositories.PropertyRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.text.ParseException;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class GetPropertyHandlerTest {

	@Mock
	PropertyRepository repository;

	@Spy
	IPropertyFactory factory;

	@Mock
	GetPropertyHandler service;

	@BeforeEach
	void setUp() {
		service = new GetPropertyHandler(repository);
	}

	@Test
	void handle() throws ParseException, BussinessRuleValidationException {
		when(repository.findPropertyById(any(UUID.class))).thenReturn(PropertyFixture.whitDefault());
		PropertyDto expect = PropertyDtoTest.withDefaultResponse();
		GetPropertyQuery command = new GetPropertyQuery(PropertyDtoTest.withDefaultResponse().getId());
		PropertyDto respuesta = service.handle(command);

		assertEquals(expect.getUserId(), respuesta.getUserId());
	}

	@Test
	void handleError() throws ParseException, BussinessRuleValidationException {
		GetPropertyQuery command = new GetPropertyQuery(null);
		assertThrows(InvalidDataException.class, () -> service.handle(command));
	}

}