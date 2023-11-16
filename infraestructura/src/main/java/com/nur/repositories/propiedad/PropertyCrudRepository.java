package com.nur.repositories.propiedad;

import com.nur.model.PropertyJpaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface PropertyCrudRepository extends JpaRepository<PropertyJpaModel, UUID> {

}
