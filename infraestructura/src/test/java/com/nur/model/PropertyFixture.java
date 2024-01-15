package com.nur.model;

import com.nur.core.BussinessRuleValidationException;

import java.text.ParseException;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

public class PropertyFixture {
    public static Property whitDefault() throws BussinessRuleValidationException, ParseException {
        return new Property(UUID.fromString("effa368e-2f33-49c7-94e4-a4dfb3be2c20"), "test", 10.0, "test description", "disponible", UUID.fromString("effa368e-2f33-49c7-94e4-a4dfb3be2c10"));
    }

    public static List<Property> whitDefaultList() throws BussinessRuleValidationException, ParseException {
        return Arrays.asList(
                new Property(UUID.fromString("effa368e-2f33-49c7-94e4-a4dfb3be2c20"), "test", 10.0, "test description", "disponible", UUID.fromString("effa368e-2f33-49c7-94e4-a4dfb3be2c10")),
                new Property(UUID.fromString("effa368e-2f33-49c7-94e4-a4dfb3be2c21"), "test", 11.0, "test description", "disponible", UUID.fromString("effa368e-2f33-49c7-94e4-a4dfb3be2c10")));
    }

    public static PropertyJpaModel whitDefaultJPA() throws BussinessRuleValidationException, ParseException {
        Property property = whitDefault();
        PropertyJpaModel model = new PropertyJpaModel();
        model.setId(property.getId());
        model.setName(property.getName());
        model.setDescription(property.getDescription());
        model.setUserID(property.getUserId());
        model.setAmount(property.getAmount());
        model.setState(property.getState());
        return model;
    }

    public static List<PropertyJpaModel> whitDefaultListJPA() throws BussinessRuleValidationException, ParseException {
        return Arrays.asList(new PropertyJpaModel(UUID.fromString("effa368e-2f33-49c7-94e4-a4dfb3be2c20"), "test", "test description", 10.0, "disponible", UUID.fromString("effa368e-2f33-49c7-94e4-a4dfb3be2c10")),
                new PropertyJpaModel(UUID.fromString("effa368e-2f33-49c7-94e4-a4dfb3be2c21"), "test",  "test description",11.0, "disponible", UUID.fromString("effa368e-2f33-49c7-94e4-a4dfb3be2c10")));
    }
}
