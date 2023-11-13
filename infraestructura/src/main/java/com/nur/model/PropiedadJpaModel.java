package com.nur.model;

import lombok.*;
import jakarta.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
@Getter
@Setter
@Table(name = "propiedades")
public class PropiedadJpaModel {

    @Id
    @Column(name="id",nullable = false)
    public UUID id;

    @Column(nullable = false)
    public String nombre;

    @Column(name="estado",nullable = false)
    public String estado;

    @Column(nullable = false)
    public double precio;

}
