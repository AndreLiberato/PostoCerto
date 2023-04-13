package com.ufrn.pds.postocerto.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.web.bind.annotation.*;
import com.ufrn.pds.postocerto.model.Posto;
import com.ufrn.pds.postocerto.service.PostoService;

@RestController
public class PostoController {

    private final PostoService service;

    PostoController(PostoService service) {
        this.service = service;
    }
    @GetMapping("/posto")
    public List<Posto> all() {
        return service.findAll();
    }

    @PostMapping("/posto")
    public Posto save(@RequestBody Posto novoPosto) {
        return service.save(novoPosto);
    }

    @GetMapping("/posto/{id}")
    public Optional<Posto> findById(@PathVariable long id) {
        return service.findById(id);
    }

    @PutMapping("/posto/{id}")
    public Posto update(@RequestBody Posto postoAlterado, @PathVariable Long id) {
        return service.update(postoAlterado, id);
    }
    @GetMapping("/posto/proximos")
    public List<Posto> getProximos() {
        return service.mostrarPostosMaisProximos(-5.7944, -35.2110);
    }
}
