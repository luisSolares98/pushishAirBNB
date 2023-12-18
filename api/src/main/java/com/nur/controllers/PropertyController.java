package com.nur.controllers;

import an.awesome.pipelinr.Pipeline;
import com.nur.command.characteristicProperty.create.CreateCharacteristicPropertyCommand;
import com.nur.command.characteristicProperty.list.GetCharacteristicByPropertyQuery;
import com.nur.command.property.delete.DeletePropertyQuery;
import com.nur.command.property.listByUserId.GetPropertiesByUserQuery;
import com.nur.dtos.PropertyCharacteristicDto;
import com.nur.dtos.PropertyDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import com.nur.command.property.create.CreatePropertyCommand;
import com.nur.command.property.get.GetPropertyQuery;
import com.nur.command.property.list.GetPropertiesQuery;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/property")
public class PropertyController {

	Logger logger = LoggerFactory.getLogger(PropertyController.class);

	final Pipeline pipeline;

	public PropertyController(Pipeline pipeline) {
		this.pipeline = pipeline;
	}

	@GetMapping("/{propId}")
	public PropertyDto getProperty(@PathVariable String propId) {
		GetPropertyQuery query = new GetPropertyQuery(propId);
		return query.execute(pipeline);
	}

	@GetMapping("/")
	public List<PropertyDto> getListAllProperty() {
		GetPropertiesQuery query = new GetPropertiesQuery();
		return query.execute(pipeline);
	}

	@GetMapping("/characteristic/{propertyId}")
	public List<PropertyCharacteristicDto> getCharacteristicByPropertyId(@PathVariable String propertyId) {
		GetCharacteristicByPropertyQuery query = new GetCharacteristicByPropertyQuery(propertyId);
		return query.execute(pipeline);
	}

	@GetMapping("/users/{userId}")
	public List<PropertyDto> getListAllPropertyByUserId(@PathVariable String userId) {
		GetPropertiesByUserQuery query = new GetPropertiesByUserQuery(userId);
		return query.execute(pipeline);
	}

	@PostMapping("/")
	public PropertyDto createProperty(@RequestBody PropertyDto propertyDto) {
		propertyDto.setState("Active");
		CreatePropertyCommand command = new CreatePropertyCommand(propertyDto);
		return command.execute(pipeline);
	}

	@GetMapping("/delete/{propertyId}")
	public UUID dropProperty(@PathVariable String propertyId) {
		DeletePropertyQuery command = new DeletePropertyQuery(propertyId);
		return command.execute(pipeline);
	}

	@PostMapping("/characteristic")
	public PropertyCharacteristicDto createCharacteristicProperty(@RequestBody PropertyCharacteristicDto propertyDto) {

		CreateCharacteristicPropertyCommand command = new CreateCharacteristicPropertyCommand(propertyDto);
		return command.execute(pipeline);
	}

}
