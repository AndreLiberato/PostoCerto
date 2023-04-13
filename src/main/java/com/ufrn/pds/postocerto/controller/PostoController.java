package com.ufrn.pds.postocerto.controller;

import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ufrn.pds.postocerto.model.Posto;
import com.ufrn.pds.postocerto.service.PostoService;

@RestController
public class PostoController {

    private final PostoService service;

    PostoController(PostoService service) {
        this.service = service;
    }

    @GetMapping("/posto/proximos")
    public List<Posto> getProximos() {
        return service.mostrarPostosMaisProximos(-5.7944, -35.2110);
    }
}
