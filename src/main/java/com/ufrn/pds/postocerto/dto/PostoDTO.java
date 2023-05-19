package com.ufrn.pds.postocerto.dto;

import java.util.List;
import com.ufrn.pds.postocerto.model.Posto;
import com.ufrn.pds.postocerto.model.PostoCombustivel;

public class PostoDTO {
    private Long id;
    private String nome;
    private double latitude;
    private double longitude;
    private double distancia;
    private List<PostoCombustivel> combustiveis;

    public PostoDTO() {
        // Construtor vazio
    }

    public PostoDTO(Long id, String nome, double latitude, double longitude, double distancia, List<PostoCombustivel> combustiveis) {
        this.id = id;
        this.nome = nome;
        this.latitude = latitude;
        this.longitude = longitude;
        this.distancia = distancia;
        this.combustiveis = combustiveis;
    }
    
    public PostoDTO(Posto posto) {
		id = posto.getId();
		nome = posto.getNome();
		latitude = posto.getLatitude();
		longitude = posto.getLongitude();
		distancia = posto.getDistancia();
		combustiveis = posto.getCombustiveis();
	}

    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public List<PostoCombustivel> getCombustiveis() {
        return combustiveis;
    }

    public void setCombustiveis(List<PostoCombustivel> combustiveis) {
        this.combustiveis = combustiveis;
    }
}
