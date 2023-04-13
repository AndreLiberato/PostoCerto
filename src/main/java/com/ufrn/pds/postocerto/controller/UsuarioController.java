package com.ufrn.pds.postocerto.controller;

import com.ufrn.pds.postocerto.model.Usuario;
import com.ufrn.pds.postocerto.service.UsuarioService;
import java.util.List;
import java.util.Optional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsuarioController {

    private final UsuarioService service;

    UsuarioController(UsuarioService service) {
        this.service = service;
    }

    @GetMapping("/usuario")
    public List<Usuario> all() {
        return service.findAll();
    }

    @PostMapping("/usuario")
    public Usuario save(@RequestBody Usuario novoUsuario) {
        return service.save(novoUsuario);
    }

    @GetMapping("/usuario/{id}")
    public Optional<Usuario> findById(@PathVariable long id) {
        return service.findById(id);
    }

    @PutMapping("/usuario/{id}")
    public Usuario update(@RequestBody Usuario usuarioAlterado, @PathVariable Long id) {
        return service.update(usuarioAlterado, id);
    }
} 
