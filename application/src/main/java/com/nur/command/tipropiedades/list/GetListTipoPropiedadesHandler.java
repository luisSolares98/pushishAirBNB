package com.nur.command.tipropiedades.list;

import an.awesome.pipelinr.Command;
import com.nur.dtos.TipoPropiedadDto;
import com.nur.core.BusinessRuleValidationException;
import com.nur.model.TipoPropiedad;
import org.springframework.stereotype.Component;
import com.nur.repositories.TipoPropiedadRepository;
import com.nur.utils.TipoPropiedadMapper;

import java.util.List;

@Component
public class GetListTipoPropiedadesHandler
        implements Command.Handler<GetListTipoPropiedadesQuery, List<TipoPropiedadDto>> {

  private final TipoPropiedadRepository tipo;

  public GetListTipoPropiedadesHandler(TipoPropiedadRepository tipo) {
    this.tipo = tipo;
  }

  @Override
  public List<TipoPropiedadDto> handle(GetListTipoPropiedadesQuery command) {
    try {
      List<TipoPropiedad> tipo = this.tipo.getAll();
      return tipo.stream().map(TipoPropiedadMapper::from).toList();
    } catch (BusinessRuleValidationException e) {
      e.printStackTrace();
      return null;
    }
  }
}
