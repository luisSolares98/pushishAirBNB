package com.nur.controllers;

import an.awesome.pipelinr.Pipeline;
import com.nur.dtos.PropiedadDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.nur.command.propiedades.create.CreatePropiedadCommand;
import com.nur.command.propiedades.get.GetPropiedadQuery;
import com.nur.command.propiedades.list.GetPropiedadesQuery;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class PropiedadController {

    Logger logger = LoggerFactory.getLogger(PropiedadController.class);
    final Pipeline pipeline;

    public PropiedadController(Pipeline pipeline) {
        this.pipeline = pipeline;
    }

    @GetMapping("/propiedad/{propId}")
    public List<PropiedadDto> getPropiedad(@PathVariable String propId) {
        GetPropiedadQuery query = new GetPropiedadQuery(propId);
        return query.execute(pipeline);
    }

    @GetMapping("/propiedades")
    public List<PropiedadDto> getListAllPropiedades() {
        GetPropiedadesQuery query = new GetPropiedadesQuery();
        return query.execute(pipeline);
    }

    @PostMapping("/create-propiedad")
    public PropiedadDto createPropiedad(@RequestBody PropiedadDto propiedad) {

        CreatePropiedadCommand command = new CreatePropiedadCommand(
                propiedad
        );
        return command.execute(pipeline);
    }
}
