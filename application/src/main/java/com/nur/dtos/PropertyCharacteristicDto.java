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

    public String id;

    public String propertyId;

    public String characteristicId;

    public String name;

}
