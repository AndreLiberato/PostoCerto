package com.ufrn.pds.postocerto.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Combustivel {

    @Id
    @GeneratedValue
    private Long id;
    private String name;

    Combustivel() {
        // Empty
    }
    public Combustivel(String name) {
        this.name = name;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Long getId() {
        return id;
    }
    public String getName() {
        return name;
    }
}
