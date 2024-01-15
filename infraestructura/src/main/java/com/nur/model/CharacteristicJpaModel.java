package com.nur.model;

import lombok.*;
import jakarta.persistence.*;
import java.util.UUID;

@Entity
@Getter
@Setter
@Table(name = "characteristic")
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CharacteristicJpaModel {

	@Id
	@Column(nullable = false)
	public UUID id;

	@Column(nullable = false)
	public String name;

}
