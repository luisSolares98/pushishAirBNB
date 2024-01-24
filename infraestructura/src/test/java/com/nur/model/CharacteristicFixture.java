package com.nur.model;

import com.nur.core.BussinessRuleValidationException;

import java.text.ParseException;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

public class CharacteristicFixture {

	public static Characteristic whitDefault() throws BussinessRuleValidationException, ParseException {
		return new Characteristic(UUID.fromString("effa368e-2f33-49c7-94e4-a4dfb3be2c27"), "AGUA");
	}

	public static List<Characteristic> whitDefaultList() throws BussinessRuleValidationException, ParseException {
		return Arrays.asList(new Characteristic(UUID.fromString("effa368e-2f33-49c7-94e4-a4dfb3be2c27"), "AGUA"),
				new Characteristic(UUID.fromString("effa368e-2f33-49c7-94e4-a4dfb3be2c28"), "LUZ"));
	}

	public static CharacteristicJpaModel whitDefaultJPA() throws BussinessRuleValidationException, ParseException {
		Characteristic characteristic = whitDefault();
		CharacteristicJpaModel model = new CharacteristicJpaModel();
		model.setId(characteristic.getId());
		model.setName(characteristic.getName());
		return model;
	}

	public static List<CharacteristicJpaModel> whitDefaultListJPA()
			throws BussinessRuleValidationException, ParseException {
		return Arrays.asList(
				new CharacteristicJpaModel(UUID.fromString("effa368e-2f33-49c7-94e4-a4dfb3be2c27"), "AGUA"),
				new CharacteristicJpaModel(UUID.fromString("effa368e-2f33-49c7-94e4-a4dfb3be2c28"), "LUZ"));
	}

}
