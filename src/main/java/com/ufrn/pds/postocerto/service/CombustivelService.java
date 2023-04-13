package com.ufrn.pds.postocerto.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ufrn.pds.postocerto.model.Combustivel;
import com.ufrn.pds.postocerto.repository.CombustivelRepository;


@Service
public class CombustivelService {
 
    @Autowired
	private CombustivelRepository combustivelRepository;
    
    CombustivelService(CombustivelRepository combustivelRepository) {
        this.combustivelRepository = combustivelRepository;
    }
    
    public Combustivel save(Combustivel novoCombustivel) {
        return combustivelRepository.save(novoCombustivel);
    }
    
    public List<Combustivel> findAll() {
        return combustivelRepository.findAll();
    }
    
    public Optional<Combustivel> findById(Long id) {
        return combustivelRepository.findById(id);
    }
    
    public Combustivel update(Combustivel CombustivelAlterado, Long id) {
        Optional<Combustivel> Combustivel = combustivelRepository.findById(id);
        Combustivel.get().setNome(CombustivelAlterado.getNome());

        return combustivelRepository.save(Combustivel.get());
    }
}
