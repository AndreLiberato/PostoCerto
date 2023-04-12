package com.ufrn.pds.postocerto.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Posto {
  
  private @Id @GeneratedValue Long id;
  private String name;

  Posto() {
    // Empty
  }

  public Posto(String name) {
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
