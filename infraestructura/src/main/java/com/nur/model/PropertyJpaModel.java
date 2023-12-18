package com.nur.model;

import lombok.*;
import jakarta.persistence.*;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "property")
public class PropertyJpaModel {

	@Id
	@Column(nullable = false)
	public UUID id;

	@Column(nullable = false)
	public String name;

	@Column(nullable = false)
	public String description;

	@Column(nullable = false)
	public double amount;

	@Column(nullable = false)
	public String state;

	@Column(nullable = false)
	public UUID userID;

}
