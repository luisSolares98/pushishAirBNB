package com.nur.model;

import lombok.*;
import jakarta.persistence.*;
import java.util.UUID;

@Entity
@Getter
@Setter
@Table(name = "metodopago")
public class MetodoPagoJpaModel {

  @Id
  @Column(nullable = false)
  private UUID id;

  @Column(nullable = false)
  private String detalle;

  @Column(nullable = false)
  private String tipo;

}
