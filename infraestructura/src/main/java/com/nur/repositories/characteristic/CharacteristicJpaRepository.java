package com.nur.repositories.characteristic;

import com.nur.model.CharacteristicJpaModel;
import com.nur.utils.CharacteristicUtils;
import com.nur.core.BussinessRuleValidationException;
import com.nur.model.Characteristic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Streamable;
import com.nur.repositories.CharacteristicRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class CharacteristicJpaRepository implements CharacteristicRepository {

	@Autowired
	private CharacteristicCrudRepository crudRepository;

	@Override
	public UUID update(Characteristic tipo) {
		CharacteristicJpaModel seatJpaModel = CharacteristicUtils.tipoToJpaEntity(tipo);
		return crudRepository.save(seatJpaModel).getId();
	}

	@Override
	public List<Characteristic> getAll() throws BussinessRuleValidationException {
		List<CharacteristicJpaModel> jpaModels = Streamable.of(crudRepository.findAll()).toList();
		List<Characteristic> tipos = new ArrayList<>();
		for (CharacteristicJpaModel jpaModel : jpaModels) {
			tipos.add(CharacteristicUtils.jpaModelToTipoPropiedad(jpaModel));
		}
		return tipos;
	}

}
