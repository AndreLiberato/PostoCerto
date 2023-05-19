package com.ufrn.pds.postocerto.dto;

import com.ufrn.pds.postocerto.model.Preco;

public class PrecoDTO {
    private Long id;
    private double valor;
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

