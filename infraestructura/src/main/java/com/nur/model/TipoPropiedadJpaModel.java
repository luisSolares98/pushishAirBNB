package com.nur.model;

import lombok.*;
import jakarta.persistence.*;
import java.util.UUID;

@Entity
@Getter
@Setter
@Table(name = "tipopropiedad")
public class TipoPropiedadJpaModel {

    @Id
    @Column(nullable = false)
    public UUID id;

    @Column(nullable = false)
    public String nombreTipo;

}
