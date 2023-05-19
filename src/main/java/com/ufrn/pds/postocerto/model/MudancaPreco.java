package com.ufrn.pds.postocerto.model;

import jakarta.persistence.Column;
import java.time.LocalDateTime;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class MudancaPreco {

  @Id
  @GeneratedValue
  private Long id;

  @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.DETACH}, optional = false)
  @JoinColumn(name = "combustivel_id")
  private Combustivel combustivel;

  @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.DETACH}, optional = false)
  @JoinColumn(name = "posto_id")
  private Posto posto;

  @Column(nullable = false)
  private double valor;

  @Column(nullable = false)
  private LocalDateTime dataHora;

  public MudancaPreco() {

  }

  public MudancaPreco(double valor, LocalDateTime dataHora, Combustivel combustivel) {
    this.valor = valor;
    this.dataHora = dataHora;
    this.combustivel = combustivel;
  }

  public void setCombustivel(Combustivel combustivel) {
    this.combustivel = combustivel;
  }

  public void setValor(double valor) {
    this.valor = valor;
  }

  public void setDataHora(LocalDateTime dataHora) {
    this.dataHora = dataHora;
  }

  public Long getId() {
    return this.id;
  }

  public Combustivel getCombustivel() {
    return this.combustivel;
  }

  public double getValor() {
    return this.valor;
  }

  public LocalDateTime getDataHora() {
    return this.dataHora;
  }
}
