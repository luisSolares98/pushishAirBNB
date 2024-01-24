package com.nur.model;

import com.nur.core.BussinessRuleValidationException;

import java.text.ParseException;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

public class PropertyFixture {

	public static Property whitDefault() throws BussinessRuleValidationException, ParseException {
		return new Property(UUID.fromString("effa368e-2f33-49c7-94e4-a4dfb3be2c20"), "test", 10.0, "test description",
				"disponible", UUID.fromString("effa368e-2f33-49c7-94e4-a4dfb3be2c10"));
	}

	public static List<Property> whitDefaultList() throws BussinessRuleValidationException, ParseException {
		return Arrays.asList(
				new Property(UUID.fromString("effa368e-2f33-49c7-94e4-a4dfb3be2c20"), "test", 10.0, "test description",
						"disponible", UUID.fromString("effa368e-2f33-49c7-94e4-a4dfb3be2c10")),
				new Property(UUID.fromString("effa368e-2f33-49c7-94e4-a4dfb3be2c21"), "test", 11.0, "test description",
						"disponible", UUID.fromString("effa368e-2f33-49c7-94e4-a4dfb3be2c10")));
	}

}