package com.nur.model;

import lombok.*;
import jakarta.persistence.*;
import java.util.UUID;

@Entity
@Getter
@Setter
@Table(name = "transacciones")
public class TransactionJpaModel {

  @Id
  @Column(nullable = false)
  private UUID code;

  @Column(nullable = false)
  private String descripcion;

  @Column(nullable = false)
  private double monto;

}
