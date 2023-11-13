package com.nur.model;

import lombok.*;
import jakarta.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
@Getter
@Setter
@Table(name = "check_in")
public class CheckInJpaModel {

  @Id
  @Column(nullable = false)
  private UUID id;

  @Column(name="prop_id",nullable = false)
  private UUID propiedadId;

  @Column(nullable = false)
  private Date date;

  @OneToOne(optional = true)
  private PropiedadJpaModel propiedad;

  public PropiedadJpaModel getPropiedad() {
    return propiedad;
  }

  public void setPropiedad(PropiedadJpaModel propiedad) {
    this.propiedad = propiedad;
  }

  @OneToOne
  private PersonaJpaModel persona;

}
