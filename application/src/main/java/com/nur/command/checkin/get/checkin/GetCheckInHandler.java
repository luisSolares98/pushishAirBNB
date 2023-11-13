package com.nur.command.checkin.get.checkin;

import an.awesome.pipelinr.Command;
import com.nur.dtos.CheckInDto;
import com.nur.core.BusinessRuleValidationException;

import java.util.UUID;
import com.nur.model.CheckIn;
import org.springframework.stereotype.Component;
import com.nur.repositories.CheckInRepository;
import com.nur.utils.CheckInMapper;

@Component
public class GetCheckInHandler
  implements Command.Handler<GetCheckInQuery, CheckInDto> {

  private final CheckInRepository checkInRepository;

  public GetCheckInHandler(CheckInRepository checkInRepository) {
    this.checkInRepository = checkInRepository;
  }

  @Override
  public CheckInDto handle(GetCheckInQuery query) {
    CheckIn checkIn = null;
    try {
      checkIn =
        this.checkInRepository.findByPersonAndId(
            UUID.fromString(query.passengerId),
            UUID.fromString(query.flightId)
          );
    } catch (BusinessRuleValidationException e) {
      e.printStackTrace();
    }
    return CheckInMapper.from(checkIn);
  }
}
