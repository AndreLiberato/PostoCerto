package com.ufrn.pds.postocerto.service.implementation;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ufrn.pds.postocerto.exception.EntityNotFoundException;
import com.ufrn.pds.postocerto.model.Usuario;
import com.ufrn.pds.postocerto.repository.UsuarioRepository;
import com.ufrn.pds.postocerto.service.IUsuarioService;

import jakarta.transaction.Transactional;

@Service
public class UsuarioService implements IUsuarioService{

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Usuario> getAll() {
        return usuarioRepository.findAll();
    }

    public Optional<Usuario> find(Long id) {
        return usuarioRepository.findById(id);
    }

    public List<Usuario> find(List<Long> id) {
        return usuarioRepository.findAllById(id);
    }

    @Transactional
    public Usuario save(Usuario novo) {
        return usuarioRepository.save(novo);
    }
    
    @Transactional
    public Usuario update(Usuario novo, Long id) {
        Optional<Usuario>  existingUsuario = usuarioRepository.findById(id);
        if (existingUsuario.isPresent()){
            existingUsuario.get().setNome(novo.getNome());
            existingUsuario.get().setLatitude(novo.getLatitude());
            existingUsuario.get().setLongitude(novo.getLongitude());
        } else {
            throw new EntityNotFoundException(id);
        }
        return usuarioRepository.save(existingUsuario.get());
    }

    @Transactional
    public void delete(Long id) { 
        Optional<Usuario> usuario = usuarioRepository.findById(id);
        if (usuario.isPresent()) {
            usuarioRepository.delete(usuario.get());
            ;
        } else {
            throw new EntityNotFoundException(id);
        }    
    }
}
