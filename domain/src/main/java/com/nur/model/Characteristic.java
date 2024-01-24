package com.nur.model;

import com.nur.core.Entity;
import lombok.Getter;
import lombok.ToString;

import java.util.UUID;

@ToString
@Getter
public class Characteristic extends Entity {

	private String name;

	public Characteristic(String name) {
		this.name = name;
	}

	public Characteristic(UUID id, String name) {
		this.id = id;
		this.name = name;
	}

}
