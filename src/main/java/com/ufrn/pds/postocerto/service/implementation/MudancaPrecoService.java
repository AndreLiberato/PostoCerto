package com.ufrn.pds.postocerto.service.implementation;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ufrn.pds.postocerto.exception.EntityNotFoundException;
import com.ufrn.pds.postocerto.model.MudancaPreco;
import com.ufrn.pds.postocerto.repository.MudancaPrecoRepository;
import com.ufrn.pds.postocerto.service.IMudancaPrecoService;

@Service
public class MudancaPrecoService implements IMudancaPrecoService {

	@Autowired
	private MudancaPrecoRepository precoRepository;

	public List<MudancaPreco> getAll() {
		return precoRepository.findAll();
	}

	public Optional<MudancaPreco> find(Long id) {
		return precoRepository.findById(id);
	}

	public List<MudancaPreco> find(List<Long> id) {
		return precoRepository.findAllById(id);
	}

	public MudancaPreco save(MudancaPreco novo) {
		return precoRepository.save(novo);
	}

	public MudancaPreco update(MudancaPreco novo, Long id) {
		Optional<MudancaPreco> existingPreco = precoRepository.findById(id);
		if(existingPreco.isPresent()) {
			existingPreco.get().setDataHora(novo.getDataHora());
			existingPreco.get().setValor(novo.getValor());
		} else {
			throw new EntityNotFoundException(id);
		}
		return precoRepository.save(existingPreco.get());
	}

	public void delete(Long id) {
		Optional<MudancaPreco> preco = precoRepository.findById(id);
		if(preco.isPresent()) {
			precoRepository.delete(preco.get());
		} else {
			throw new EntityNotFoundException(id);
		}
	}
}
