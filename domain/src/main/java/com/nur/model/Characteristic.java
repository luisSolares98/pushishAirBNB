package com.nur.model;

import com.nur.core.Entity;

import java.util.UUID;

public class Characteristic extends Entity {

	private String name;

	public Characteristic() {
	}

	public Characteristic(String name) {
		this.name = name;
	}

	public Characteristic(UUID id, String name) {
		this.id = id;
		this.name = name;
	}

	@Override
	public UUID getId() {
		return this.id;
	}

	public String getName() {
		return name;
	}

}
