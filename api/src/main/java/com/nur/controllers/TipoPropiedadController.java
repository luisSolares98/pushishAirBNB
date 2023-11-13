package com.nur.controllers;

import an.awesome.pipelinr.Pipeline;
import com.nur.dtos.TipoPropiedadDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.nur.command.tipropiedades.create.CreateTipoCommand;
import com.nur.command.tipropiedades.get.GetTipoPropiedadQuery;
import com.nur.command.tipropiedades.list.GetListTipoPropiedadesQuery;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class TipoPropiedadController {

    Logger logger = LoggerFactory.getLogger(TipoPropiedadController.class);
    final Pipeline pipeline;

    public TipoPropiedadController(Pipeline pipeline) {
        this.pipeline = pipeline;
    }

    @GetMapping("/tipo/{id}")
    public List<TipoPropiedadDto> getTipoPropiedad(@PathVariable String id) {
        GetTipoPropiedadQuery query = new GetTipoPropiedadQuery(id);
        return query.execute(pipeline);
    }

    @GetMapping("/tipo-propiedad")
    public List<TipoPropiedadDto> getListAllTipoPropiedades() {
        GetListTipoPropiedadesQuery query = new GetListTipoPropiedadesQuery();
        return query.execute(pipeline);
    }

    @PostMapping("/create")
    public TipoPropiedadDto createTipo(@RequestBody TipoPropiedadDto tipoDto) {

        CreateTipoCommand createTipoCommand = new CreateTipoCommand(
                tipoDto
        );
        return createTipoCommand.execute(pipeline);
    }
}
