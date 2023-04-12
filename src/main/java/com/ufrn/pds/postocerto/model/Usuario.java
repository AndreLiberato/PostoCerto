package com.ufrn.pds.postocerto.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Usuario {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String password;
    private String latitude;
    private String longitude;

    Usuario() {
        // Empty
    }

    public Usuario(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public Usuario(String name, String password, String latitude, String longitude) {
        this.name = name;
        this.password = password;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setPassword(String password) { this.password = password; }
    public void setLatitude(String latitude) { this.latitude = latitude; }
    public void setLongitude(String longitude) { this.longitude = longitude; }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
    public String getLatitude() { return latitude;}
    public String getLongitude() { return longitude;}

}
