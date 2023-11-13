package com.nur.model;

import lombok.*;
import jakarta.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
@Getter
@Setter
@Table(name = "passangers")
public class PersonaJpaModel {

  @Id
  @Column(nullable = false)
  private UUID id;

  @Column(nullable = false)
  private String name;

  @Column(nullable = false)
  private String lastname;

  @Column(nullable = false)
  private String ci;

}
