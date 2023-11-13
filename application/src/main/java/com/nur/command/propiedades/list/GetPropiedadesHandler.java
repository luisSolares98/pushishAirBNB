package com.nur.command.propiedades.list;

import an.awesome.pipelinr.Command;
import com.nur.dtos.PropiedadDto;
import com.nur.core.BusinessRuleValidationException;
import com.nur.model.Propiedad;
import org.springframework.stereotype.Component;
import com.nur.repositories.PropiedadRepository;
import com.nur.utils.PropiedadMapper;

import java.util.List;

@Component
public class GetPropiedadesHandler
        implements Command.Handler<GetPropiedadesQuery, List<PropiedadDto>> {

  private final PropiedadRepository propiedadRepository;

  public GetPropiedadesHandler(PropiedadRepository propiedadRepository) {
    this.propiedadRepository = propiedadRepository;
  }

  @Override
  public List<PropiedadDto> handle(GetPropiedadesQuery command) {
    try {
      List<Propiedad> propiedad = this.propiedadRepository.getAll();
      return propiedad.stream().map(PropiedadMapper::from).toList();
    } catch (BusinessRuleValidationException e) {
      e.printStackTrace();
      return null;
    }
  }
}
