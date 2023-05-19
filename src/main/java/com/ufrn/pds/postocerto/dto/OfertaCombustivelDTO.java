package com.ufrn.pds.postocerto.dto;

import com.ufrn.pds.postocerto.model.Combustivel;
import com.ufrn.pds.postocerto.model.Posto;
import jakarta.validation.constraints.NotNull;

public class OfertaCombustivelDTO {

    @NotNull(message = "O campo 'preço' não pode estar nulo.")
    private double preco;
    
    @NotNull(message = "o campo 'posto' não pode ser nulo.")
    private Posto posto;
    
    @NotNull(message = "o campo 'combustível' não pode ser nulo.")
    private Combustivel combustivel;

    public OfertaCombustivelDTO() {
        // Construtor vazio
    }

    public OfertaCombustivelDTO(Double preco, Posto posto, Combustivel combustivel) {
        this.preco = preco;
        this.posto = posto;
        this.combustivel = combustivel;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public Posto getPosto() {
        return posto;
    }

    public void setPosto(Posto posto) {
        this.posto = posto;
    }

    public Combustivel getCombustivel() {
        return combustivel;
    }

    public void setCombustivel(Combustivel combustivel) {
        this.combustivel = combustivel;
    }
}
