package com.ufrn.pds.postocerto.service.implementation;

import com.ufrn.pds.postocerto.model.PostoCombustivel;
import com.ufrn.pds.postocerto.repository.PostoCombustivelRepository;
import com.ufrn.pds.postocerto.service.IPostoCombustivelService;

import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostoCombustivelService implements IPostoCombustivelService {

    @Autowired()
    private PostoCombustivelRepository postoCombustivelRepository;

    @Override
    public List<PostoCombustivel> getAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAll'");
    }

    @Override
    public Optional<PostoCombustivel> find(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'find'");
    }

    @Override
    public List<PostoCombustivel> find(List<Long> ids) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'find'");
    }

    @Transactional
    public PostoCombustivel save(PostoCombustivel novoCombustivel) {
        return postoCombustivelRepository.save(novoCombustivel);
    }

    @Override
    public PostoCombustivel update(PostoCombustivel entityT, Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public void delete(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public List<PostoCombustivel> getPostoCombustiveisByPostoId(Long posto_id){
        return postoCombustivelRepository.getPostoCombustiveisByPostoId(posto_id);
    }

   
	
}
