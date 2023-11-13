package com.nur.model;



import com.nur.core.Entity;

import java.util.UUID;

public class TipoPropiedad extends Entity {
    private UUID Id;
    private String nombreTipo;

    public TipoPropiedad() {
    }

    public TipoPropiedad(UUID id, String nombreTipo) {
        Id = id;
        this.nombreTipo = nombreTipo;
    }

    @Override
    public UUID getId() {
        return Id;
    }

    public String getNombreTipo() {
        return nombreTipo;
    }
}
