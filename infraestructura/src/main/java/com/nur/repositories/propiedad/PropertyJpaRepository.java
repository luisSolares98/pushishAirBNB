package com.nur.repositories.propiedad;

import com.nur.exceptions.InvalidDataException;
import com.nur.model.PropertyJpaModel;
import com.nur.utils.PropertyUtils;
import com.nur.core.BussinessRuleValidationException;
import com.nur.model.Property;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Streamable;
import com.nur.repositories.PropertyRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Service
public class PropertyJpaRepository implements PropertyRepository {

	@Autowired
	private PropertyCrudRepository propertyCrudRepository;

	@Override
	public UUID update(Property propiedad) {
		PropertyJpaModel propiedadJpaModel = PropertyUtils.propiedadToJpaEntity(propiedad);
		return propertyCrudRepository.save(propiedadJpaModel).getId();
	}

	@Override
	public Property findPropertyById(UUID id) throws BussinessRuleValidationException {

		return PropertyUtils.jpaModelToPropiedad(propertyCrudRepository.findById(id).orElse(null));

	}

	@Override
	public UUID deletePropertyById(UUID id) throws BussinessRuleValidationException {

		PropertyJpaModel propertyJpaModel = propertyCrudRepository.findById(id).orElse(null);
		if (Objects.isNull(propertyJpaModel))
			throw new InvalidDataException("jpaModel is null");
		propertyJpaModel.setState("Disable");
		propertyCrudRepository.save(propertyJpaModel);
		return id;
	}

	@Override
	public List<Property> getAll() throws BussinessRuleValidationException {
		List<PropertyJpaModel> jpaModels = Streamable.of(propertyCrudRepository.findAll()).toList();
		List<Property> propiedads = new ArrayList<>();
		for (PropertyJpaModel jpaModel : jpaModels) {
			propiedads.add(PropertyUtils.jpaModelToPropiedad(jpaModel));
		}
		return propiedads;
	}

}
