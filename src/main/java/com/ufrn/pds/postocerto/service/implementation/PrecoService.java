package com.ufrn.pds.postocerto.service.implementation;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ufrn.pds.postocerto.model.Preco;
import com.ufrn.pds.postocerto.repository.PrecoRepository;
import com.ufrn.pds.postocerto.service.IPrecoService;

@Service
public class PrecoService implements IPrecoService {

	@Autowired
	private PrecoRepository precoRepository;

	public List<Preco> getAll() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'getAll'");
	}

	public Optional<Preco> find(Long id) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'find'");
	}

	public List<Preco> find(List<Long> id) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'find'");
	}

	public Preco save(Preco novo) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'save'");
	}

	public Preco update(Preco novo, Long id) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'update'");
	}

	public void delete(Long id) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'delete'");
	}
}
