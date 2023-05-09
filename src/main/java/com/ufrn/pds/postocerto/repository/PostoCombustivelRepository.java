package com.ufrn.pds.postocerto.repository;

import com.ufrn.pds.postocerto.model.PostoCombustivel;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PostoCombustivelRepository extends JpaRepository<PostoCombustivel, Long>{
    
    @Query("select p from PostoCombustivel p where p.posto.id=?1")
    public List<PostoCombustivel> getPostoCombustiveisByPostoId(Long posto_id);
  
}
