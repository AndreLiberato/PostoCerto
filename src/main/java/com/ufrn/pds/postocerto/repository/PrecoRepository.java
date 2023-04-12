package com.ufrn.pds.postocerto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ufrn.pds.postocerto.model.Preco;

public interface PrecoRepository extends JpaRepository<Preco, Long>{
  
}
