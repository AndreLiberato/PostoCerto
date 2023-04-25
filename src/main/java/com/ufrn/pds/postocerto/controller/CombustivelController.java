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
import com.ufrn.pds.postocerto.model.Combustivel;
import com.ufrn.pds.postocerto.service.ICombustivelService;

@RestController
@RequestMapping("/posto")
public class CombustivelController implements ICrudController<Combustivel, Long> {

    @Autowired
    private ICombustivelService combustivelService;

    @GetMapping("/combustivel")
    public String index(Model model) {
        model.addAttribute("usuarios", combustivelService.getAll());
        return "combustivel/index";
    }

    @GetMapping("/create")
    public String create(Model model) {
        return "/combustivel/create";
    }

    @PostMapping("/store")
    public String store(Combustivel entity) {
        combustivelService.save(entity);
        return "redirect:/combustivel/index";
    }

    @GetMapping("/{id}/show")
    public String show(Model model, @PathVariable("id") Long id) {
        model.addAttribute("usuario", combustivelService.find(id).get());
        return "combustivel/show";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") Long id) {
        model.addAttribute("usuario", combustivelService.find(id).get());
        return "combustivel/edit";
    }

    @PutMapping("{id}/update")
    public String update(Combustivel entity, @PathVariable("id") Long id) {
        combustivelService.update(entity, id);
        return "redirect:/combustivel/index";
    }

    @DeleteMapping("/{id}/delete")
    public String delete(Long id) {
        combustivelService.delete(id);
        return "redirect:/combustivel/index";
    }
}
