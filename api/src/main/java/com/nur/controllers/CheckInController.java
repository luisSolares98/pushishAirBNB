package com.nur.controllers;

import an.awesome.pipelinr.Pipeline;
import com.nur.dtos.CheckInDto;
import com.nur.dtos.PropiedadDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import com.nur.command.checkin.assign.propiedad.AssignPropiedadCommand;
import com.nur.command.checkin.create.checkin.CreateCheckInCommand;
import com.nur.command.checkin.get.checkin.GetCheckInQuery;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class CheckInController {

  Logger logger = LoggerFactory.getLogger(CheckInController.class);
  final Pipeline pipeline;

  public CheckInController(Pipeline pipeline) {
    this.pipeline = pipeline;
  }

  @PostMapping("/assign-propiedad")
  public PropiedadDto assignPropiedad(@RequestBody CheckInDto checkInDto) {
    AssignPropiedadCommand assignSeatCommand = new AssignPropiedadCommand(checkInDto);
    return assignSeatCommand.execute(pipeline);
  }


  @PostMapping("/create-checkin")
  public CheckInDto createCheckIn(@RequestBody CheckInDto checkInDto) {
    CreateCheckInCommand createCheckInCommand = new CreateCheckInCommand(
      checkInDto
    );
    return createCheckInCommand.execute(pipeline);
  }

  @GetMapping("/checkIn/{checkInId}/{personaId}")
  public CheckInDto getCheckIn(
    @PathVariable String checkInId,
    @PathVariable String passengerId
  ) {
    GetCheckInQuery query = new GetCheckInQuery(checkInId, passengerId);
    return query.execute(pipeline);
  }
}
