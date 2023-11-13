package com.nur.repositories.tipoPropiedad;

import com.nur.model.TipoPropiedadJpaModel;
import com.nur.utils.TipoPropiedadUtils;
import com.nur.core.BusinessRuleValidationException;
import com.nur.model.TipoPropiedad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Repository;
import com.nur.repositories.TipoPropiedadRepository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
@Primary
@Repository
public class TipoPropiedadJpaRepository implements TipoPropiedadRepository {

  @Autowired
  private TipoPropiedadCrudRepository tipoPropiedadCrudRepository;



    @Override
    public UUID update(TipoPropiedad tipo) {
        TipoPropiedadJpaModel seatJpaModel = TipoPropiedadUtils.tipoToJpaEntity(tipo);
        return tipoPropiedadCrudRepository.save(seatJpaModel).getId();
    }


    @Override
    public List<TipoPropiedad> findTipoPropiedadById(UUID id) throws BusinessRuleValidationException {

        List<TipoPropiedadJpaModel> jpaModels = tipoPropiedadCrudRepository.findTipoPropiedadById(
                id
        );
        if (
                jpaModels == null || jpaModels.size() == 0
        ) return Collections.emptyList();
        List<TipoPropiedad> tipoPropiedads = new ArrayList<>();
        for (TipoPropiedadJpaModel jpaModel : jpaModels) {
            tipoPropiedads.add(TipoPropiedadUtils.jpaModelToTipoPropiedad(jpaModel));
        }
        return tipoPropiedads;
    }

    @Override
    public List<TipoPropiedad> getAll() throws BusinessRuleValidationException {
        List<TipoPropiedadJpaModel> jpaModels = Streamable
                .of(tipoPropiedadCrudRepository.findAll())
                .toList();
        List<TipoPropiedad> tipos = new ArrayList<>();
        for (TipoPropiedadJpaModel jpaModel : jpaModels) {
            tipos.add(TipoPropiedadUtils.jpaModelToTipoPropiedad(jpaModel));
        }
        return tipos;
    }

    public void setTipoPropiedadCrudRepository(TipoPropiedadCrudRepository tipoPropiedadCrudRepository) {
        this.tipoPropiedadCrudRepository = tipoPropiedadCrudRepository;
    }
}
