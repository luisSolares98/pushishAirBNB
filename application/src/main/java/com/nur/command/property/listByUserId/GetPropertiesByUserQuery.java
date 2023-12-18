package com.nur.command.property.listByUserId;

import an.awesome.pipelinr.Command;
import com.nur.dtos.PropertyDto;

import java.util.List;

public class GetPropertiesByUserQuery implements Command<List<PropertyDto>> {

	public final String userId;

	public GetPropertiesByUserQuery(String userId) {
		this.userId = userId;
	}

}
