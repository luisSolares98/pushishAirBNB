package com.nur.repositories.MetodoPago;

import com.nur.model.MetodoPagoJpaModel;

import java.util.List;
import java.util.UUID;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MetodoPagoCrudRepository
  extends CrudRepository<MetodoPagoJpaModel, UUID> {

  List<MetodoPagoJpaModel> findMetodoPagoById(UUID id);
}
