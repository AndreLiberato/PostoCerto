package com.ufrn.pds.postocerto.model;


import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class PostoCombustivel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    private Double preco;
    
    @ManyToOne()
    @JoinColumn(name = "posto_id")
    private Posto posto;

    @ManyToOne()
    @JoinColumn(name = "combustivel_id")
    private Combustivel combustivel;

    public Combustivel getCombustivel() {
        return combustivel;
    }

    public void setCombustivel(Combustivel combustivel) {
        this.combustivel = combustivel;
    }

    public PostoCombustivel() {
    }

    public PostoCombustivel(Long combustivelid, double preco, Posto posto) {
        this.preco = preco;
        this.posto = posto;
    }

    public Long getId() {
        return id;
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


}

