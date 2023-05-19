package com.ufrn.pds.postocerto.dto;

import com.ufrn.pds.postocerto.model.Posto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class PostoDTO {

    @NotBlank(message = "O campo 'nome' não pode estar em branco.")
    private String nome;

    @NotNull(message = "O campo 'latitude' não pode estar nulo.")
    private double latitude;

    @NotNull(message = "O campo 'longitude' não pode estar nulo.")
    private double longitude;

    private double distancia;

    public PostoDTO() {
        // Construtor vazio
    }

    public PostoDTO(Long id, String nome, double latitude, double longitude, double distancia) {
        this.nome = nome;
        this.latitude = latitude;
        this.longitude = longitude;
        this.distancia = distancia;
    }

    public PostoDTO(Posto posto) {
        nome = posto.getNome();
        latitude = posto.getLatitude();
        longitude = posto.getLongitude();
        distancia = posto.getDistancia();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getDistancia() {
        return distancia;
    }

    public void setDistancia(double distancia) {
        this.distancia = distancia;
    }
}
