package com.nur.repositories.tipoPropiedad;

import com.nur.model.TipoPropiedadJpaModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface TipoPropiedadCrudRepository extends CrudRepository<TipoPropiedadJpaModel, UUID> {

  List<TipoPropiedadJpaModel>findTipoPropiedadById(UUID id);
}
