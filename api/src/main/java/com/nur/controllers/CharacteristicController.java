package com.nur.controllers;

import an.awesome.pipelinr.Pipeline;
import com.nur.dtos.CharacteristicDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import com.nur.command.characteristic.create.CreateCharacteristicCommand;
import com.nur.command.characteristic.list.GetListCharacteristicQuery;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/characteristic")
public class CharacteristicController {

    Logger logger = LoggerFactory.getLogger(CharacteristicController.class);
    final Pipeline pipeline;

    public CharacteristicController(Pipeline pipeline) {
        this.pipeline = pipeline;
    }


    @GetMapping("/")
    public List<CharacteristicDto> getListAll() {
        GetListCharacteristicQuery query = new GetListCharacteristicQuery();
        return query.execute(pipeline);
    }

    @PostMapping("/")
    public CharacteristicDto createCharacteristic(@RequestBody CharacteristicDto tipoDto) {

        CreateCharacteristicCommand command = new CreateCharacteristicCommand(
                tipoDto
        );
        return command.execute(pipeline);
    }
}
