package com.nur.controllers;

import an.awesome.pipelinr.Pipeline;
import com.nur.command.characteristic.create.CreateCharacteristicCommand;
import com.nur.command.characteristic.create.CreateCharacteristicHandler;
import com.nur.command.characteristic.list.GetListCharacteristicQuery;
import com.nur.dtos.CharacteristicDto;
import com.nur.dtos.CharacteristicDtoTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.ArgumentMatchers.any;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class CharacteristicControllerTest {

	@Mock
	Pipeline pipeline;

	@Mock
	CharacteristicController controller;

	@BeforeEach
	void setUp() {
		controller = new CharacteristicController(pipeline);
	}

	@Test
	void create() throws ParseException {
		CharacteristicDto model = CharacteristicDtoTest.withDefault();
		CharacteristicDto expect = CharacteristicDtoTest.withDefaultResponse();
		Mockito.when(pipeline.send(any(CreateCharacteristicCommand.class))).thenReturn(expect);
		CharacteristicDto response = controller.createCharacteristic(model);
		Assertions.assertEquals(response, expect);
	}

	@Test
	void getAll() throws ParseException {
		List<CharacteristicDto> list = new ArrayList<>();
		list.add(CharacteristicDtoTest.withDefaultResponse());
		Mockito.when(pipeline.send(any(GetListCharacteristicQuery.class))).thenReturn(list);
		List<CharacteristicDto> response = controller.getListAll();
		Assertions.assertEquals(response, list);
	}

}