package com.ufrn.pds.postocerto.model;

import java.io.Serializable;
import java.util.List;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Posto implements Serializable {

    @Id
    @GeneratedValue
    private Long id;
    private String nome;
    private String latitude;
    private String longitude;
    private double distancia;

    @OneToMany(mappedBy = "posto")
    private List<PostoCombustivel> combustiveis; // = new ArrayList<>();


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



    public List<PostoCombustivel> getCombustiveis() {
        return combustiveis;
    }

    public void setCombustiveis(List<PostoCombustivel> combustiveis) {
        this.combustiveis = combustiveis;
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

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((nome == null) ? 0 : nome.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Posto other = (Posto) obj;
        if (nome == null) {
            if (other.nome != null)
                return false;
        } else if (!nome.equals(other.nome))
            return false;
        return true;
    }
    
}
