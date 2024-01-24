package com.nur.controllers;

import an.awesome.pipelinr.Pipeline;
import com.nur.command.characteristic.create.CreateCharacteristicCommand;
import com.nur.command.characteristic.list.GetListCharacteristicQuery;
import com.nur.command.characteristicProperty.create.CreateCharacteristicPropertyCommand;
import com.nur.command.characteristicProperty.list.GetCharacteristicByPropertyQuery;
import com.nur.command.property.create.CreatePropertyCommand;
import com.nur.command.property.delete.DeletePropertyQuery;
import com.nur.command.property.get.GetPropertyQuery;
import com.nur.command.property.list.GetPropertiesQuery;
import com.nur.command.property.listByUserId.GetPropertiesByUserQuery;
import com.nur.dtos.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
class PropertyControllerTest {

	@Mock
	Pipeline pipeline;

	@Mock
	PropertyController controller;

	@BeforeEach
	void setUp() {
		controller = new PropertyController(pipeline);
	}

	@Test
	void createProperty() throws ParseException {
		PropertyDto model = PropertyDtoTest.withDefault();
		PropertyDto expect = PropertyDtoTest.withDefaultResponse();
		Mockito.when(pipeline.send(any(CreatePropertyCommand.class))).thenReturn(expect);
		PropertyDto response = controller.createProperty(model);
		Assertions.assertEquals(response, expect);
	}

	@Test
	void createCharacteristicProperty() throws ParseException {
		PropertyCharacteristicDto model = PropertyCharacteristicDtoTest.withDefault();
		PropertyCharacteristicDto expect = PropertyCharacteristicDtoTest.withDefaultResponse();
		Mockito.when(pipeline.send(any(CreateCharacteristicPropertyCommand.class))).thenReturn(expect);
		PropertyCharacteristicDto response = controller.createCharacteristicProperty(model);
		Assertions.assertEquals(response, expect);
	}

	@Test
	void getAll() throws ParseException {
		List<PropertyDto> list = new ArrayList<>();
		list.add(PropertyDtoTest.withDefaultResponse());
		Mockito.when(pipeline.send(any(GetPropertiesQuery.class))).thenReturn(list);
		List<PropertyDto> response = controller.getListAllProperty();
		Assertions.assertEquals(response, list);
	}

	@Test
	void getById() throws ParseException {
		PropertyDto expect = PropertyDtoTest.withDefaultResponse();
		Mockito.when(pipeline.send(any(GetPropertyQuery.class))).thenReturn(expect);
		PropertyDto response = controller.getProperty("effa368e-2f33-49c7-94e4-a4dfb3be2c20");
		Assertions.assertEquals(response, expect);
	}

	@Test
	void getAllByUserId() throws ParseException {
		List<PropertyDto> list = new ArrayList<>();
		list.add(PropertyDtoTest.withDefaultResponse());
		Mockito.when(pipeline.send(any(GetPropertiesByUserQuery.class))).thenReturn(list);
		List<PropertyDto> response = controller.getListAllPropertyByUserId("effa368e-2f33-49c7-94e4-a4dfb3be2c10");
		Assertions.assertEquals(response, list);
	}

	@Test
	void getCharacteristicByPropertyId() throws ParseException {
		List<PropertyCharacteristicDto> list = new ArrayList<>();
		list.add(PropertyCharacteristicDtoTest.withDefaultResponse());
		Mockito.when(pipeline.send(any(GetCharacteristicByPropertyQuery.class))).thenReturn(list);
		List<PropertyCharacteristicDto> response = controller
				.getCharacteristicByPropertyId("effa368e-2f33-49c7-94e4-a4dfb3be2c37");
		Assertions.assertEquals(response, list);
	}

	@Test
	void DropById() throws ParseException {
		PropertyDto expect = PropertyDtoTest.withDefaultResponse();
		Mockito.when(pipeline.send(any(DeletePropertyQuery.class))).thenReturn(UUID.fromString(expect.getId()));
		UUID response = controller.dropProperty("effa368e-2f33-49c7-94e4-a4dfb3be2c20");
		Assertions.assertEquals(response.toString(), expect.getId());
	}

}