package com.nur.command.property.get;

import com.nur.dtos.PropertyDto;

import an.awesome.pipelinr.Command;

public class GetPropertyQuery implements Command<PropertyDto> {

	String id;

	public GetPropertyQuery(String id) {
		this.id = id;
	}

}
