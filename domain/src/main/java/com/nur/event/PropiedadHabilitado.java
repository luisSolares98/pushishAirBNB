package com.nur.event;

import com.nur.core.DomainEvent;
import com.nur.model.Propiedad;

import java.util.Date;


public class PropiedadHabilitado extends DomainEvent {

    public Propiedad propiedadHabilitada;

    public PropiedadHabilitado(Propiedad propiedadHabilitada, Date occuredOn) {
        super(occuredOn);
        this.propiedadHabilitada = propiedadHabilitada;
    }
}
