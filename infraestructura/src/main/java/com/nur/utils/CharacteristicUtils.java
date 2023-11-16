package com.nur.utils;

import com.nur.model.CharacteristicJpaModel;
import com.nur.core.BusinessRuleValidationException;
import com.nur.model.Characteristic;

import java.util.Collections;
import java.util.List;

public class CharacteristicUtils {


    public static CharacteristicJpaModel tipoToJpaEntity(Characteristic tipo) {
        if (tipo == null) return null;
        CharacteristicJpaModel characteristicJpaModel = new CharacteristicJpaModel();
        characteristicJpaModel.setId(tipo.getId());
        characteristicJpaModel.setName(tipo.getName());
        return characteristicJpaModel;
    }

    public static List<CharacteristicJpaModel> seatsToJpaEntities(List<Characteristic> tipo) {
        if (tipo == null) return Collections.emptyList();
        return tipo.stream().map(CharacteristicUtils::tipoToJpaEntity).toList();
    }

    public static Characteristic jpaModelToTipoPropiedad(CharacteristicJpaModel jpaModel)
            throws BusinessRuleValidationException {
        return new Characteristic(
                jpaModel.getId(),
                jpaModel.getName()
        );
    }
}
