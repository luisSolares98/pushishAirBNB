package com.nur.command.property.list;

import an.awesome.pipelinr.Command;
import lombok.AllArgsConstructor;
import com.nur.dtos.PropertyDto;
import java.util.List;

@AllArgsConstructor
public class GetPropertiesQuery implements Command<List<PropertyDto>> {
}
