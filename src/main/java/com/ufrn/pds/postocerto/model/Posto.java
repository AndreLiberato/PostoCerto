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
    private double  latitude;
    private double  longitude;
    private double distancia;

    Posto() {
        // Empty
    }

    public Posto(String nome) {
        this.nome = nome;
    }

    public Posto(String nome, double latitude, double longitude, double distancia) {
        this.nome = nome;
        this.latitude = latitude;
        this.longitude = longitude;
        this.distancia = distancia;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(double longitude) {
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

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public double getDistancia() {
      return distancia;
    }
}
