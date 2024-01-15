package com.nur.repositories.characteristicProperty;

import com.nur.core.BussinessRuleValidationException;
import com.nur.model.*;
import com.nur.repositories.characteristic.CharacteristicCrudRepository;
import com.nur.repositories.characteristic.CharacteristicJpaRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.text.ParseException;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
class CharacteristicPropertyJpaRepositoryTest {

    @InjectMocks
    CharacteristicPropertyJpaRepository repository;

    @Spy
    CharacteristicPropertyCrudRepository crudRepository;


    @Test
    void update() throws BussinessRuleValidationException, ParseException {
        CharacteristicProperty expect = CharacteristicPropertyFixture.whitDefault();
        UUID sampleId = UUID.randomUUID();

        Mockito.when(crudRepository.save(any(CharacteristicPropertyJpaModel.class))).thenAnswer(invocation -> {
            CharacteristicPropertyJpaModel savedModel = invocation.getArgument(0);
            savedModel.setId(sampleId); // Assign a UUID or an appropriate ID here
            return savedModel;
        });
        UUID respuesta = repository.update(expect);
        assertNotNull(respuesta);
        assertEquals(sampleId, respuesta);
    }

    @Test
    void getAll() throws BussinessRuleValidationException, ParseException {
        List<CharacteristicProperty> expect = CharacteristicPropertyFixture.whitDefaultList();
        Mockito.when(crudRepository.findAll()).thenReturn(CharacteristicPropertyFixture.whitDefaultListJPA());

        List<CharacteristicProperty> respuesta = repository.getAllByProperty();
        assertNotNull(respuesta);
        assertEquals(expect.toString(), respuesta.toString());
    }
}