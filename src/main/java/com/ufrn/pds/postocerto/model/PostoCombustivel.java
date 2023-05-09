package com.ufrn.pds.postocerto.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class PostoCombustivel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    //private PostoCombustivelId id;
    private Long combustivelid;
    private Double preco;
    
    @ManyToOne()
    @JoinColumn(name = "posto_id")
    private Posto posto;

    @ManyToOne()
    @JoinColumn(name = "combustivel_id")
    private Combustivel combustivel;

    
    public PostoCombustivel(Long combustivelid, double preco, Posto posto) {
        this.combustivelid = combustivelid;
        this.preco = preco;
        this.posto = posto;
    }

    public Long getCombustivelid() {
        return combustivelid;
    }

    public void setCombustivelid(Long combustivelid) {
        this.combustivelid = combustivelid;
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

