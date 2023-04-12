package com.ufrn.pds.postocerto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ufrn.pds.postocerto.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    
}
