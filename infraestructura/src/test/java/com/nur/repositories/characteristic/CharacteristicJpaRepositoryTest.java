package com.nur.repositories.characteristic;

import com.nur.core.BussinessRuleValidationException;
import com.nur.model.Characteristic;
import com.nur.model.CharacteristicFixture;
import com.nur.model.CharacteristicJpaModel;
import com.nur.utils.CharacteristicUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.text.ParseException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
class CharacteristicJpaRepositoryTest {

	@InjectMocks
	CharacteristicJpaRepository repository;

	@Spy
	CharacteristicCrudRepository crudRepository;

	@Test
	void update() throws BussinessRuleValidationException, ParseException {
		Characteristic expect = CharacteristicFixture.whitDefault();
		UUID sampleId = UUID.randomUUID();

		Mockito.when(crudRepository.save(any(CharacteristicJpaModel.class))).thenAnswer(invocation -> {
			CharacteristicJpaModel savedModel = invocation.getArgument(0);
			savedModel.setId(sampleId); // Assign a UUID or an appropriate ID here
			return savedModel;
		});
		UUID respuesta = repository.update(expect);
		assertNotNull(respuesta);
		assertEquals(sampleId, respuesta);
	}

	@Test
	void getAll() throws BussinessRuleValidationException, ParseException {
		List<Characteristic> expect = CharacteristicFixture.whitDefaultList();
		Mockito.when(crudRepository.findAll()).thenReturn(CharacteristicFixture.whitDefaultListJPA());

		List<Characteristic> respuesta = repository.getAll();
		assertNotNull(respuesta);
		assertEquals(expect.toString(), respuesta.toString());
	}

}