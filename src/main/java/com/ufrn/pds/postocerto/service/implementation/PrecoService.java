package com.ufrn.pds.postocerto.service.implementation;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ufrn.pds.postocerto.exception.EntityNotFoundException;
import com.ufrn.pds.postocerto.model.Preco;
import com.ufrn.pds.postocerto.repository.PrecoRepository;
import com.ufrn.pds.postocerto.service.IPrecoService;

@Service
public class PrecoService implements IPrecoService {

	@Autowired
	private PrecoRepository precoRepository;

	public List<Preco> getAll() {
		return precoRepository.findAll();
	}

	public Optional<Preco> find(Long id) {
		return precoRepository.findById(id);
	}

	public List<Preco> find(List<Long> id) {
		return precoRepository.findAllById(id);
	}

	public Preco save(Preco novo) {
		return precoRepository.save(novo);
	}

	public Preco update(Preco novo, Long id) {
		Optional<Preco> existingPreco = precoRepository.findById(id);
		if(existingPreco.isPresent()) {
			existingPreco.get().setDataHora(novo.getDataHora());
			existingPreco.get().setValor(novo.getValor());
		} else {
			throw new EntityNotFoundException(id);
		}
		return precoRepository.save(existingPreco.get());
	}

	public void delete(Long id) {
		Optional<Preco> preco = precoRepository.findById(id);
		if(preco.isPresent()) {
			precoRepository.delete(preco.get());
		} else {
			throw new EntityNotFoundException(id);
		}
	}
}
