package com.nur.repositories.characteristic;

import com.nur.model.CharacteristicJpaModel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CharacteristicCrudRepository extends JpaRepository<CharacteristicJpaModel, UUID> {

}
