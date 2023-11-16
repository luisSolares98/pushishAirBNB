package com.nur.model;


import com.nur.core.AggregateRoot;
import com.nur.core.BusinessRuleValidationException;
import com.nur.core.Entity;
import com.nur.objects.PrecioValue;
import lombok.Getter;

import java.util.UUID;
@Getter
public class Property extends Entity {


    private String name;

    private PrecioValue amount;

    private String description;

    private UUID userId;



    public Property(UUID id, String name, double amount, String description, UUID userID) throws BusinessRuleValidationException {
        this.id = id;
        this.name = name;
        this.amount = new PrecioValue(amount);
        this.description = description;
        this.userId = userID;
    }

    public Property(String name, double amount, String description, UUID userID) throws BusinessRuleValidationException {
        this.name = name;
        this.amount = new PrecioValue(amount);
        this.description = description;
        this.userId = userID;
    }

    @Override
    public UUID getId() {
        return id;
    }

}
