package com.nur.event;

import com.nur.core.DomainEvent;
import com.nur.model.Propiedad;

import java.util.Date;

public class PropiedadEliminado extends DomainEvent {
    public Propiedad propiedadEliminada;

    public PropiedadEliminado(Propiedad propiedadEliminada, Date occuredOn) {
        super(occuredOn);
        this.propiedadEliminada = propiedadEliminada;
    }
}
