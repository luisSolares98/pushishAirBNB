package com.nur.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Entity
@Getter
@Setter
@Table(name = "CharacteristicProperty")
public class CharacteristicPropertyJpaModel {

	@Id
	@Column(nullable = false)
	public UUID id;

	@Column(name = "characteristicId", nullable = false)
	public UUID characteristicId;

	@Column(name = "propertyId", nullable = false)
	public UUID propertyId;

}
