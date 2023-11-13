package com.nur.dtos;

import com.nur.annotations.Generated;
import java.util.Date;

@Generated
public class PersonaDto {

  public String id;
  public String name;
  public String lastname;
  public Date birthday;
  public String ci;
  public boolean needAssistance;

  public PersonaDto() {}

  public PersonaDto(
    String id,
    String name,
    String lastname,

    String ci

  ) {
    this.id = id;
    this.name = name;
    this.lastname = lastname;

    this.ci = ci;
  }
}
