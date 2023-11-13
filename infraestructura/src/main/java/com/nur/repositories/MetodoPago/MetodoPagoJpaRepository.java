package com.nur.repositories.MetodoPago;

import com.nur.model.MetodoPagoJpaModel;
import com.nur.utils.MetodoPagoUtils;
import com.nur.core.BusinessRuleValidationException;
import com.nur.model.MetodoPago;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import com.nur.repositories.MetodoPagoRepository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

@Primary
@Repository
public class MetodoPagoJpaRepository implements MetodoPagoRepository {

  @Autowired
  private MetodoPagoCrudRepository baggageCrudRepository;

  @Override
  public UUID update(MetodoPago baggage) {

    MetodoPagoJpaModel jpaModel = MetodoPagoUtils.baggageToJpaEntity(
      baggage
    );
    return baggageCrudRepository.save(jpaModel).getId();
  }

  @Override
  public List<MetodoPago> findMetodoPagoById(UUID metodoId)
    throws BusinessRuleValidationException {

    List<MetodoPagoJpaModel> jpaModels = baggageCrudRepository.findMetodoPagoById(metodoId
    );
    List<MetodoPago> baggages = new ArrayList<>();
    if (
      jpaModels == null || jpaModels.isEmpty()
    ) return Collections.emptyList();
    for (MetodoPagoJpaModel jpaModel : jpaModels) {
      baggages.add(MetodoPagoUtils.jpaToBaggage(jpaModel));
    }
    return baggages;
  }

  public void setBaggageCrudRepository(
    MetodoPagoCrudRepository baggageCrudRepository
  ) {
    this.baggageCrudRepository = baggageCrudRepository;
  }


}
