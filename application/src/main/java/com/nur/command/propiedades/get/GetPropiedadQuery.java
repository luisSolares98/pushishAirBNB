package com.nur.command.propiedades.get;

import an.awesome.pipelinr.Command;
import com.nur.dtos.PropiedadDto;

import java.util.List;

public class GetPropiedadQuery implements Command<List<PropiedadDto>> {

  String id;

  public GetPropiedadQuery(String id) {
    this.id = id;
  }
}
