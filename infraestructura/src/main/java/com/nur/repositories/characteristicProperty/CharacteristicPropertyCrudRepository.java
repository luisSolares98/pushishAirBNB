package com.nur.repositories.characteristicProperty;

import com.nur.model.CharacteristicPropertyJpaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CharacteristicPropertyCrudRepository extends JpaRepository<CharacteristicPropertyJpaModel, UUID> {

}
