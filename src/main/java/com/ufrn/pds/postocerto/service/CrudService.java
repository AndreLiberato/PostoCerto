package com.ufrn.pds.postocerto.service;

import java.util.List;
import java.util.Optional;

public interface CrudService<T, ID> {

    public List<T> getAll();

    public Optional<T> find(ID id);

    public List<T> find(List<ID> id);

    public T save(T novo);

    public T update(T novo, ID id);

    public void delete(ID id);   
}
