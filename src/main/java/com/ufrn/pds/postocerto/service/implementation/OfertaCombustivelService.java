package com.ufrn.pds.postocerto.service.implementation;

import com.ufrn.pds.postocerto.exception.EntityNotFoundException;
import com.ufrn.pds.postocerto.model.OfertaCombustivel;
import com.ufrn.pds.postocerto.repository.OfertaCombustivelRepository;
import com.ufrn.pds.postocerto.service.IOfertaCombustivelService;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OfertaCombustivelService implements IOfertaCombustivelService {

    @Autowired()
    private OfertaCombustivelRepository ofertaCombustivelRepository;

    @Override
    public List<OfertaCombustivel> getAll() {
        return ofertaCombustivelRepository.findAll();
    }

    @Override
    public Optional<OfertaCombustivel> find(Long id) {
        Optional<OfertaCombustivel> ofertaCombustivel = ofertaCombustivelRepository.findById(id);
        if (!ofertaCombustivel.isPresent()) {
            throw new EntityNotFoundException(id);
        }
        return ofertaCombustivel;
    }

    @Override
    public List<OfertaCombustivel> find(List<Long> ids) {
        return ofertaCombustivelRepository.findAllById(ids);
    }

    @Transactional
    public OfertaCombustivel save(OfertaCombustivel novoCombustivel) {
        return ofertaCombustivelRepository.save(novoCombustivel);
    }

    @Override
    public OfertaCombustivel update(OfertaCombustivel ofertaCombustivel, Long id) {
        Optional<OfertaCombustivel> existingOfertaCombustivel = ofertaCombustivelRepository.findById(id);
        if (existingOfertaCombustivel.isPresent()) {
            existingOfertaCombustivel.get().setCombustivel(ofertaCombustivel.getCombustivel());
            existingOfertaCombustivel.get().setPreco(ofertaCombustivel.getPreco());
        } else {
            throw new EntityNotFoundException(id);
        }
        return ofertaCombustivelRepository.save(existingOfertaCombustivel.get());
    }

    @Override
    public void delete(Long id) {
        Optional<OfertaCombustivel> existingOfertaCombustivel = ofertaCombustivelRepository.findById(id);
        if (existingOfertaCombustivel.isPresent()) {
            ofertaCombustivelRepository.delete(existingOfertaCombustivel.get());
        } else {
            throw new EntityNotFoundException(id);
        }
    }

    @Override
    public List<OfertaCombustivel> getByPostoId(Long postoId){
        return ofertaCombustivelRepository.findByPostoId(postoId);
    }

    @Override
    public String resolveViewPath(String viewName, Long postoId, boolean isRedirect) {
        if (isRedirect) {
            return "redirect:/posto/" + postoId + "/ofertacombustivel/" + viewName;
        }
        return "posto/ofertacombustivel/" + viewName;
    }

}
