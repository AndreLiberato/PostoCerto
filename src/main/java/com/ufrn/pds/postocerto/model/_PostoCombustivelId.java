package com.ufrn.pds.postocerto.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class _PostoCombustivelId implements Serializable{

 
    @Column(name = "postoId")
    private Long postoId;
    @Column(name = "combustivelId")
    private Long combustivelId;
    
    public _PostoCombustivelId() {
    }
    public _PostoCombustivelId(Long postoId, Long combustivelId) {
        this.postoId = postoId;
        this.combustivelId = combustivelId;
    }
    public Long getPostoId() {
        return postoId;
    }
    public void setPostoId(Long postoId) {
        this.postoId = postoId;
    }
    public Long getCombustivelId() {
        return combustivelId;
    }
    public void setCombustivelId(Long combustivelId) {
        this.combustivelId = combustivelId;
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((postoId == null) ? 0 : postoId.hashCode());
        result = prime * result + ((combustivelId == null) ? 0 : combustivelId.hashCode());
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        
        _PostoCombustivelId other = (_PostoCombustivelId) obj;

        if (postoId == null) {
            if (other.postoId != null)
                return false;
        } else if (!postoId.equals(other.postoId))
            return false;
        if (combustivelId == null) {
            if (other.combustivelId != null)
                return false;
        } else if (!combustivelId.equals(other.combustivelId))
            return false;
        return true;
    }
    
}

