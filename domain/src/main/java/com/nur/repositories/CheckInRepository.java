package com.nur.repositories;

import com.nur.core.BusinessRuleValidationException;
import java.util.UUID;
import com.nur.model.CheckIn;

public interface CheckInRepository {
  UUID update(CheckIn checkIn);

  CheckIn get(UUID id);

  CheckIn findByPersonAndId(UUID passenger, UUID checkIn)
    throws BusinessRuleValidationException;
}
