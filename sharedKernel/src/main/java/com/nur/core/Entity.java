package com.nur.core;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
public abstract class Entity {

	public UUID id;

	public final List<DomainEvent> domainEvents;

	protected Entity() {
		id = UUID.randomUUID();
		domainEvents = new ArrayList<>();
	}

	public void addDomainEvents(DomainEvent event) {
		this.domainEvents.add(event);
	}

	public void setKey(UUID key) {
		this.id = key;
	}

}
