package com.ufrn.pds.postocerto.service;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ufrn.pds.postocerto.model.Usuario;
import com.ufrn.pds.postocerto.repository.UsuarioRepository;

@Service
public class UsuarioService {

    @Autowired
    private final UsuarioRepository usuarioRepository;

    UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public List<Usuario> findAll() {
        return usuarioRepository.findAll();
    }

    public Usuario save(Usuario novoUsuario) {
        return usuarioRepository.save(novoUsuario);
    }

    public Optional<Usuario> findById(Long id) {
        return usuarioRepository.findById(id);
    }

    public Usuario update(Usuario usuarioAlterado, Long id) {
        Optional<Usuario> usuario = usuarioRepository.findById(id);
        usuario.get().setNome(usuarioAlterado.getNome());
        usuario.get().setLatitude(usuarioAlterado.getLatitude());
        usuario.get().setLongitude(usuarioAlterado.getLongitude());
        return usuarioRepository.save(usuario.get());
    }
}
