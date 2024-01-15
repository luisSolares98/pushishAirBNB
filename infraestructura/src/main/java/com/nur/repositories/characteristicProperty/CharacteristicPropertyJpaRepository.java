package com.nur.repositories.characteristicProperty;

import com.nur.core.BussinessRuleValidationException;
import com.nur.model.CharacteristicProperty;
import com.nur.model.CharacteristicPropertyJpaModel;
import com.nur.repositories.CharacteristicPropertyRepository;
import com.nur.utils.CharacteristicPropertyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class CharacteristicPropertyJpaRepository implements CharacteristicPropertyRepository {

	@Autowired
	private CharacteristicPropertyCrudRepository crudRepository;

	@Override
	public UUID update(CharacteristicProperty tipo) {
		CharacteristicPropertyJpaModel seatJpaModel = CharacteristicPropertyUtils.ToJpaEntity(tipo);
		return crudRepository.save(seatJpaModel).getId();
	}

	@Override
	public List<CharacteristicProperty> getAllByProperty() throws BussinessRuleValidationException {
		List<CharacteristicPropertyJpaModel> jpaModels = Streamable.of(crudRepository.findAll()).toList();
		List<CharacteristicProperty> properties = new ArrayList<>();
		for (CharacteristicPropertyJpaModel jpaModel : jpaModels) {

			properties.add(CharacteristicPropertyUtils.jpaModelToCharacteristicProperty(jpaModel));
		}
		return properties;
	}

}
