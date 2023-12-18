package com.nur.model;

import com.nur.core.AggregateRoot;
import lombok.Getter;

import java.util.UUID;

@Getter
public class CharacteristicProperty extends AggregateRoot {

	private UUID characteristicId;

	private UUID propertyId;

	public CharacteristicProperty(UUID id, UUID characteristicPropertyId, UUID propertyId) {
		this.id = id;
		this.characteristicId = characteristicPropertyId;
		this.propertyId = propertyId;
	}

	public CharacteristicProperty(UUID characteristicPropertyId, UUID propertyId) {
		this.characteristicId = characteristicPropertyId;
		this.propertyId = propertyId;
	}

}
