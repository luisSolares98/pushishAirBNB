package com.nur.core;

import com.nur.AggregateRootTest;
import com.nur.ConcreteEntity;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.UUID;

@ExtendWith(MockitoExtension.class)
class EntityTest {

	@Spy
	ConcreteEntity entity;

	@Spy
	AggregateRootTest testAgregate = new AggregateRootTest();

	@BeforeEach
	void setUp() {
		entity = new ConcreteEntity();
	}

	@Test
	void addDomainEvents() {
	}

	@Test
	void setKey() {
		UUID KEYnew = UUID.randomUUID();
		entity.setKey(KEYnew);
		Assert.assertEquals(KEYnew.toString(), entity.getId().toString());
	}

	@Test
	void getKey() {
	}

	@Test
	void getDomainEvents() {
		LocalDateTime fecha = LocalDateTime.now();
		DomainEvent event = new DomainEvent(fecha) {
			@Override
			public LocalDateTime getOccurredOn() {
				return super.getOccurredOn();
			}

			@Override
			public UUID getId() {
				return super.getId();
			}
		} ;
		entity.addDomainEvents(event);
		Assert.assertFalse(entity.getDomainEvents().isEmpty());
		Assert.assertTrue(entity.getDomainEvents().contains(event));
	}

}