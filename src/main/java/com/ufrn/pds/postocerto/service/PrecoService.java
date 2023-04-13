package com.ufrn.pds.postocerto.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ufrn.pds.postocerto.model.Preco;
import com.ufrn.pds.postocerto.repository.PrecoRepository;

@Service
public class PrecoService {
  
  @Autowired
  private PrecoRepository precoRepository;
  
  PrecoService(PrecoRepository precoRepository) {
      this.precoRepository = precoRepository;
  }

	public List<Preco> findAll() {
		
		return precoRepository.findAll();
	}

	public Preco save(Preco novoPreco) {
		
		return precoRepository.save(novoPreco);
	}

	public Optional<Preco> findById(long id) {
		
		return precoRepository.findById(id);
	}

	public Preco update(Preco precoAlterado, long id) {
		Optional<Preco> Preco = precoRepository.findById(id);
		Preco.get().setValor(precoAlterado.getValor());
		Preco.get().setDataHora(precoAlterado.getDataHora());
		return precoAlterado;
	}
  
  
}
