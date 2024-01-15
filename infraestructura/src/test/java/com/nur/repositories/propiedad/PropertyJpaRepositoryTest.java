package com.nur.repositories.propiedad;

import com.nur.core.BussinessRuleValidationException;
import com.nur.exceptions.InvalidDataException;
import com.nur.model.*;
import com.nur.utils.CharacteristicUtils;
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
class PropertyJpaRepositoryTest {
    @InjectMocks
    PropertyJpaRepository repository;

    @Spy
    PropertyCrudRepository crudRepository;


    @Test
    void update() throws BussinessRuleValidationException, ParseException {
        Property expect = PropertyFixture.whitDefault();
        UUID sampleId = UUID.randomUUID();

        Mockito.when(crudRepository.save(any(PropertyJpaModel.class))).thenAnswer(invocation -> {
            PropertyJpaModel savedModel = invocation.getArgument(0);
            savedModel.setId(sampleId); // Assign a UUID or an appropriate ID here
            return savedModel;
        });
        UUID respuesta = repository.update(expect);
        assertNotNull(respuesta);
        assertEquals(sampleId, respuesta);
    }

    @Test
    void getAll() throws BussinessRuleValidationException, ParseException {
        List<Property> expect = PropertyFixture.whitDefaultList();
        Mockito.when(crudRepository.findAll()).thenReturn(PropertyFixture.whitDefaultListJPA());

        List<Property> respuesta = repository.getAll();
        assertNotNull(respuesta);
        assertEquals(expect.toString(), respuesta.toString());
    }

    @Test
    void getById() throws BussinessRuleValidationException, ParseException {
        Property expect = PropertyFixture.whitDefault();
        UUID sampleId = UUID.randomUUID();
        Mockito.when(crudRepository.findById(sampleId)).thenReturn(Optional.of(PropertyFixture.whitDefaultJPA()));

        Property respuesta = repository.findPropertyById(sampleId);
        assertNotNull(respuesta);
        assertEquals(expect.toString(), respuesta.toString());
    }
    @Test
    void deleteById() throws BussinessRuleValidationException, ParseException {
        Property expect = PropertyFixture.whitDefault();

        Mockito.when(crudRepository.findById(expect.getId())).thenReturn(Optional.of(PropertyFixture.whitDefaultJPA()));

        UUID respuesta = repository.deletePropertyById(expect.getId());
        assertNotNull(respuesta);
        assertEquals(expect.getId(), respuesta);
    }

    @Test
    void deleteByIdNull() throws BussinessRuleValidationException, ParseException {
        Property expect = PropertyFixture.whitDefault();

        Mockito.when(crudRepository.findById(any())).thenReturn(Optional.empty());

        InvalidDataException exception = assertThrows(InvalidDataException.class,
                () -> repository.deletePropertyById(expect.getId()));
        assertEquals("jpaModel is null", exception.getMessage());
    }
}