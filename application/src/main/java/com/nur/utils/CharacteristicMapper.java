package com.nur.utils;

import com.nur.dtos.CharacteristicDto;
import com.nur.model.Characteristic;

public class CharacteristicMapper {

	public static CharacteristicDto from(Characteristic characteristic) {
		if (characteristic == null)
			return CharacteristicDto.builder().build();
		return CharacteristicDto.builder().id(characteristic.getId().toString()).name(characteristic.getName()).build();
	}

}