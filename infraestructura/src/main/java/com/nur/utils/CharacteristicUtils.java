package com.nur.utils;

import com.nur.exceptions.InvalidDataException;
import com.nur.model.CharacteristicJpaModel;
import com.nur.model.Characteristic;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class CharacteristicUtils {

	public static CharacteristicJpaModel tipoToJpaEntity(Characteristic tipo) {
		if (Objects.isNull(tipo))
			throw new InvalidDataException("entity is null");
		CharacteristicJpaModel characteristicJpaModel = new CharacteristicJpaModel();
		characteristicJpaModel.setId(tipo.getId());
		characteristicJpaModel.setName(tipo.getName());
		return characteristicJpaModel;
	}

	public static List<CharacteristicJpaModel> seatsToJpaEntities(List<Characteristic> tipo) {
		if (tipo == null)
			return Collections.emptyList();
		return tipo.stream().map(CharacteristicUtils::tipoToJpaEntity).toList();
	}

	public static Characteristic jpaModelToTipoPropiedad(CharacteristicJpaModel jpaModel) {
		if (Objects.isNull(jpaModel))
			throw new InvalidDataException("jpaModel is null");
		return new Characteristic(jpaModel.getId(), jpaModel.getName());
	}

}
