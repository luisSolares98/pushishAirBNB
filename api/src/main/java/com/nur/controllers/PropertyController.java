package com.nur.controllers;

import an.awesome.pipelinr.Pipeline;
import com.nur.command.property.listByUserId.GetPropertiesByUserQuery;
import com.nur.dtos.PropertyDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import com.nur.command.property.create.CreatePropertyCommand;
import com.nur.command.property.get.GetPropertyQuery;
import com.nur.command.property.list.GetPropertiesQuery;

import java.util.List;

@CrossOrigin(origins = "*")
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

    @GetMapping("/users/{userId}")
    public List<PropertyDto> getListAllPropertyByUserId(@PathVariable String userId) {
        GetPropertiesByUserQuery query = new GetPropertiesByUserQuery(userId);
        return query.execute(pipeline);
    }

    @PostMapping("/")
    public PropertyDto createProperty(@RequestBody PropertyDto propertyDto) {

        CreatePropertyCommand command = new CreatePropertyCommand(
                propertyDto
        );
        return command.execute(pipeline);
    }
}
