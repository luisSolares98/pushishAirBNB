package com.nur.repositories.propiedad;

import com.nur.model.PropiedadJpaModel;
import com.nur.utils.PropiedadUtils;
import com.nur.core.BusinessRuleValidationException;
import com.nur.model.Propiedad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Repository;
import com.nur.repositories.PropiedadRepository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

@Primary
@Repository
public class PropiedadJpaRepository implements PropiedadRepository {

  @Autowired
  private PropiedadCrudRepository propiedadCrudRepository;

  @Override
  public UUID update(Propiedad propiedad) {
    PropiedadJpaModel propiedadJpaModel = PropiedadUtils.propiedadToJpaEntity(propiedad);
    return propiedadCrudRepository.save(propiedadJpaModel).getId();
  }

  @Override
  public List<Propiedad> findByIdAndEstado(UUID id, String estado) throws BusinessRuleValidationException {

      List<PropiedadJpaModel> jpaModels = propiedadCrudRepository.findByIdAndEstado(
              id,
              estado
      );
      if (
              jpaModels == null || jpaModels.size() == 0
      ) return Collections.emptyList();
      List<Propiedad> propiedads = new ArrayList<>();
      for (PropiedadJpaModel jpaModel : jpaModels) {
        propiedads.add(PropiedadUtils.jpaModelToPropiedad(jpaModel));
      }
      return propiedads;
  }

    @Override
    public List<Propiedad> findPropiedadById(UUID id) throws BusinessRuleValidationException {
        List<PropiedadJpaModel> jpaModels = propiedadCrudRepository.findPropiedadById(id);
        if (
                jpaModels == null || jpaModels.isEmpty()
        ) return Collections.emptyList();
        List<Propiedad> propiedades = new ArrayList<>();
        for (PropiedadJpaModel jpaModel : jpaModels) {
            propiedades.add(PropiedadUtils.jpaModelToPropiedad(jpaModel));
        }
        return propiedades;
    }

    @Override
    public List<Propiedad> getAll() throws BusinessRuleValidationException {
        List<PropiedadJpaModel> jpaModels = Streamable
                .of(propiedadCrudRepository.findAll())
                .toList();
        List<Propiedad> propiedads = new ArrayList<>();
        for (PropiedadJpaModel jpaModel : jpaModels) {
            propiedads.add(PropiedadUtils.jpaModelToPropiedad(jpaModel));
        }
        return propiedads;
    }


    public void setPropiedadCrudRepository(PropiedadCrudRepository propiedadCrudRepository) {
        this.propiedadCrudRepository = propiedadCrudRepository;
    }



}
