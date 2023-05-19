package com.ufrn.pds.postocerto.exception;

public class EntityNotFoundException extends RuntimeException{

    public EntityNotFoundException(Long id) {
        super("Requisição ao recursos de id: " + id + " falhou.");
    }
}
