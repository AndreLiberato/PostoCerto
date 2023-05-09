package com.ufrn.pds.postocerto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.ufrn.pds.postocerto.model.Posto;
import com.ufrn.pds.postocerto.service.IPostoService;

@RestController
@RequestMapping("api/posto")
public class PostoRestController  {

    @Autowired()
    private IPostoService postoService;

    @GetMapping("/posto")
    public List<Posto> all() {
        return postoService.getAll();
    }

    @PostMapping("/posto")
    public Posto save(@RequestBody Posto novoPosto) {
        return postoService.save(novoPosto);
    }
}
