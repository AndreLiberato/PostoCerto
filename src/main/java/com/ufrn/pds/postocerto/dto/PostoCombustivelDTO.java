package com.ufrn.pds.postocerto.dto;

import jakarta.validation.constraints.NotNull;

public class PostoCombustivelDTO {
    private Long id;
    
    @NotNull(message = "O campo 'preco' não pode estar nulo.")
    private Double preco;
    
    @NotNull(message = "o campo 'posto' não pode ser nulo.")
    private PostoDTO posto;
    
    @NotNull(message = "o campo 'combustivel' não pode ser nulo.")
    private CombustivelDTO combustivel;

    public PostoCombustivelDTO() {
        // Construtor vazio
    }

    public PostoCombustivelDTO(Long id, Double preco, PostoDTO posto, CombustivelDTO combustivel) {
        this.id = id;
        this.preco = preco;
        this.posto = posto;
        this.combustivel = combustivel;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public PostoDTO getPosto() {
        return posto;
    }

    public void setPosto(PostoDTO posto) {
        this.posto = posto;
    }

    public CombustivelDTO getCombustivel() {
        return combustivel;
    }

    public void setCombustivel(CombustivelDTO combustivel) {
        this.combustivel = combustivel;
    }
}
