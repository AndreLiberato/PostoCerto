package com.ufrn.pds.postocerto.controller;

import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.ufrn.pds.postocerto.model.Posto;
import com.ufrn.pds.postocerto.service.PostoService;
import org.springframework.ui.Model;

@Controller
@RequestMapping("/posto")
public class PostoController implements CrudController<Posto, Long> {

    private final PostoService _postoService;

    PostoController(PostoService postoService) {
        this._postoService = postoService;
    }

    @Override
    @GetMapping()
    public String index(Model model) {
        List<Posto> postos = _postoService.all();
        model.addAttribute("postos", postos);
        return "posto/index";
    }

    @Override
    @GetMapping("/create")
    public String create(Model model) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'create'");
    }

    @Override
    @PostMapping()
    public String store(@ModelAttribute Posto entity) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'store'");
    }

    @Override
    @GetMapping("/{id}")
    public String show(Model model, @PathVariable Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'show'");
    }

    @Override
    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'edit'");
    }

    @Override
    @PutMapping("/{id}")
    public String update(@ModelAttribute Posto entity, @PathVariable Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }
}
