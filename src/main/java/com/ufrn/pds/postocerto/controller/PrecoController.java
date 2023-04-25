package com.ufrn.pds.postocerto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ufrn.pds.postocerto.service.IPrecoService;
import com.ufrn.pds.postocerto.model.Preco;

@RestController
@RequestMapping("/preco")
public class PrecoController implements ICrudController<Preco, Long> {

    @Autowired
    private IPrecoService precoService;

    @GetMapping("/index")
    public String index(Model model) {
        model.addAttribute("usuarios", precoService.getAll());
        return "preco/index";
    }

    @GetMapping("/create")
    public String create(Model model) {
        return "/preco/create";
    }

    @PostMapping("/store")
    public String store(Preco entity) {
        precoService.save(entity);
        return "redirect:/preco/index";
    }

    @GetMapping("/{id}/show")
    public String show(Model model, @PathVariable("id") Long id) {
        model.addAttribute("usuario", precoService.find(id).get());
        return "/{id}/show";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") Long id) {
        model.addAttribute("usuario", precoService.find(id).get());
        return "combustivel/preco/edit";
    }

    @PutMapping("/{id}/update")
    public String update(Preco entity, @PathVariable("id") Long id) {
        precoService.update(entity, id);
        return "redirect:/preco/index";
    }

    @DeleteMapping("/{id}/delete")
    public String delete(@PathVariable("id") Long id) {
        precoService.delete(id);
        return "redirect:/preco/index";
    }
}
