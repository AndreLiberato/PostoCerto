package com.ufrn.pds.postocerto.model;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Combustivel implements Serializable{

    @Id
    @GeneratedValue
    private Long id;
    private String nome;

	@OneToMany(mappedBy = "combustivel")
    private List<PostoCombustivel> postos;// = new HashSet<Combustivel>();

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

    public List<PostoCombustivel> getPostos() {
        return postos;
    }

    public void setPostos(List<PostoCombustivel> postos) {
        this.postos = postos;
    }

}
