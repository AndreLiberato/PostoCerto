package com.ufrn.pds.postocerto.dto;

import java.util.List;

import com.ufrn.pds.postocerto.model.Combustivel;
import com.ufrn.pds.postocerto.model.PostoCombustivel;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class CombustivelDTO {
    private Long id;
    @NotBlank(message = "O campo 'nome' não pode estar em branco.")
    private String nome;
    
    @NotNull(message = "A lista de postos não pode ser nula.")
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
