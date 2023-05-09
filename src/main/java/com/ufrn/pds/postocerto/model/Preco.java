package com.ufrn.pds.postocerto.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Preco {

  @Id
  @GeneratedValue
  private Long id;
  private double valor;
  private String dataHora;

  public Preco() {

  }

  public Preco(double valor, String dataHora) {
    this.valor = valor;
    this.dataHora = dataHora;
  }

  public Long getId() {
    return id;
  }

  public void setValor(double valor) {
    this.valor = valor;
  }

  public void setDataHora(String string) {
	  
    this.dataHora = string.toString();
  }

  public double getValor() {
    return valor;
  }

  public String getDataHora() {
    return dataHora;
  }
}
