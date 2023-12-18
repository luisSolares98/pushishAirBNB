package com.nur.dtos;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Builder
@Setter
@ToString
public class PropertyDto {

  private String id;

  private String name;

  private String description;

  private double amount;

  private String state;

  private String userId;
}
