package com.nur.repositories;

import com.nur.core.BusinessRuleValidationException;
import java.util.List;
import java.util.UUID;
import com.nur.model.Transaccion;

public interface TransactionRepository {
  UUID update(Transaccion transaccion);

  //List<Transaccion> findByFlightIdAndStatus(UUID flightId, String status)
    //throws BusinessRuleValidationException;

  List<Transaccion> findByTransactionCode(UUID flightId)
    throws BusinessRuleValidationException;
}
