package com.nur.repositories.transaccion;

import com.nur.model.TransactionJpaModel;
import com.nur.utils.TransaccionUtils;
import com.nur.core.BusinessRuleValidationException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import com.nur.model.Transaccion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.nur.repositories.TransactionRepository;

@Repository
public class TransactionJpaRepository implements TransactionRepository {

  @Autowired
  private TransactionCrudRepository seatCrudRepository;

  @Override
  public UUID update(Transaccion seat) {
    TransactionJpaModel seatJpaModel = TransaccionUtils.seatToJpaEntity(seat);
    return seatCrudRepository.save(seatJpaModel).getCode();
  }

  /*@Override
  public List<Transaccion> findByFlightIdAndStatus(UUID flightId, String status)
    throws BusinessRuleValidationException {
    List<TransaccionJpaModel> jpaModels = seatCrudRepository.findByFlightIdAndStatus(
      flightId,
      status
    );
    if (
      jpaModels == null || jpaModels.size() == 0
    ) return Collections.emptyList();
    List<Transaccion> seats = new ArrayList<>();
    for (TransaccionJpaModel jpaModel : jpaModels) {
      seats.add(TransaccionUtils.jpaModelToSeat(jpaModel));
    }
    return seats;
  }*/

  @Override
  public List<Transaccion> findByTransactionCode(UUID flightId)
    throws BusinessRuleValidationException {
    List<TransactionJpaModel> jpaModels = seatCrudRepository.findByCode(flightId);
    if (
      jpaModels == null || jpaModels.isEmpty()
    ) return Collections.emptyList();
    List<Transaccion> seats = new ArrayList<>();
    for (TransactionJpaModel jpaModel : jpaModels) {
      seats.add(TransaccionUtils.jpaModelToSeat(jpaModel));
    }
    return seats;
  }

  public void setSeatCrudRepository(TransactionCrudRepository seatCrudRepository) {
    this.seatCrudRepository = seatCrudRepository;
  }
}
