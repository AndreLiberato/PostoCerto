package com.ufrn.pds.postocerto.dto;

import com.ufrn.pds.postocerto.model.Combustivel;
import jakarta.validation.constraints.NotBlank;

public class CombustivelDTO {

    @NotBlank(message = "O campo 'nome' não pode estar em branco.")
    private String nome;

    public CombustivelDTO() {
        // Construtor vazio
    }

    public CombustivelDTO(String nome) {
        this.nome = nome;
    }

    public CombustivelDTO(Combustivel combustivel) {
        this.nome = combustivel.getNome();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
