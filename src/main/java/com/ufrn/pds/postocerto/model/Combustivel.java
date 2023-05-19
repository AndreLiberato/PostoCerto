package com.ufrn.pds.postocerto.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Combustivel {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false, unique = true, length = 32)
    private String nome;

	@OneToMany(mappedBy = "combustivel")
    private List<OfertaCombustivel> ofertaCombustivel;

    @OneToMany(mappedBy = "combustivel")
    private List<MudancaPreco> mudancaPreco;

    public Combustivel() {
        // Empty
    }
    
    public Combustivel(String nome) {
        this.nome = nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getId() {
        return this.id;
    }

    public String getNome() {
        return this.nome;
    }

}
