package com.nur.core;

import java.time.LocalDateTime;
import java.util.UUID;
import lombok.Getter;

@Getter
public abstract class DomainEvent {

	public final LocalDateTime occurredOn;

	public final UUID id;

	protected DomainEvent(LocalDateTime occurredOn) {
		this.id = UUID.randomUUID();
		this.occurredOn = occurredOn;
	}

}
