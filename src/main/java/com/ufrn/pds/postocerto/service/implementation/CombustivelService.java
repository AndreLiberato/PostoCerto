package com.ufrn.pds.postocerto.service.implementation;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ufrn.pds.postocerto.model.Combustivel;
import com.ufrn.pds.postocerto.repository.CombustivelRepository;
import com.ufrn.pds.postocerto.service.ICombustivelService;

@Service
public class CombustivelService implements ICombustivelService {
 
    @Autowired
	private CombustivelRepository combustivelRepository;

    public List<Combustivel> getAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAll'");
    }

    public Optional<Combustivel> find(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'find'");
    }

    public List<Combustivel> find(List<Long> id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'find'");
    }

    public Combustivel save(Combustivel novo) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }

    public Combustivel update(Combustivel novo, Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    public void delete(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }
}
