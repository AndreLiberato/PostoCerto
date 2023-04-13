package com.ufrn.pds.postocerto.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ufrn.pds.postocerto.model.Combustivel;
import com.ufrn.pds.postocerto.model.Preco;
import com.ufrn.pds.postocerto.service.PrecoService;
import com.ufrn.pds.postocerto.service.UsuarioService;

@RestController
public class PrecoController {
    
    private final PrecoService service;
    
    PrecoController(PrecoService service) {
        this.service = service;
    }
    
    @GetMapping("/preco")
    public List<Preco> all() {
        return service.findAll();
    }
    
    @PostMapping("/preco")
    public Preco save(@RequestBody Preco novoPreco) {
        return service.save(novoPreco);
    }
    
    @GetMapping("/preco/{id}")
    public Optional<Preco> findById(@PathVariable long id) {
        return service.findById(id);
    }
    
    @PutMapping("/preco/{id}")
    public Preco upadate(@RequestBody Preco PrecoAlterado, @PathVariable long id) {
    	return service.update(PrecoAlterado, id);
    }
}
