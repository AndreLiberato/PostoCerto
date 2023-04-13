package com.ufrn.pds.postocerto.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Combustivel {

    @Id
    @GeneratedValue
    private Long id;
    private String nome;

    Combustivel() {
        // Empty
    }
    public Combustivel(String nome) {
        this.nome = nome;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public Long getId() {
        return id;
    }
    public String getNome() {
        return nome;
    }
}
