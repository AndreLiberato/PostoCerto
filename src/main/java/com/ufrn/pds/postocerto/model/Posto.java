package com.ufrn.pds.postocerto.model;

import java.util.List;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Posto {

    @Id
    @GeneratedValue
    private Long id;
    @Column(nullable = false)
    private String nome;
    private double latitude;
    private double longitude;
    private double distancia;

    @OneToMany(mappedBy = "posto")
    private List<OfertaCombustivel> ofertaCombustivel;

    @OneToMany(mappedBy = "posto")
    private List<MudancaPreco> MudancaPreco;

    public Posto() {
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
    
    public Posto(String nome, double latitude, double longitude,List<PostoCombustivel> combustiveis, double distancia) {
        this.nome = nome;
        this.latitude = latitude;
        this.longitude = longitude;
        this.distancia = distancia;
        this.combustiveis = combustiveis;
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
