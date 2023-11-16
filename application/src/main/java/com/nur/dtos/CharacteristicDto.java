package com.nur.dtos;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.UUID;

@Getter
@Builder
@Setter
@ToString
public class CharacteristicDto {

  public String id;

  public String name;

}
