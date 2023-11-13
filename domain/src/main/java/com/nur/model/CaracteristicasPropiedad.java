package com.nur.model;


import com.nur.core.Entity;

import java.util.UUID;

public class CaracteristicasPropiedad extends Entity {

    private  UUID Id;
    private boolean cocina;
    private boolean wifi;
    private boolean estacionamiento;
    private boolean camaraSeguridad;
    private boolean detectorHumo;
    private boolean secadoraPelo;
    private boolean shampoo;
    private boolean aguaCaliente;

    public CaracteristicasPropiedad(UUID id, boolean cocina, boolean wifi, boolean estacionamiento, boolean camaraSeguridad, boolean detectorHumo, boolean secadoraPelo, boolean shampoo, boolean aguaCaliente) {
        Id = id;
        this.cocina = cocina;
        this.wifi = wifi;
        this.estacionamiento = estacionamiento;
        this.camaraSeguridad = camaraSeguridad;
        this.detectorHumo = detectorHumo;
        this.secadoraPelo = secadoraPelo;
        this.shampoo = shampoo;
        this.aguaCaliente = aguaCaliente;
    }

    @Override
    public UUID getId() {
        return Id;
    }
}
