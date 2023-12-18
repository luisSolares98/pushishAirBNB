package com.nur.command.characteristicProperty.list;

import com.nur.dtos.PropertyCharacteristicDto;
import java.util.List;
import an.awesome.pipelinr.Command;

public class GetCharacteristicByPropertyQuery implements Command<List<PropertyCharacteristicDto>> {

	public final String property;

	public GetCharacteristicByPropertyQuery(String property) {
		this.property = property;
	}

}
