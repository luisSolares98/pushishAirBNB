package com.nur.model;

import com.nur.core.AggregateRoot;

import java.util.UUID;

public class CharacteristicProperty extends AggregateRoot {

    private UUID characteristicPropertyId;
    private UUID propertyId;

    public CharacteristicProperty(UUID id, UUID characteristicPropertyId, UUID propertyId) {
        this.id = id;
        this.characteristicPropertyId = characteristicPropertyId;
        this.propertyId = propertyId;
    }
    public CharacteristicProperty(UUID characteristicPropertyId, UUID propertyId) {
        this.characteristicPropertyId = characteristicPropertyId;
        this.propertyId = propertyId;
    }
}
