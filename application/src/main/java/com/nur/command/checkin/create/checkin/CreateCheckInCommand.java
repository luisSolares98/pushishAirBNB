package com.nur.command.checkin.create.checkin;

import an.awesome.pipelinr.Command;
import com.nur.dtos.CheckInDto;

public class CreateCheckInCommand implements Command<CheckInDto> {

  public CheckInDto checkInDto;

  public CreateCheckInCommand(CheckInDto checkInDto) {
    this.checkInDto = checkInDto;
  }
}
