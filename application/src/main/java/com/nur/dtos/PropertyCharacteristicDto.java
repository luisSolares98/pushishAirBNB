package com.nur.dtos;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Builder
@Setter
@ToString
public class PropertyCharacteristicDto {

	private String id;

	private String propertyId;

	private String characteristicId;

	private String name;

}
