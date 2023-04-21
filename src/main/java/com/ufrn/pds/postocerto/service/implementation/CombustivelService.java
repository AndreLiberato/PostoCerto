package com.ufrn.pds.postocerto.service.implementation;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ufrn.pds.postocerto.exception.EntityNotFoundException;
import com.ufrn.pds.postocerto.model.Combustivel;
import com.ufrn.pds.postocerto.repository.CombustivelRepository;
import com.ufrn.pds.postocerto.service.ICombustivelService;

@Service
public class CombustivelService implements ICombustivelService {
	
	 
    @Autowired
	private CombustivelRepository combustivelRepository;

    public List<Combustivel> getAll() {
        return combustivelRepository.findAll();
    }

    public Optional<Combustivel> find(Long id) {
        return combustivelRepository.findById(id);
    }

    public List<Combustivel> find(List<Long> id) {
       return combustivelRepository.findAllById(id);
    }

    public Combustivel save(Combustivel novo) {
        return combustivelRepository.save(novo);
    }

    public Combustivel update(Combustivel novo, Long id) {
    	Optional<Combustivel> existingCombustivel = combustivelRepository.findById(id);
    	if(existingCombustivel.isPresent()) {
    		existingCombustivel.get().setNome(novo.getNome());
    	
    	} else {
    		throw new EntityNotFoundException(id);
    	}
		return combustivelRepository.save(existingCombustivel.get());
    }

    public void delete(Long id) {
    	Optional<Combustivel> combustivel = combustivelRepository.findById(id);
    	if(combustivel.isPresent()) {
    		combustivelRepository.delete(combustivel.get());
    	} else {
    		 throw new EntityNotFoundException(id);
    	}
    }
}
