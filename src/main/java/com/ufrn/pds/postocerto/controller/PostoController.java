package com.ufrn.pds.postocerto.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.ufrn.pds.postocerto.model.Posto;
import com.ufrn.pds.postocerto.service.IPostoService;
import org.springframework.ui.Model;

@Controller
@RequestMapping("/posto")
public class PostoController implements CrudController<Posto, Long> {

    @Autowired()
    private IPostoService postoService;

    @GetMapping()
    public String index(Model model) {
        List<Posto> postos = postoService.getAll();
        model.addAttribute("postos", postos);
        return "posto/index";
    }

    @GetMapping("/create")
    public String create(Model model) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'create'");
    }

    @PostMapping()
    public String store(@ModelAttribute Posto entity) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'store'");
    }

    @GetMapping("/{id}")
    public String show(Model model, @PathVariable(value = "id") Long id) {
        Optional<Posto> posto = postoService.find(id);
        if (!posto.isPresent()) {
            model.addAttribute("error", "Entidade não encontrada!");
        } else {
            model.addAttribute("posto", posto.get());
        }
        return "posto/show";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'edit'");
    }

    @PutMapping("/{id}")
    public String update(@ModelAttribute Posto entity, @PathVariable Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }
}
