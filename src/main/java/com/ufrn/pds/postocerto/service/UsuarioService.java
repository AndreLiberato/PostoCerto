package com.ufrn.pds.postocerto.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ufrn.pds.postocerto.repository.UsuarioRepository;

@Service
public class UsuarioService {

  @Autowired
	private UsuarioRepository usuarioRepository;
}
