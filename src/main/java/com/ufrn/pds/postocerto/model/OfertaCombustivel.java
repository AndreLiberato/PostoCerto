package com.ufrn.pds.postocerto.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class OfertaCombustivel {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private double preco;
    
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.DETACH}, optional = false)
    @JoinColumn(name = "posto_id")
    private Posto posto;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.DETACH}, optional = false)
    @JoinColumn(name = "combustivel_id")
    private Combustivel combustivel;

    public OfertaCombustivel() {
        
    }

    public OfertaCombustivel(Posto posto) {
        this.posto = posto;
    }

    public OfertaCombustivel(double preco, Posto posto, Combustivel combustivel) {
        this.preco = preco;
        this.posto = posto;
        this.combustivel = combustivel;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public void setPosto(Posto posto) {
        this.posto = posto;
    }

    public void setCombustivel(Combustivel combustivel) {
        this.combustivel = combustivel;
    }

    public Long getId() {
        return this.id;
    }
    
    public Posto getPosto() {
        return posto;
    }

    public double getPreco() {
        return this.preco;
    }

    public Combustivel getCombustivel() {
        return this.combustivel;
    }

    @Override
    public String toString() {
        String postoNome = this.posto.getNome();
        return postoNome;
    }

}

