package com.nur.repositories.check.in;

import com.nur.model.CheckInJpaModel;
import com.nur.model.PersonaJpaModel;
import java.util.UUID;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CheckInCrudRepository
  extends CrudRepository<CheckInJpaModel, UUID> {
  CheckInJpaModel findByPersonaAndPersonaId(
    PersonaJpaModel passanger,
    UUID flightId
  );
}
