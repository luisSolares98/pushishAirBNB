package com.nur.core;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.util.ReflectionTestUtils;

import java.time.LocalDateTime;
import java.util.UUID;

@ExtendWith(MockitoExtension.class)
class DomainEventTest {

	@Mock
    DomainEvent event;

	LocalDateTime fecha;

	@BeforeEach
	void setUp() {
		fecha = LocalDateTime.now();
		event = new DomainEvent(fecha) {
			@Override
			public UUID getId() {
				return super.getId();
			}

			@Override
			public LocalDateTime getOccurredOn() {
				return super.getOccurredOn();
			}
		};
		ReflectionTestUtils.setField(event, "id", UUID.fromString("effa368e-2f33-49c7-94e4-a4dfb3be2c27"));

	}

	@Test
	void getKey() {
		Assert.assertEquals(event.getId().toString(), "effa368e-2f33-49c7-94e4-a4dfb3be2c27");
	}

	@Test
	void getOcurredOn() {
		Assert.assertEquals(event.getOccurredOn().toString(), fecha.toString());
	}

}