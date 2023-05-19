package com.ufrn.pds.postocerto.dto;

import java.util.List;

import com.ufrn.pds.postocerto.model.Combustivel;
import com.ufrn.pds.postocerto.model.PostoCombustivel;

public class CombustivelDTO {
    private Long id;
    private String nome;
    private List<PostoCombustivel> postos;

    public CombustivelDTO() {
        // Construtor vazio
    }

    public CombustivelDTO(Long id, String nome, List<PostoCombustivel> postos) {
        this.id = id;
        this.nome = nome;
        this.postos = postos;
    }
    public CombustivelDTO(Combustivel combustivel) {
		id = combustivel.getId();
		nome = combustivel.getNome();
		postos = combustivel.getPostos();
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

    public List<PostoCombustivel> getPostos() {
        return postos;
    }

    public void setPostos(List<PostoCombustivel> postos) {
        this.postos = postos;
    }
}
