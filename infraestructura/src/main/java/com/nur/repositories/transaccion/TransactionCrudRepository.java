package com.nur.repositories.transaccion;

import com.nur.model.TransactionJpaModel;

import java.util.List;
import java.util.UUID;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionCrudRepository extends CrudRepository<TransactionJpaModel, UUID> {
  //List<TransaccionJpaModel> findByFlightIdAndStatus(UUID flight, String status);

  List<TransactionJpaModel> findByCode(UUID id);
}
