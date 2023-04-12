package com.ufrn.pds.postocerto.model;

import java.time.LocalDateTime;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Preco {

    @Id
    @GeneratedValue
    private Long id;
    private double valor;
    private LocalDateTime dataHora;

    public void setValor(double valor) {
      this.valor = valor;
    }

    public void setDataHora(LocalDateTime dataHora) {
      this.dataHora = dataHora;
    }

    public double getValor() {
      return valor;
    }

    public LocalDateTime getDataHora() {
      return dataHora;
    }
}
