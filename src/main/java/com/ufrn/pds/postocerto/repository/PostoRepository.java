package com.ufrn.pds.postocerto.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ufrn.pds.postocerto.model.Posto;

public interface PostoRepository extends JpaRepository<Posto, Long>{

}
