package com.ufrn.pds.postocerto.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ufrn.pds.postocerto.model.Combustivel;
import com.ufrn.pds.postocerto.model.Posto;
import com.ufrn.pds.postocerto.service.CombustivelService;


@RestController
public class CombustivelController {
    
    private final CombustivelService service;

    CombustivelController(CombustivelService service) {
        this.service = service;
    }
    
    @GetMapping("/combustivel")
    public List<Combustivel> all() {
        return service.findAll();
    }
    
    @PostMapping("/combustivel")
    public Combustivel save(@RequestBody Combustivel novoCombustivel) {
        return service.save(novoCombustivel);
    }
    
    @GetMapping("/combustivel/{id}")
    public Optional<Combustivel> findById(@PathVariable long id) {
        return service.findById(id);
    }
    
    @PutMapping("/combustivel/{id}")
    public Combustivel upadate(@RequestBody Combustivel CombustivelAlterado, @PathVariable long id) {
    	return service.update(CombustivelAlterado, id);
    }
    
}
