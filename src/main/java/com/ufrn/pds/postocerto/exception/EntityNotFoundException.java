package com.ufrn.pds.postocerto.exception;

public class EntityNotFoundException extends RuntimeException{

    public EntityNotFoundException(Long id) {
        super("Não foi possível encontrar nenhuma entidade com o identificador " + id + ".");
    }
}
