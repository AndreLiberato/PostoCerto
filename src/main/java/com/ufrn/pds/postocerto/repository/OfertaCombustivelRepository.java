package com.ufrn.pds.postocerto.repository;

import com.ufrn.pds.postocerto.model.OfertaCombustivel;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OfertaCombustivelRepository extends JpaRepository<OfertaCombustivel, Long>{

    public List<OfertaCombustivel> findByPostoId(Long postoId);

}
