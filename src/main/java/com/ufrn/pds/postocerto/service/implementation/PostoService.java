package com.ufrn.pds.postocerto.service.implementation;

import com.ufrn.pds.postocerto.exception.EntityNotFoundException;
import com.ufrn.pds.postocerto.model.Posto;
import com.ufrn.pds.postocerto.repository.PostoRepository;
import com.ufrn.pds.postocerto.service.IPostoService;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostoService implements IPostoService {

    @Autowired
    private PostoRepository postoRepository;

    public List<Posto> getAll() {
        return postoRepository.findAll();
    }

    @Transactional
    public Posto save(Posto novoPosto) {
        return postoRepository.save(novoPosto);
    }

    public Optional<Posto> find(Long id) {
        return postoRepository.findById(id);
    }

    public List<Posto> find(List<Long> id) {
        return postoRepository.findAllById(id);
    }

    @Transactional
    public void delete(Long id) {
        Optional<Posto> posto = postoRepository.findById(id);
        if (posto.isPresent()) {
            postoRepository.delete(posto.get());
        } else {
            throw new EntityNotFoundException(id);
        }
    }

    @Transactional
    public Posto update(Posto newPosto, Long id) {
        Optional<Posto> existingPosto = postoRepository.findById(id);
        if (existingPosto.isPresent()) {
            existingPosto.get().setNome(newPosto.getNome());
            existingPosto.get().setLatitude(newPosto.getLatitude());
            existingPosto.get().setLongitude(newPosto.getLongitude());
            existingPosto.get().setDistancia(newPosto.getDistancia());
        } else {
            throw new EntityNotFoundException(id);
        }
        return postoRepository.save(existingPosto.get());
    }

	
}
