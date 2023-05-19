package com.ufrn.pds.postocerto.dto;

import org.springframework.format.annotation.DateTimeFormat;

import com.ufrn.pds.postocerto.model.Preco;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class PrecoDTO {
    private Long id;
    
    @NotNull(message = "O campo 'valor' não pode estar nulo.")
    private double valor;
    
    @NotBlank(message = "O campo 'data' não pode estar em branco.")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private String dataHora;

    public PrecoDTO() {
        // Construtor vazio
    }

    public PrecoDTO(Long id, double valor, String dataHora) {
        this.id = id;
        this.valor = valor;
        this.dataHora = dataHora;
    }
    
    public PrecoDTO(Preco preco) {
		id = preco.getId();
		valor = preco.getValor();
		dataHora = preco.getDataHora();	
	}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getDataHora() {
        return dataHora;
    }

    public void setDataHora(String dataHora) {
        this.dataHora = dataHora;
    }
}

