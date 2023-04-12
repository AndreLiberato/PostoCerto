package com.ufrn.pds.postocerto.controller;

import com.ufrn.pds.postocerto.model.Usuario;
import com.ufrn.pds.postocerto.repository.UsuarioRepository;

import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UsuarioController {

    private final UsuarioRepository repository;

    UsuarioController(UsuarioRepository repository){
        this.repository = repository;
    }

    //@PostMapping("/usuario")
    @RequestMapping(value = "/usuario", method = {RequestMethod.POST})
    Usuario novoUsuario(@RequestBody Usuario novoUsuario)
    {
        return repository.save(novoUsuario);
    }

    @GetMapping("/usuario/{id}")
    Optional<Usuario> consultar(@PathVariable Long id){
        return repository.findById(id);
            //.orElse(ResponseEntity.notFound().build() );
    }

}
