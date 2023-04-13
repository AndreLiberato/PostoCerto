package com.ufrn.pds.postocerto.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Posto {

    @Id
    @GeneratedValue
    private Long id;
    private String nome;
    private String latitude;
    private String longitude;
    private double distancia;

    Posto() {
        // Empty
    }

    public Posto(String nome) {
        this.nome = nome;
    }

    public Posto(String nome, String latitude, String longitude, double distancia) {
        this.nome = nome;
        this.latitude = latitude;
        this.longitude = longitude;
        this.distancia = distancia;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public void setDistancia(double distancia) {
      this.distancia = distancia;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getLatitude() {
        return latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public double getDistancia() {
      return distancia;
    }
}
