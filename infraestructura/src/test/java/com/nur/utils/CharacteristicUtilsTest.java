package com.nur.utils;

import com.nur.core.BussinessRuleValidationException;
import com.nur.exceptions.InvalidDataException;
import com.nur.model.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.text.ParseException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class CharacteristicUtilsTest {

	@Mock
	CharacteristicUtils utils;

	@BeforeEach
	void setUp() {
		utils = new CharacteristicUtils();
	}

	@Test
	void JpaModelListVoid() throws BussinessRuleValidationException, ParseException {
		List<CharacteristicJpaModel> expect = CharacteristicUtils.seatsToJpaEntities(null);
		assertNotNull(expect);
	}

	@Test
	void JpaModelList() throws BussinessRuleValidationException, ParseException {
		List<CharacteristicJpaModel> listJpa = CharacteristicFixture.whitDefaultListJPA();
		List<Characteristic> list = CharacteristicFixture.whitDefaultList();
		List<CharacteristicJpaModel> expect = CharacteristicUtils.seatsToJpaEntities(list);
		assertEquals(expect.toString(), listJpa.toString());
	}

	@Test
	void jpaToCheckInNull() throws BussinessRuleValidationException {
		InvalidDataException exception = assertThrows(InvalidDataException.class,
				() -> CharacteristicUtils.jpaModelToTipoPropiedad(null));
		assertEquals("jpaModel is null", exception.getMessage());
	}

	@Test
	void jpaTModel() throws BussinessRuleValidationException, ParseException {
		Characteristic expect = CharacteristicFixture.whitDefault();
		Characteristic response = CharacteristicUtils.jpaModelToTipoPropiedad(CharacteristicFixture.whitDefaultJPA());
		assertEquals(expect.toString(), response.toString());
	}

	@Test
	void jpaToEntity() throws BussinessRuleValidationException {
		InvalidDataException exception = assertThrows(InvalidDataException.class,
				() -> CharacteristicUtils.tipoToJpaEntity(null));
		assertEquals("entity is null", exception.getMessage());
	}

}