package com.nur.command.checkin.assign.propiedad;

import an.awesome.pipelinr.Command;
import com.nur.dtos.CheckInDto;
import com.nur.dtos.PropiedadDto;

public class AssignPropiedadCommand implements Command<PropiedadDto> {

  CheckInDto checkInDto;

  public AssignPropiedadCommand(CheckInDto checkInDto) {
    this.checkInDto = checkInDto;
  }
}
