package com.nur.command.checkin.create.checkin;

import an.awesome.pipelinr.Command;
import com.nur.dtos.CheckInDto;
import com.nur.core.BusinessRuleValidationException;
import com.nur.factories.check.in.CheckInFactory;
import com.nur.factories.check.in.CreateCheckIn;
import com.nur.factories.propiedad.PropiedadFactory;

import java.util.List;
import java.util.UUID;
import com.nur.model.CheckIn;
import com.nur.model.Persona;
import com.nur.model.Propiedad;
import org.springframework.stereotype.Component;
import com.nur.repositories.CheckInRepository;
import com.nur.repositories.PersonaRepository;
import com.nur.repositories.PropiedadRepository;
import com.nur.utils.CheckInMapper;

@Component
public class CreateCheckInHandler
  implements Command.Handler<CreateCheckInCommand, CheckInDto> {

  private final CheckInRepository checkInRepository;
  private final PropiedadRepository propiedadRepository;
  private final PropiedadFactory propiedadFactory;
  private final CheckInFactory checkInFactory;
  private final PersonaRepository personaRepository;

  public CreateCheckInHandler(
    CheckInRepository checkInRepository,
    PropiedadRepository seatRepository,
    PersonaRepository passangerRepository
  ) {
    this.checkInRepository = checkInRepository;
    this.propiedadRepository = seatRepository;
    this.personaRepository = passangerRepository;
    this.propiedadFactory = new PropiedadFactory();
    this.checkInFactory = new CreateCheckIn();
  }

  @Override
  public CheckInDto handle(CreateCheckInCommand request) {
    try {
      CheckIn checkIn = checkInRepository.findByPersonAndId(
        UUID.fromString(request.checkInDto.persona.id),
        UUID.fromString(request.checkInDto.propiedadId)
      );
      if (checkIn != null) {
        return CheckInMapper.from(checkIn);
      }
      Persona passanger =
        this.personaRepository.get(
            UUID.fromString(request.checkInDto.persona.id)
          );

      List<Propiedad> avaibleSeats = propiedadRepository.findPropiedadById(
        UUID.fromString(request.checkInDto.propiedadId)
      );

      checkIn =
        checkInFactory.create(
          UUID.fromString(request.checkInDto.propiedadId),
          avaibleSeats,
          passanger
        );
      checkInRepository.update(checkIn);
      return CheckInMapper.from(checkIn);
    } catch (BusinessRuleValidationException e) {
      return null;
    }
  }
}
