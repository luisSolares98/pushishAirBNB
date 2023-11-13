package com.nur.dtos;

public class TransactionDto {

  public String code;
  public String descripcion;
  public double monto;

  public TransactionDto() {}

  public TransactionDto(String code, String descripcion, double monto) {
    this.code = code;
    this.descripcion = descripcion;
    this.monto = monto;
  }
}
