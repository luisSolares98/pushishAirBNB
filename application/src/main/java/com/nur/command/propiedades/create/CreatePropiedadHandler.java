package com.nur.command.propiedades.create;

import an.awesome.pipelinr.Command;
import com.nur.dtos.PropiedadDto;
import com.nur.core.BusinessRuleValidationException;
import com.nur.factories.propiedad.PropiedadFactory;
import com.nur.model.Propiedad;
import org.springframework.stereotype.Component;
import com.nur.repositories.PropiedadRepository;
import com.nur.utils.PropiedadMapper;

import java.util.UUID;

@Component
public class CreatePropiedadHandler
  implements Command.Handler<CreatePropiedadCommand, PropiedadDto> {

  private final PropiedadRepository propiedadRepository;

  private final PropiedadFactory propiedadFactory;


  public CreatePropiedadHandler(
          PropiedadRepository propiedadRepository

  ) {
    this.propiedadRepository = propiedadRepository;

    this.propiedadFactory = new PropiedadFactory();
  }

  @Override
  public PropiedadDto handle(CreatePropiedadCommand request) {
    try {
     Propiedad propiedad =
        propiedadFactory.create(
          UUID.fromString(request.propiedadDto.id.toString()),
          request.propiedadDto.nombre,
                request.propiedadDto.estado,
                request.propiedadDto.precio
        );
      propiedadRepository.update(propiedad);
      return PropiedadMapper.from(propiedad);
    } catch (BusinessRuleValidationException e) {
      return null;
    }
  }
}
